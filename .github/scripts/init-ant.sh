#!/usr/bin/env bash

# Script to manually install optional Ant dependencies not found in Github Actions Ant install

set -euo pipefail

readonly ANT_LIB_DIR="${HOME}/.ant/lib"
readonly MAVEN_CENTRAL_URL="https://repo1.maven.org/maven2"
readonly ANT_VERSION_REGEX="Apache Ant\(TM\) version ([0-9]+\.[0-9]+\.[0-9]+) compiled"

# Ant dependencies to manually install.
# Format is Gradle-style coordinates without version
readonly ANT_DEPENDENCIES=(
  "org.apache.ant:ant-junitlauncher"
)

function getAntVersion() {
  local antVersionLine
  local antVersion
  antVersionLine=$(ant -version)
  # Run a regex match on the Ant version line. No need for an if statement as
  # all we are doing is extracting the version from the string
  [[ ${antVersionLine} =~ ${ANT_VERSION_REGEX} ]]
  antVersion="${BASH_REMATCH[1]}"
  echo "${antVersion}"
}

function initAntLibDir() {
  mkdir -p "${ANT_LIB_DIR}"
}

function downloadDependency() {
  local dependencyCoordinates="$1"
  local antVersion="$2"
  local dependencyPath
  local dependencyName
  echo "Downloading ${dependencyCoordinates} from Maven Central"
  dependencyPath=$(echo "${dependencyCoordinates}" | sed 's/[:.]/\//g')
  dependencyName=$(echo "${dependencyCoordinates}" | cut -d':' -f 2)
  wget "${MAVEN_CENTRAL_URL}/${dependencyPath}/${antVersion}/${dependencyName}-${antVersion}.jar" -P "${ANT_LIB_DIR}"
}

function retrieveDependencies() {
  local antVersion="$1"
  for depCoordinates in "${ANT_DEPENDENCIES[@]}"; do
    downloadDependency "${depCoordinates}" "${antVersion}"
  done
}

antVersion=$(getAntVersion)
echo "Found Ant version ${antVersion}"
initAntLibDir
retrieveDependencies "${antVersion}"

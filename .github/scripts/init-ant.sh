#!/usr/bin/env bash

set -euf pipefail

readonly ANT_VERSION_REGEX="Apache Ant\(TM\) version ([0-9]+\.[0-9]+\.[0-9]+) compiled"

function getAntVersion() {
  local antVersionLine
  local antVersion
  antVersionLine=$(ant -version)
  [[ ${antVersionLine} =~ ${ANT_VERSION_REGEX} ]]
  antVersion="${BASH_REMATCH[1]}"
  echo "${antVersion}"
}

function downloadJunitLauncher() {
  local antVersion="$1"
  mkdir -p "${HOME}/.ant/lib"
  cd "${HOME}/.ant/lib"
  wget "https://repo1.maven.org/maven2/org/apache/ant/ant-junitlauncher/${antVersion}/ant-junitlauncher-${antVersion}.jar"
}

antVersion=$(getAntVersion)
downloadJunitLauncher "${antVersion}"

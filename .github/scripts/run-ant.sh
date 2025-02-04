#!/bin/sh

ant -version
ant -noinput -logger org.apache.tools.ant.NoBannerLogger "$@"

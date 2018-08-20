#!/bin/bash -e

unset JOVL_VERSION KZOP_VERSION BUILD_SCRIPT_DIR
REPO="http://localhost:8000"
PUBLISH=false
HELP=false

function getargs() {
    longopts="jovl-version:,kzop-version:,repo:,publish,build-scripts:,help"
    shortopts="j:k:r:pb:h"
    progname=$(basename "$0")
    OPTS=$(getopt -n "$progname" -o "$shortopts" --long "$longopts" -- "$@")
    if [[ $? -ne 0 ]] ; then
	return 1
    fi
    eval set -- "$OPTS"
    while [[ $# -gt 0 ]]; do
	case "$1" in
	    -k|--kzop-version)
		KZOP_VERSION="$2"; shift 2 ;;
	    -j|--jovl-version)
		JOVL_VERSION="$2"; shift 2 ;;
	    -r:--repo)
		LOCAL_REPO="$2"; shift 2 ;;
	    -p|--publish)
		PUBLISH=true ; shift ;;
	    -b|--build-scripts)
		BUILD_SCRIPT_DIR="$2"; shift 2 ;;
	    -h|--help)
		HELP=true ; shift ;;
	    --)
		shift ;;
	    *)
		echo "Unrecognized arg: '$1'"; return 1 ;;
	esac
    done
    if $HELP ; then
	return 1
    fi
    if $PUBLISH && [[ -z $BUILD_SCRIPT_DIR ]] ; then
	echo "Must specify build-script directory with -b or --build-scripts option if publishing"
	return 1
    fi
    if [[ -z $JOVL_VERSION || -z $KZOP_VERSION ]] ; then
	if [[ -z $KZOP_VERSION ]] ; then
	    echo "Must specify KaiZen OpenApiParser version with -k or --kzop-version option"
	fi
	return 1
	if [[ -z $JOVL_VERSION ]] ; then
	    echo "Must specify JsonOverlay version with -j or --jovl-version option"
	fi
    fi
}

function usage() {
    cat <<-END_OF_USAGE

	Usage: $0 <options>
	Builds a p2 repo for KZOP, including JsonOverlay and other dependencies, and
	optionally publishes as an update site.

	Options: (* marks required option)
	* -k or --kzop-version - specify full version number of KZOP to package
	* -j or --jovl-version - specify full version number of JsonOverlay to package
	  -r or --repo - specify maven repo URL where indicated versions are available, if
	     they are not in maven central. Defaults to http://localhost:8000
	     This script will attempt to stage the indicated versions to your
	     lcoal maven repo cache prior to building the bundle.
	     Hint: start a web server that delivers files from your .m2.repository
	     directory, e.g. using "python -m SimpleHTTPServer" 
	     or "python3 -m http.server"
	  -p or --publish - publish the newly built update site
	* -b or --build-scripts - speicfy location of RepreZen build scripts, including 
	     the "publish" script. This is required only if "-p" is specified
	  -h or --help - print this message and do nothing else
END_OF_USAGE
}

function main() {
    retrieveArtifacts
    buildSite
    if $PUBLISH ; then
	publishSite
    fi
}

function retrieveArtifacts() {
    mvn dependency:get -DrepoUrl="$REPO" \
	-Dartifact="com.reprezen.kaizen:openapi-parser:$KZOP_VERSION"
    mvn dependency:get -DrepoUrl="$REPO" \
	-Dartifact="com.reprezen.jsonoverlay:jsonoverlay:$JOVL_VERSION"
}

function buildSite() {
    mvn clean  p2:site -Dkzop-version="$KZOP_VERSION" -Djovl-version="$JOVL_VERSION"
}

function publishSite() {
    local pub="$BUILD_SCRIPT_DIR/publish"
    "$pub" -w -c -d "$KZOP_VERSION" \
	   --ws-host wsw \
	   --ws-root /data/products/kaizen/openapi-parser/updates \
	   --local-root target/repository \
	   \*
		       
}
if ! getargs "$@" ; then
    usage
    exit 1
fi

main

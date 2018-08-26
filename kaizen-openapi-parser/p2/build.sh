#!/bin/bash -e

unset JOVL_VERSION KZOP_VERSION BUILD_SCRIPT_DIR
KZOP_REPO="http://localhost:8000"
JOVL_REPO="http://localhost:8000"
PUBLISH=false
LATEST=false
HELP=false

function getargs() {
    longopts="jovl-version:,kzop-version:,kzop-repo:,jovl-repo:,publish,build-scripts:,latest,help"
    shortopts="j:k:K:J:pb:lh"
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
	    -K|--kzop-repo)
		KZOP_REPO="$2"; shift 2 ;;
	    -J|--jovl-repo)
		JOVL_REPO="$2"; shift 2 ;;
	    -p|--publish)
		PUBLISH=true ; shift ;;
	    -b|--build-scripts)
		BUILD_SCRIPT_DIR="$2"; shift 2 ;;
	    -l|--latest)
		LATEST=true ; shift ;;
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
    if $LATEST && ! $PUBLISH ; then
	echo "Must specify --publish if --latest is used"
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
	  -K or --kzop-repo - specify maven repo URL where indicated KXOP version is
	     available, if is not in maven central
	  -J or --jovl-repo - specify maven repo URL where indicated JsonOverlay
	     version is available, if is not in maven central
	  -p or --publish - publish the newly built update site
	* -b or --build-scripts - speicfy location of RepreZen build scripts, including 
	     the "publish" script. This is required only if "-p" is specified
	  -l or --latest - publish to "latest" site in addition to site named for 
	     version (--publish must also be specified) 
	  -h or --help - print this message and do nothing else
	
	Note on repos: Both ---kzop-repo and --jovl-repo default to
	http://localhost:8000, so if you already have the needed versions in
	your local maven repo cache, you can set up a simple HTTP server to
	serve those files and go with these defaults. But you can also explicitly
	specify, e.g., staging repository URLs. 

	To use the defualt repo, you can use either of the following to launch
	a local web server, after positioning yourself in the root of your
	local maven cacche (typically .m2/repository in your home directory):
	  * python -m SimpleHTTPServer
	  * python3 -m http.server
END_OF_USAGE
}

function main() {
    retrieveArtifacts
    buildSite
    if $PUBLISH ; then
	publishSite
	if $LATEST ; then
	    publishLatest
	fi
    fi
}

function retrieveArtifacts() {
    mvn dependency:get -DrepoUrl="$KZOP_REPO" \
	-Dartifact="com.reprezen.kaizen:openapi-parser:$KZOP_VERSION"
    mvn dependency:get -DrepoUrl="$JOVL_REPO" \
	-Dartifact="com.reprezen.jsonoverlay:jsonoverlay:$JOVL_VERSION"
}

function buildSite() {
    mvn clean  p2:site \
	-Dkzop-version="$KZOP_VERSION" -Dkzop-repo="$KZOP_REPO" \
	-Djovl-version="$JOVL_VERSION" -Djovl-repo="$JOVL_REPO"
}

function publishSite() {
    publish "$KZOP_VERSION"
}

function publishLatest() {
    publish "latest"
}

function publish() {
    local pub="$BUILD_SCRIPT_DIR/publish"
    "$pub" -w -c -d "$1" \
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

#!/bin/bash

DIR=$(dirname $0);

cd "$DIR";

if [ ! -e .gradle ]; then
	mkdir .gradle;
fi;

for i in common-bom provider-bom; do
	pushd "$i";
	if [ -f "pom.xml" ]; then
		echo "Building $i...";
		mvn install;
	else
		echo "Skipping $i...";
	fi;
	popd;
done;

for i in fizz-provider buzz-provider fizzbuzz-provider fizzbuzz-service; do
	pushd "$i";
	if [ -f "build.gradle" ]; then
		echo "Building $i...";
		./gradlew clean test install;
	else
		echo "Skipping $i...";
	fi;
	popd;
done;

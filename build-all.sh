#!/bin/bash

DIR=$(dirname $0);

cd "$DIR";

if [ ! -e .gradle ]; then
	mkdir .gradle;
fi;

for i in *-bom; do
	pushd "$i";
	mvn install;
	popd;
done;

for i in fizz-provider buzz-provider fizzbuzz-provider fizzbuzz-service; do
	pushd "$i";
		./gradlew clean test install;
	popd;
done;

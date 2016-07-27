#!/bin/bash

DIR=$(dirname $0);

cd "$DIR";

if [ ! -e .gradle ]; then
	mkdir .gradle;
fi;

for i in fizz-provider buzz-provider fizzbuzz-provider fizzbuzz-service; do
	pushd "$i";
	if [ -f "build.gradle" ]; then
		echo "Building $i...";
		./gradlew cleanEclipse eclipse;
	else
		echo "Skipping $i...";
	fi;
	popd;
done;

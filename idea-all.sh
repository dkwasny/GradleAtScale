#!/bin/bash

DIR=$(dirname $0);

cd "$DIR";

if [ ! -e .gradle ]; then
	mkdir .gradle;
fi;

for i in fizz-provider buzz-provider fizzbuzz-provider fizzbuzz-service; do
	pushd "$i";
		./gradlew cleanIdea idea;
	popd;
done;

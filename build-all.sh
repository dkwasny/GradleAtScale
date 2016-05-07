#!/bin/bash

for i in *-bom; do
	pushd $i;
	mvn install;
	popd;
done;

for i in fizz-provider buzz-provider fizzbuzz-provider fizzbuzz-service; do
	pushd $i;
		./gradlew clean test install;
	popd;
done;

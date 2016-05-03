#! /bin/bash

cd book-person
mvn clean install
cd ../book-store
mvn clean package
mkdir dist
cp target/*.jar dist
./bin/start.sh

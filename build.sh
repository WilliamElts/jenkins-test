#! /bin/bash

cd book-person
mvn clean install
cd ../book-store
mvn clean package
if [ ! -d dist ]; then
  mkdir dist
fi
cp target/*.jar dist
./bin/start.sh

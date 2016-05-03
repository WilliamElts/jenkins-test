#! /bin/bash

cd book-person
mvn clean install
cd ../book-store
mvn clean package


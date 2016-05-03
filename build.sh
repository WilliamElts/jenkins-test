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

scp -r dist conf bin 104.197.3.199:/home/william/tmp
echo "Running on the server: "
ssh 104.197.3.199 "bash /home/william/tmp/bin/start.sh"

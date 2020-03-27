#!/bin/zsh
# run mongo in docker and run web servic on host
# Author: @david.zhao
# Date: 2020-03-26

echo --run mongo and mongo express
docker-compose up --detach

echo -- run web service on host --
gradle clean bootRun

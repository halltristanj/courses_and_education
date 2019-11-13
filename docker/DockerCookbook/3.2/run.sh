#!/bin/bash

echo "Running flask"

python /tmp/hello.py &
python /tmp/hello-different-port.py 

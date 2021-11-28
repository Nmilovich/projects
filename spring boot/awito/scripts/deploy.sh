#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/id_rsa \
    target/awito-1.0-SNAPSHOT.jar \
    nikolas@192.168.1.51:/home/nikolas/

echo 'Restart server...'

ssh -i ~/.ssh/id_rsa nikolas@192.168.1.51 << EOF
pgrep java | xargs kill -9
nohup java -jar awito-1.0-SNAPSHOT.jar > log.txt &
EOF

echo 'Bye'
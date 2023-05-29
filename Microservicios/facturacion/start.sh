#!/bin/ash
while ! nc -z eureka 8761 ; do
    echo "Waiting for the Eureka Server"
    sleep 3
done


java -jar app.jar
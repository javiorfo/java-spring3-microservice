#! /bin/bash

if [ "$1" = "d" ]; then
   action="down" 
   label="Deleting" 
else
   action="up" 
   label="Creating" 
fi

echo "$action"

echo ""
echo "========================================================="
echo "=              Docker Container Creation                ="
echo "========================================================="
echo ""

echo "$label Postgres container for java-spring3-microservice..."
docker-compose -f docker/postgres/docker-compose.yml "$action" -d

echo "$label Postgres and Keycloak..."
docker-compose -f docker/keycloak/docker-compose.yml "$action" -d

echo "$label Jaeger container..."
docker-compose -f docker/jaeger/docker-compose.yml "$action" -d

echo "$label Logstash, Elasticsearch and Kibana container..."
docker-compose -f docker/ELK/docker-compose.yml "$action" -d

echo "Done!"



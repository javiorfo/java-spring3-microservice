# Command
```bash
docker-compose up -d
```

## Enter database
```bash
docker exec -it db_mongo mongosh --host localhost -u admin -p admin --authenticationDatabase admin db_dummy
```

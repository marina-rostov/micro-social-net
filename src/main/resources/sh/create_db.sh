docker run --name postgress-db -e POSTGRES_DB=test-db -e POSTGRES_USER=test-user -e POSTGRES_PASSWORD=test-pass -v C:\__ws_java\micro-social-net\src\main\resources\sh\sql:/docker-entrypoint-initdb.d -v C:\tmp\postgres-data:/var/lib/postgresql/data -p 5002:5432 -d postgres:14
docker run --name pgadmin -e PGADMIN_DEFAULT_EMAIL=root@admin.org -e PGADMIN_DEFAULT_PASSWORD=pgpass -p 8888:80 -d dpage/pgadmin4:6.9

docker network create db-net
docker network connect db-net postgres-db
docker network connect db-net pgadmin
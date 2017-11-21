call docker build -f ./Dockerfile -t dockesql .
call docker run -p 3306:3306 --name dockestions -e MYSQL_ROOT_PASSWORD=Titkos123 -d dockesql:latest
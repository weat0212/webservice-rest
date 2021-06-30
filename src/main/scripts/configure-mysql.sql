# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
# Create Databases

CREATE DATABASE web_app;
CREATE USER 'andy'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT ON web_app.* to 'andy'@'localhost';
GRANT INSERT ON web_app.* to 'andy'@'localhost';
GRANT DELETE ON web_app.* to 'andy'@'localhost';
GRANT UPDATE ON web_app.* to 'andy'@'localhost';
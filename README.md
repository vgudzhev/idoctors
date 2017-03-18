#Getting started:

## Install java
sudo apt-get install oracle-java8-installer

## Install mysql
sudo apt-get update
sudo apt-get install mysql-server
User - root / Password - admin

### Create initial db
mysql -u root -padmin

(load initial sql scripts)

## Clone the project 
git clone https://github.com/vgudzhev/idoctors.git

## Build and run the project
mvn clean install

mvn spring-boot:run

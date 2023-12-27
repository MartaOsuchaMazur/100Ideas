# 100Ideas
The 100Ideas project is a site with interesting questions and answers.
## Table of contents
* [General information](#general-information)
* [Technologies](#technologies)
* [Setup](#setup)
## General information
The 100Ideas project was made as part of the Effective Web Applications program by Tomasz Wolinski. The site allows logged-in and non-logged-in users to add new questions and get answers to them. An Administration Panel has also been implemented to manage the content of the site. The project is in the development stage.
## Technologies
Technologies used in the project:
* Java 21
* Spring Boot 3.1.5
* Thymleaf
* Maven
* Hibernate
* Docker 24.0.7
* PostreSQL 16.0
* Lombok
* AdminLTE
* JUnit5
## Setup
Before run application you should configurate your database and db server in few step:
* Create database connection with Docker pasting in command line:
  <br>`docker run --name postgres -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres`
* Connect with server:
  <br>Login: postgres
  <br>Password: password
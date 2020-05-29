# Select-60321
## Part 1 - Introduction to this project

This is the second project of the course CS307 (Database Principle) in Southern University of Science and Technology (SUSTech), Shenzhen.

The main part is to implement the simple functions like the 12306 website. 

Some of the data are from https://github.com/MogicianXD/TrainCrawler

Our group consists of 2 people: **@Tloops** and **@lethal233**, both sophomore in 2020 spring.

These are our group results.

Please enjoy!



## Part 2 - How to test our result

1. First, you need to run all the `.sql` files in path `data/sql`. (We use PostgreSQL as our database when developing the project, if you are using other databases, maybe you need to modify a lot both in sql and in the Java program)

2. Second, you need to open Project-Final-version as an IDEA project (or other IDE). Or, you can just run `Demo59Application.java` under the path `Project-Final-version\src\main\java\com\example\demo59`. But remember to modify `application-dev.yml` under the path `Project-Final-version\src\main\resources` like this ↓.

```yml
server:
  port: 9008
spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:<the port of your database>/postgres
    username: <your database username>
    password: <your password>
    ...
```

3. At last, visit `localhost:9008/user/logIn` in your browser.

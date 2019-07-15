# Java apps
This repository contains three java apps.
- [Java Grep app](#grep) - Implementation of the grep command in java. The app searches for a text pattern recursively in a given directory and outputs all matched lines to a file.
- [JDBC](#jdbc) - Example of Java Database Connectivity (JDBC) API usage. This app uses Data Access Object (DAO) to read and manage data from a Postgre database.
- [Twitter](#twitter)- Implementation of a Twitter client that can post new tweets, show old tweets by given id and delete tweets by id.
<a name="grep"></a>
# Java Grep app
### Getting Started
For the Java Grep app, no installations are required. All you need is to execute the code using Java 8, and to include all the dependencies on the pom.xml file.
This app is divided into three files:
 - `JavaGrep` is the application interface. Contains methods and attributes.
 - `JavaGrepImp` is the implementation of `JavaGrep`. Implements all methods and adds new ones.
 - `JavaGrepApp` provides the main method. It is used to execute the application.

### Usage
The Java Grep app searches for a regular expression on all files inside a base directory and outputs all the lines where the regular expression was found to a file.
To execute the `JavaGrepApp`, you must pass the parameters below in order:
 1. Regular expression
 2. Base directory
 3. Output file

E.g., To search for the word "data" on all files on the /user/app directory and output the results to /tmp/grep.out :
 `java JavaGrepApp .\*data.\* /user/app /tmp/grep.out`
 In the end, the app will display a message with all files that it was not able to read.
<a name="jdbc"></a>
 # JDBC 
  ### Getting Started
 Access the README file on `/jdbc_sql_ddl` and follow it to create the hplussport database and necessary tables.
![image](https://drive.google.com/uc?export=view&id=1AwyghOuU2UBMr6_ysmbk2eKSufjbwx6_)
  
  JDBC java app is divided into nine files:
 1. `JDBCExecutor` contains the main method and executes all commands.
 2. `/util/DataAccessObject` is the DAO interface
 3. `/util/DataTransferObject` is the DTO interface
 4. `DatabaseConnectionManager` handles the connection to the Postgres database using JDBC
 5. `Customer` implements the customer class
 6. `CustomerDAO`creates the data access object to the class customer
 7. `OrderLine` implements the OredrLine class
 8. `Order` implements the Order class
 9. `OrderDAO` creates the data access object to the class Order

### Usage
The app expects the database connection variables (PGHOST=host address, PGUSER=username, PGPASSWORD=yourpassword) to be passed as environmental variables or as arguments on the previous order.
E.g.,`/jdbc/java JDBCExecutor localhost postgres 1234`

You will be able to call all methods on CustomerDAO and OrderDAO from `JDBCExecutor` , using the main method. You will notice that it already contains a few examples.

 <a name="twitter"></a>
 # Twitter
 ### Getting Started
 For the Twitter app, no installations are required. You need to execute the code using Java 8, and to include all the dependencies on the pom.xml file.
 You will also need to get a twitter developer account:[https://developer.twitter.com/](https://developer.twitter.com/). 
 With you twitter developer account created, set your consumerKey, consumerSecret, accessToken and tokenSecret as enviromental variables.
 
 The app is divided as following:
![image](https://drive.google.com/uc?export=view&id=1_RH6sYWUKTJ6hStQWGrE5zPPkxRRPPCn)
 twitter
   dao
CrdRepository.class
- `ApacheHttpHelper` implements `HttpHelper`. It is responsible for the connection with the Twitter Api.
TwitterRestDao
dto
Coordinates.class
Entities.class
Hashtag.class
Tweet.class
UserMention.class
JsonParser.class

TwitterApiTest.class
service
TwitterService.class
TwitterServiceImp.class
spring
TwitterCLIBean.class
TwitterCLIComponentScan.class
TwitterCLISpringBoot.class
TwitterCLI.class
TwitterCLIRunner.class
util
TwitterUtil.class

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE3NjAxMzc5MiwxOTE3Mzk5Mzg4LC0xMz
c1MzUyNTQ1LC0zOTA5NTkxMjcsLTc0NTY4NjcwOCwxNDQ1ODIx
NjQ3LC0xNTEyODk5Mzg2LDExMDkxMTUxMTQsLTcwNDIzMjQ5Ny
wtMTY0NzI3NzU5MiwtMTI5MjkxNjIxMiw4NzMxMTEwMDMsLTE0
Mjk1MjU0MTYsLTIwODEzNDQ0MDAsLTQ2NzU2OTk4OSwxODY3MT
QxNzI3LC0xNjk4ODAxMjU3LDIwNDE0NDI5NjVdfQ==
-->
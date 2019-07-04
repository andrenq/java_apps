# Java apps
This repository contains three java apps.
- [Java Grep app](#grep) - Implementation of the grep command in java. The app searches for a text pattern recursively in a given directory and outputs all matched lines to a file.
- [JDBC](#jdbc) - Example of Java Database Connectivity (JDBC) API usage. This app uses Data Access Object (DAO) to read and manage data from a Postgre database.
- [Twitter](#twitter)- 
<a name="grep"></a>
# Java Grep app
### Getting Started
For the Java Grep app, no installations are required. All you need is to execute the code using Java 8.

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
![image](https://drive.google.com/uc?export=view&id=1DvVW11_Hclm7Yhe90woBky0K2UUbrpk3)
  
  JDBC java app is divided into nine files:
 1. `JDBCExecutor` contains the main method, and executes all commands.
 2. `/util/DataAccessObject` is the DAO interface
 3. `/util/DataTransferObject` is the DTO interface
 4. `DatabaseConnectionManager` handles the connection to the Postgres database using JDBC
 5. `Customer` implements the customer class
 6. `CustomerDAO`creates the data access object to the class customer
 7. `OrderLine` implements the OredrLine class
 8. `Order` implements the Order class
 9. `OrderDAO` creates the data access object to the class Order

### Usage
The app expects the database connection variables (PGHOST=host adress , PGUSER=username, PGPASSWORD=yourpassword) to be passed as enviromental variables or as arguments on the previous order.
E.g.,`/jdbc/java JDBCExecutor localhost postgres 1234`
You will be able to call all methds on CustomerDAO and OrderDAO from `JDBCExecutor` , using the main method. You will notece that the main method already contain a few examples.


 <a name="twitter"></a>
 # Twitter
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTM5MDk1OTEyNywtNzQ1Njg2NzA4LDE0ND
U4MjE2NDcsLTE1MTI4OTkzODYsMTEwOTExNTExNCwtNzA0MjMy
NDk3LC0xNjQ3Mjc3NTkyLC0xMjkyOTE2MjEyLDg3MzExMTAwMy
wtMTQyOTUyNTQxNiwtMjA4MTM0NDQwMCwtNDY3NTY5OTg5LDE4
NjcxNDE3MjcsLTE2OTg4MDEyNTcsMjA0MTQ0Mjk2NV19
-->
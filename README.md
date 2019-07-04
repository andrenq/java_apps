# Java apps
This repository contains three java apps.
- [Java Grep app](#grep) - Implementation of the grep command in java. The app searches for a text pattern recursively in a given directory and outputs all matched lines to a file.
- JDBC - Example of Java Database Connectivity (JDBC) API usage. This app uses Data Access Object (DAO) to read and manage data from a Postgre database.
- Twitter - 
<a name="grep">
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
 </a>
 # JDBC 
  ### Getting Started
 Access the README file on `/jdbc_sql_ddl` and follow it to create the hplussport database and necessary tables.
![image](https://drive.google.com/uc?export=view&id=1DvVW11_Hclm7Yhe90woBky0K2UUbrpk3)
  
  The java program is divided into nine files:
  

 1. `JDBCExecutor` contains the main method, and executes all commands.
 2. `/util/DataAccessObject` is the DAO interface
 3. `/util/DataTransferObject` is the DTO interface
 4. `DatabaseConnectionManager` handles the connection to the Postgres database using JDBC
 5. `Customer`
 6. `CustomerDAO`
 7. `OrderLine`
 8. `Order`
 9. `OrderDAO`

 
 # Twitter
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTIzMjAzMzM4OCwxNDQ1ODIxNjQ3LC0xNT
EyODk5Mzg2LDExMDkxMTUxMTQsLTcwNDIzMjQ5NywtMTY0NzI3
NzU5MiwtMTI5MjkxNjIxMiw4NzMxMTEwMDMsLTE0Mjk1MjU0MT
YsLTIwODEzNDQ0MDAsLTQ2NzU2OTk4OSwxODY3MTQxNzI3LC0x
Njk4ODAxMjU3LDIwNDE0NDI5NjVdfQ==
-->
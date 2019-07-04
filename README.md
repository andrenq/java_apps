# Java apps
This repository contains three java apps.
- Java Grep app - Implementation of the grep command in java. The app searches for a text pattern recursively in a given directory and outputs all matched lines to a file.
- JDBC - Example of Java Database Connectivity (JDBC) API usage. This app uses Data Access Object (DAO) to read and manage data from a Postgre database.
- Twitter - 

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
 # JDBC 
  ### Getting Started
  
 Working PostgreSql database
 # Twitter
<!--stackedit_data:
eyJoaXN0b3J5IjpbODczMTExMDAzLC0xNDI5NTI1NDE2LC0yMD
gxMzQ0NDAwLC00Njc1Njk5ODksMTg2NzE0MTcyNywtMTY5ODgw
MTI1NywyMDQxNDQyOTY1XX0=
-->
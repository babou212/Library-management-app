# Library Management Application


A simple fullstack web Application for library admins to manage users and loans of items



## Tech Stack

**Client:** React, React-bootstrap

**Server:** Spring Boot, mySQL, h2db

**Build Tool:** Maven 

**Security:**  Spring Security/ JWT

## Model

![](readme.resources/jhipster-jdl.png)


## Features

- Ability to add/ view users details 
- Ability to view all loans
- Ability to renew/ return loans and create new loans using userId and itemId's
- Ability to add new items and delete items if they are not cuurently being loaned


## Versions 

- React 18.2.0
- Spring Boot 2.7.2
- OpenJdk 17.0.4.1

## How to run

- You must have npm along with the latest LTS version of node installed

- Clone repo and cd into frontend module and run command " npm i " then run " npm start " to run the client  
- Make sure to set the environment to dev to use the embedded h2 database
- Then run maven to download dependencies and then build and run the java application either within the ide or as a 
  jar file (demo-0.0.1-SNAPSHOT.jar) located within the target directory. 

## Feedback

If you have any feedback, please reach out to me at dylanpab1@gmail.com

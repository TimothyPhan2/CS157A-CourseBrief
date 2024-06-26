# Course Brief
Search Countless CS and CMPE Courses at SJSU
## Table of Contents
- [About](#about)
- [Requirements](#requirements)
  - [Production](#production)
  - [Development](#development)
- [Authors](#authors)

## About
CourseBrief is a navigational web-app for searching and discovering CS and CMPE courses at SJSU. 

**Tech Stack:**  
- Frontend: React
- Backend: Spring Boot
- Database: MySQL
- Admin Interface: Spring Shell
## Requirements
- Java 17 
- Node 
- NPM
- MySQL

### Development
- Ensure MySQL server is running
- The project currently connects to the MYSQL server without a password
- If you have a password for the root user:
   - Create system environmental variable called 'DB_PASSWORD'
   - Set the variable to the MySQL server instance password
   - Navigate to \backend\src\main\resources\application.properties
   - Comment out the line:
     ```
     spring.datasource.password=
     ```
   - Uncomment out the line:
     ```
     spring.datasource.password=${DB_PASSWORD}
     ```
     

CourseBriefApplication
- Run Frontend:
  ```
    // while in the project root directory
    cd frontend\CourseBrief
    npm install
    npm run dev
  ```

- Run Backend:
  - Execute 'createdb.sql' by running in MySQL shell
    ```
    source createdb.sql
    ```
  - Run the application to create the tables:
    - Navigate to \backend\src\main\java\com\CS157AProject\CourseBrief\CourseBriefApplication.java
    - In any IDE, use the built-in 'run' to run the CourseBriefApplication.java.
  - Execute 'insertStatements.sql' by running in MySQL shell
    ```
    source insertStatements.sql
    ```
  - Visit http://localhost:5173/

 *WARNING: Terminate CourseBriefApplication.java before running CourseBriefAdmin.java
 
CourseBriefAdmin
  - Navigate to \backend\src\main\java\com\CS157AProject\CourseBriefAdmin\CourseBriefAdmin.java
  - In any IDE, use the built-in 'run' to run the CourseBriefAdmin.java.
  - Go to the shell in the terminal:
    - Available commands: 'course', 'tag', and 'help' 


## Division of Proof
- Nick: Designed and developed CourseBrief database schema, tables, and normalization. Implemented CourseBrief models, repositories and service classes. Built CourseBrief's admin interface through Spring Shell.
- Ibrahim: Created UI wireframes, mockups and then developed them into React componenets. Worked on connecting the backend and frontend and making api calls
- Raul: Implemented half of CourseBrief models and created queries for the repository backend.
- Timothy: Created both frameworks packages and worked as a full stack developer, working on the react components and Java classes/objects. Connected both servers and created and fetched the api calls on both sides.
- Joseph: Created the insert statments, tables and presentation slides. Added to front end.

## Authors
- [@nickfaylor](https://github.com/nickfaylor)
- [@IbrahimD0](https://github.com/Ibrahimd0)
- [@rg492](https://github.com/rg492)
- [@TimothyPhan2](https://github.com/TimothyPhan2)
- [@JosephSizz](https://github.com/JosephSizz)

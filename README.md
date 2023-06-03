# Appointment Scheduler
Appointment Scheduler helps users schedule and track appointments as well as keep track of clients and client contacts. The app is ideal for environments where users will be continually planning and tracking appointments and schedules. The application can be run on Windows, Linux and MacOS with little to no support for mobile devices.

## How the program works
Appointment Scheduler implements an authentication mechanism to prevent unauthorized access to appointment information. All login activity is recorded in a text file located in the parent directory. All appointment times are recorded in UTC by default. Each user that accesses the app has all appointment times shown in their local date and time. Appointment, client, and user data are all stored in a MySQL database, which can be imported into a MySQL DBMS. Users can configure the database connection through the application’s login screen.

## Technical Specifications
The program Architecture implements the MVC(Model-View-Controller) model as well as the DAO(Data-Access-Object) model. JavaFx files are stored in the resource package. Controllers for the JavaFX files are stored under the controller package. The program uses JDK 17 and JavaFX 17.0.2.


## Setup Guide
Appointment Scheduler is built using Java and JavaFX using the Maven environment. Most prerequisites are provided through the maven repositories included in the build package. One requirement is the JDBC 8.0.23 connector (Jar file) which can be downloaded from the [MYSQL official site](https://downloads.mysql.com/archives/c-j/). To build the program you must have [Intellij IDEA 2023](https://www.jetbrains.com/idea/) installed.
1. Download the repository
2. Extract the repo
3. Open the repo using Intellij IDEA 2023
4. Import the downloaded JDBC connector file into the project structure.
5. Configure the included database
6. Run the program
7. Configure the database connection through the Database connection tool within the program

After that you're all set. Enjoy!

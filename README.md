# CD-Manager
### I. Decription
- 
### II. Functions
- CD management:
  - Add CD
  - Delete CD
  - Edit CD information
  - Search for CD (By CD ID)
- Employee management:
  - Add employee
  - Delete employee
  - Edit employee information
  - Search for employee by code (By employee ID)
- Customer management:
  - Add customer
  - Delete customer
  - Edit customer information
  - Search for customer by code (By customer ID)
- Invoice management:
  - Create invoice
  - Search for invoice (By invoice ID)
- Notes:
  - *Role `Administrative Staff` has permissions: CD management, customer management, invoice management*
  - *Role `Manager` has full permissions*
### III. Technologies Used
- GUI:
  - Java Swing ([WindowBuilder](https://eclipse.dev/windowbuilder/))
- Programming language:
  - Java ([JDK 1.8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html))
- Database:
  - MongoDB
- API:
  - RMI
- Architecture:
  - Client-Server 
### IV. Software Demo Video Link
- [Software Demo Video Link](https://github.com)
### V. Installation Guide
- Step 1: Clone the code from GitHub.
- Step 2: Create a database with collections similar to those in the `hibernate.cfg.xml` file.
- Step 3: Open the `ServerApp.java` and `ClientApp.java` files, and modify the `RMI IP` to match the `IP of your machine`.
- Step 4: Configure `JRE` to version `1.8_202`.
- Step 5: Open the `data file` and import it into your database.
- Step 6: Run `ServerApp.java` first, and then run `ClientApp.java`.
### Author
Doan The Long

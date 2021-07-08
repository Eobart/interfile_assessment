# Interfile Assessment 

This is JavaEE app that allows a consumer to connect to functions through the use of  a Java Servlet, and allow them to manage account holder details and billing information


# Thought Process

* Looked at the requirements and what I needed to achieve, 
* Looked at technologies I should be using.
* Database Design 
* Interface Layout
* *Code!*

## Requirement Gathering

The requirements for the project where shared as followed: 
1. Read the attached xml files (StatementSingle.xml / StatementMulitple.xml) (this can be via an upload function, or a public static void main class)
2. Save details into the database (MySQL).
3. Display the account details per account holder.
4. Show a summary of all account holders and outstanding amounts.
5. Update customer demographic details.
6. EXTRA CREDIT - output file for a statement (PDF preferably, and with a UI of your choosing)


## Technologies Choices. 
* **Maven:** I used maven to manage my project dependencies. It also allows me to set up my build config so that the app can be packaged into a war file for later deployments
* * JEE and Springboot (Spring to be replaces with EJB3):* To setup the initial framework for the project I decided to work with Springboot and at some point to replace this with EJB3. The reason for going Springboot over EJB3 is due to time constraints and I wanted to rather focus on finishing the requirements with a Technology I know. And if time permitted go back and replace Spring Entities, Repo and Services to use EJB3. 
* **JUnit:** For my unit testing I went with JUnit. This allows me to test each function multiple times to ensure the base of my project does what it should. And allows me to test before each build. I Created a test class for each service as these are the classes that would be used by most of the projects.
* **JSF:** JSF was new to me.  I understand now that it generates the components and allows users access via the interface, For this I followed a tutorial and reused some of their UI features, but would make the functionality my own. 
* **Payara Application Server:** As per the requirements we needed to ensure we can host the application on a Payara Application Server. So for this I needed to compile the application into a war which I achieved with maven. 
* **IText**: As part of the stretch goal I decided to use IText to try and  generate the pdfs.  
* **AWS**: I used my aws account to host a free tier mysql db. I did this if the assessors would like to run the project they can get the credentials from me. I also would need their outbound IP address to add to the security group as that also keeps unwanted DB connectections out. 
 
   

## Database Design
The datatypes can be seen in entities. But I broke the file up into two tables. One for account holder details and one for the bills. I then setup a many to one relation between bills and account holder as one account holder can have many bills assigned to it.

## Interface Layout

The design for this was straight forward. As I knew I needed a Summary page and a home page as my main layout. From home I would allow a user to upload their xml file and add accounts that way. Also from there I would let them open an " Account Details" page where they can **view an account and edit the details.** And on the "Summary" page show the **summary of all account holders and outstanding amounts** as stated in requirements. 

## Project Structure
Even thought there are some auto generated files and folders I will take you through the important ones and show you what the reasoning is. 

```
.
+-- src.main.java.resources.application.yaml : This is the local dev folder of the application
+-- src.main.java.com.interfile.assessment(Base package)
|   +-- Application : From here I start the application
|   +-- Entity (Folder): This contains all entity classes that will be mapped from a table to our objects
|   |    +- AccountEntity : This maps to the account table and object
|   |    +- BillsEntity : This maps to the bill table and object
|   +- Repo (Folder)
|   |   +- AccountRepo: Spring interface I extend off of to be able to connect to database 
|   |   +- BillsRepo: Spring interface I extend off of Spring interface I extend off of to be able to connect to 						database
|   +- Service (I create this folder to have a common class where I connect to to try avoid code duplication)
|   |   +- AccountService: Service class for Account
|   |   +- Billservice: Service class for Bill
|   |   +- UtilsService: Service class used for extra feautures
|   +- bootfaces
|   |   +- AccountController : 
|   |   +- HomeController :
|   |   +- SummaryController :
+-- pom.xml : This contains all the dependencies used by the project as well as some of my build setup.
+- taget (folder) : generated files like war logs etc get places here
+-- .gitignore : This is to not upload unwanted files genereat by things like eclipse
```

## XML Processing 

For processing XML I decided to load the objects into Nodes and Elements and pull the data I need instead of using Jackson classes. The reason being as I used 1 table for my Account holder details and the XML as a few nested tags  I thought it would be easier managing it this way than annotating each variable in my classes with different base tags. And I also have not worked with Jackson before So went with a approach I have much more control over

## Short Comings
* XML Upload: Even though I am allowing a field where a user can select a file to be uploaded on the front end. I am still loading the file from a location on the server as I was having issues with the file being retrieved as null. 
* IText: I followed a tutorial and got the file being created but the file was corrupt. And because of time being up I could not finish this or complete it. It as of now only creates a corrupt PDF file. 

## Run Project Locally 

To run the project locally (Assuming maven is installed)
- Install Dependencies
	> mvn install

- Run Tests.
	> mvn test

- Package.
	> mvn package
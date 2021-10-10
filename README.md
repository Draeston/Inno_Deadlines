# InnoDeadlines
We start working on this project because sometimes face the problem when we just forget
about deadlines and it is hard to find all impotant information related to the assignment in time. 
So, we decided to create the project which will help, we hope, other Innopolis students to manage with their deadlines don't face this problem.

# Glossary
Frontend - the "front", client side of the project; user interface, transformed data from server are there

Backend - the "back", server side of the project, that contains logic to perform user's requests

Assignment - unit, that contains task, related important professor's or TA's comments, discussion, links and status

Course admin - representative or responsible person, who can add assignments to the group, add important information related to the assignment

# Used technologies
* Frontend
    + Vue.js
    + JavaScript
    + HTML
    + CSS
    + SASS
* Backend
    + Kotlin
    + Spring
    + PostgreSQL

# Stakeholders
Nikita Morozov - Frontend Developer

Azat Bariev - Backend Developer

# User Stories

* User
    + Registration
      + As a user I can register into the application by entering my email password and confirming the password so that I will be able to get access to this tool by authorizing
    + Login
      + As a user I can log in into the application by entering my credentials so that I will get access to the application
    + Dashboard
      + As a user I can see all my assignments in one place so that it will be easy to manage all deadlines
    + Receiving important information
      + As a user I can get all important information related to the assignment on its page so that 
    + Recovering password
      + As a user I want to have a possibility to recover my password if I forgot it via sending code to my email and setting new password
    + Logout 
      + As a user I want to be able to logout from my account by pressing the corresponding button
    + Group
      + As a user I want to be able to choose my lab group by selecting it from special menu
    + Main page
      + As a user I want to be able to return to main page by clicking on the logo
* Admin
    + Adding important information
      + As an admin I can add all important information by filling all fields on 'Add' page such as assignment name, group, subject, etc.

# Non-Functional Requirements
* Usability
    + Functionality
      + User should have all important functions to be able to meet the deadline by finding all important information about assignment
    + Intuitive
      + User is able to understand how the application works in less than 30 minutes
* Security
    + Authorization
      + People who are not Innopolis students should not get access to our project. There we mean that they should not be able to access any information about assignment, courses, change it and so on
    + User groups division
      + We should have groups of users with different opportunities, so only trusted and responsible people can do any changes related to information our project bring to students
* Performance
    + Speed
      + Application download should require not more than 1.5s for 8 Mb/s Internet speed
* Maintainability
    + Understandable documentation
      + We provide well-written documentation for maintenance of the project.
    + Well-organized project structure
      + Architecture of the project should be easy to understand
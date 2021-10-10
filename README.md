# InnoDeadlines

We start working on this project because sometimes face the problem when we just forget about deadlines and it is hard
to find all impotant information related to the assignment in time. So, we decided to create the project which will
help, we hope, other Innopolis students to manage with their deadlines don't face this problem.

# Glossary

Frontend - the "front", client side of the project; user interface, transformed data from server are there

Backend - the "back", server side of the project, that contains logic to perform user's requests

Assignment - unit, that contains task, related important professor's or TA's comments, links, assignment name, etc.

Course admin - representative or responsible person, who can add assignments to the group, add important information
related to the assignment

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

# Demonstration
https://youtu.be/uQkttnSlUSA

# User Stories

* User
    + Registration
        + As a user I can register into the application by entering my email password and confirming the password, so
          that I will be able to get access to this tool by authorizing. Nikita Morozov, Azat Bariev
    + Login
        + As a user I can log in into the application by entering my credentials, so that I will get access to the
          application. Nikita Morozov, Azat Bariev
    + Dashboard
        + As a user I can see all my assignments in one place, so that it will be easy to manage all deadlines. Nikita
          Morozov, Azat Bariev
    + Receiving important information
        + As a user I can get all important information related to the assignment on its page, so that it will be easy
          to find all important information related to the assignment. Nikita Morozov, Azat Bariev
    + Recovering password
        + As a user I want to have a possibility to recover my password if I forgot it via sending code to my email and
          setting new password, so that I will get into application even if I forget my password. Nikita Morozov, Azat
          Bariev
    + Logout
        + As a user I want to be able to logout from my account by pressing the corresponding button, so that no one
          will get into my account if I logged in on another's computer. Nikita Morozov, Azat Bariev
    + Group
        + As a user I want to be able to choose my lab group by selecting it from special menu, so that I can find
          someone from other group with whom I can discuss problem I face during performing the task. Nikita Morozov,
          Azat Bariev
    + Main page
        + As a user I want to be able to return to main page by clicking on the logo, so that it will be easy to return
          to main page from any place of the app. Nikita Morozov
* Admin
    + Adding important information
        + As an admin I can add all important information by filling all fields on 'Add' page such as assignment name,
          group, subject, etc., so that my classmates will track their assignments easily. Nikita Morozov, Azat Bariev

# Non-Functional Requirements

* Usability
    + Functionality
        + User should have all important functions to be able to meet the deadline by finding all important information
          about assignment
    + Intuitive
        + User is able to understand how the application works in less than 30 minutes
* Security
    + Authorization
        + People who are not Innopolis students should not get access to our project. There we mean that they should not
          be able to access any information about assignment, courses, change it and so on
    + User groups division
        + We should have groups of users with different opportunities, so only trusted and responsible people can do any
          changes related to information our project bring to students
* Performance
    + Speed
        + Application download should require not more than 1.5s for 8 Mb/s Internet speed
* Maintainability
    + Understandable documentation
        + We provide well-written documentation for maintenance of the project.
    + Well-organized project structure
        + Architecture of the project should be easy to understand

# Design Patterns

* Frontend
    + Model-View-ViewModel (MVVM)
      + So, Vue.js is a JavaScript-framework that implements MVVM pattern. There Model and View are things, which I write by myself, while ViewModel is a tool that Vue.js provides to me as directives, for example. So, I just write the HTML and CSS code and link it with my JS-code using directives, binding data and functions performing by Model.
    + Observer
      + I used this method by, for example, using directive @onChange in select list of lab groups, so on every change of the HTML-object, my Model will react by changing assignments list. It's quite important to use this pattern in frontend development, because of necessity of tracking View changes.
    + Singleton
      + In many cases, it's an anti-pattern, actually. But I used it for creating a store for all components of my application, so that I can easily share all important data and safety perform any changes on it. And I think, it can be used for such purposes.

* Backend
    + Singleton Pattern
        + The singleton pattern is a mechanism that ensures only one instance of an object exists per application. This pattern can be useful when managing shared resources or             providing cross-cutting services, such as logging.
    + Factory Method Pattern
        + The factory method pattern entails a factory class with an abstract method for creating the desired object.
    + Proxy Pattern
        + The proxy pattern is a technique that allows one object — the proxy — to control access to another object — the subject or service.
    + Template Method Pattern
        + The template method pattern is a technique that defines the steps required for some action, implementing the boilerplate steps, and leaving the customizable steps as             abstract.

The descriptions of patterns taken from https://www.baeldung.com/spring-framework-design-patterns

# UML Diagrams
Class Diagrams

There is no classes, except Vue class, in frontend part, so that there is quite impossible to construct Class UML Diagram for frontend.

Component Diagram

Frontend
<img style="max-width: 500px" src="https://github.com/Draeston/Inno_Deadlines/blob/dev/docs/dep-front.PNG">

Backend
<img style="max-width: 500px" src="https://github.com/Draeston/Inno_Deadlines/blob/dev/docs/uml.svg">

# SOLID Usage

Backend

* We tried to make every entity responsible for only one purpose
* It is easy to expand, but it is not defined to modify
* There is not mush inherited classes, so LSP is maintained
* All interfaces have only one purpose
* DIP is also maintained

# Static and Dynamic View diagrams

Backend
## Static View
<img style="max-width: 500px" src="https://github.com/Draeston/Inno_Deadlines/blob/dev/docs/Static%20view.png">

## Dynamic View
<img style="max-width: 500px" src="https://github.com/Draeston/Inno_Deadlines/blob/main/docs/dynamic.png">

## Deploy diagram
<img style="max-width: 500px" src="https://github.com/Draeston/Inno_Deadlines/blob/main/docs/deploy.svg">

# Database structure
<img style="max-width: 500px" src="https://github.com/Draeston/Inno_Deadlines/blob/dev/docs/ERD.png">







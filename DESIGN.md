# MoodleBox-Dashboard
Our final project “MoodleBox-Dashboard” is a platform that meant to be a middle ground for participants, the management members and [Refugees Code](https://www.refugeescode.at/) resources including the [R{c}](https://www.refugeescode.at/) MoodleBox and structured apps that currently exist or other future APPs.

Our perspective for our platform is to be as functional and attractive as possible by considering the following issues:
-	help participants to control their courses, resources and activities, with a lot of fun and motivations.
-	help people who are in charge in [Refugees Code](https://www.refugeescode.at/) program to get more control over the organisation stuff (events, courses and activities) and to follow the progress for each participant.
-	Meet the requirements that have been divided from user stories:  
    -	**As a user** _I like collecting points_.
    -	**As a user** _I like to join a course on Moodle by pressing a button_
    -	**As a user** _I like to earn points when I finish a course in MoodleBox_
    -	**As a user** _I like to level up after X points_
    -	**As a user** _I like to have a profile, a secure log-in, see my friends and events (not fully implemented yet)_

In order to build our project, a set of technologies have been used as following:
-	Java integrated development environment ([Intellij IDEA](https://www.jetbrains.com/idea/)) for developing our software.
-	[Maven](https://maven.apache.org/guides/getting-started/index.html) project with [java development kit 8 (JDK)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
-	[Spring boot 2.0.2](https://projects.spring.io/spring-boot/) with following dependencies ([start.spring.io](https://start.spring.io)):  
    - Web 
    - [MongoDB](https://www.mongodb.com/) 
    - [Thymeleaf](https://www.thymeleaf.org)
    - [Devtools](https://developer.chrome.com/devtools) 
    - Security
	
-	[Webhook](https://en.wikipedia.org/wiki/Webhook) as HTTP call-back using [GET method](https://www.w3schools.com/tags/ref_httpmethods.asp).
-	[GitHub](https://github.com/) as a web-based hosting service for version control using git.
-	[Documentational database MongoDB](https://www.mongodb.com/) .
-	Using [raspberry pi](https://www.raspberrypi.org/) as a server, __but it can be done using any server that supports java__.

The vast majority of the code in this Dashboard is our own; however, and as a back-end developer and for the purpose of front-end structure, we had to use specific lines of code from open sources such as:

https://www.w3schools.com/howto

for both: [Bootstrap and jQuery](https://www.w3schools.com/howto/default.asp). 

overall, we are satisfied with our work and hope as a future work to improve the functionality and the interface design.

The CS50 final project has been done with a collaboration between:
-	__[Nisreen Alam Aldeen](https://github.com/nana80802)__
-	__[Hamed Babai](https://github.com/xsadra)__
-	__[Alexander Hartveld](https://github.com/AlexHartveld)__

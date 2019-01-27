# SaveMySpot

Project nameConUHack IV - SaveMySpot
Jan 2019

Project descriptionSaveMySpot is a web application where users can find out when spots become available in the courses they want to to register for. After the user supplies a course code and their e-mail on the website they are officially registered! They will then receive an e-mail whenever there is space in the course/wait-list so they don't have to worry about constantly checking themselves.

The end user submits a form on a vanilla HTML/CSS which is submitted to a PHP file. This processes the POST request and loads it into a mySQL database. This stores their email address, the course name, and if they are interested in being on a waitlist.

Every day at 4:01am via a cron job, a python script will query Concordia's Open Data API to download the current status of all courses. For demo purposes, we are using only COMP courses.

At 4:05, a Java file loops over the JSON data and the mySQL data and sends emails to all students who are eligible to be on a waitlist or join a course directly (according to their preferences).

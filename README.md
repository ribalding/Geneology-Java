#Geneology Project
##A practice webpage for Epicodus, 5/21/2016

###by Ryan Harvey, Jeff Hackford, Tommy Jones, and Jacob Hefley

##Description

_This is a website which allows users to input information about their family, as well as images and then arranges the information into a visually appealing family tree._

##Setup

_Clone this repository_

_Navigate to your database software in your terminal and execute the following commands:_

_CREATE DATABASE geneology;_
_CREATE TABLE users(id serial PRIMARY KEY, user_name varchar, password varchar);_
_CREATE TABLE relatives(id serial PRIMARY KEY, relative_name varchar, relation varchar, relation_type_id int, user_id int, img varchar);_
_CREATE DATABASE geneology_test WITH TEMPLATE geneology;_

_Make sure that you have Gradle installed on your computer_

_Navigate to the home folder in your terminal and type 'gradle run' then press enter._

_Go to your web browser and navigate to http://localhost:4567_

##Technologies Used

Java Spark Gradle Velocity JUnit FluentLenium PostGreSQL SQL HTML CSS Bootstrap

##Legal

Copyright (c) 2016 Ryan Harvey, Jeff Hackford, Tommy Jones, and Jacob Hefley

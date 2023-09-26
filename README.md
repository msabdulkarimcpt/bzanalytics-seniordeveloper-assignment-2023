# BzAnalytics - Take Home Assignment for Senior Software Engineer - 2023

To excel in this assignment you need to demonstrate your ability to learn and implement 
something new. Besides you are also expected to showcase your experience in architecting
a robust software solution and in writing readable, resilent code.

## The Problem
The database provided in this repo contains the data of all the employees and differents 
projects of a hypothetical company. The db has 4 tables - Technology, Employee, Projects and ProjectAllocation.
Technology table holds all the technologies that the company is working with, Employee table has all the employees
of the company - current and previous, Project table has all the company's projects and ProjectAllocation table 
stores information about all the employees allocated to each project at different times.

## Your Task
Build a REST API service using [Kotlin](https://kotlinlang.org) with following endpoints.
1. An endpoint to get a list of current employees with First Name, Last Name, Current Project and Experience in months.
2. An endpoint to retrieve all currently running projects with Project Name, Start Date and List of employees working in
the project.
3. An endpoint to retrieve employees who are currently unallocated with their First Name, Last Name and skills.
4. Given a new project requirement - skills and number of employees for each skill, the 4th endpoint should return a
possible employee allocation for the project. Only unallocated employees should be considered for allocation to a new 
project. If there are more than one unallocated employee with the required skill make a choice based on their primary 
skill. Their experience working in the company shall be the second consideration.

## Instructions
1. You should follow clean architecture while implementing your solution. Here's a [quick reference](https://www.freecodecamp.org/news/a-quick-introduction-to-clean-architecture-990c014448d2/).
2. The folder structure of the project is already set according to the clean architecture. Try to implement your code within the given structure.
3. Your code should pass all the given test cases.
4. Try to write more tests to improve coverage.
5. Bonus points for implementing functional programming as well.
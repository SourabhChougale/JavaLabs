Exercise 1:
In exercise 1, monthly base salary of the employees is calculated and displayed according to the number of hours and hourly salary.

`Employee(String name,int hours, double salPerHour)` : Takes name ,hourly salary, number of hours of work per day of employee. 

`calSalPerDay()` : Calculates salary per day.

`addWork()` : Adds $5 daily to salary of employee if the number of hours of work per day is more than 6 hours.

`computeBaseSalary()` : Computes the base salary for 20 days of work.

`addSal()` : Adds $10 to the base salary of the employee if it is less than $500.

`getFinalSalary()`: returns final salary of employee

`result()`: Prints Salary of Employee




2.Exercise 2:
In exercise 2, area and perimeter of circle, square and rectangle is calculated according to the given radius,lengths and breadth.

In this exercise, we have Class Shape with variables area and perimeter

`Circle(double radius)` : Calculates and prints area and perimeter of circle

`Square(double length)` : Calculate and prints area and perimeter of square

`Rectangle(double length,double breadth)` : Calculate and prints area and perimeter of rectangle




2.Exercise 3:
In this exercise, data of football and basketball teams and the results of currents matches of each team is stored in csv fileand  is handled using BufferedReader class.
There are three classes Football, Basketball and Main class and one interface Team.
Read data from csv file is stored in collections of type Team `ft_obj and bb_obj` according to the sports.

`updatePoints(String result)`: updates the points of each team by taking result of the last match of the team.

Football Team: Win: add 3 points; Drawn: add 1 point; Lose: do nothing.
Basketball Team: Win: add 2 points; Lose: do nothing.

ft_obj and bb_obj are sorted using list.sort() to get proper standings of the teams.



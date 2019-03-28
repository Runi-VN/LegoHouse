# LegoHouse

This mandatory solo project is the second project of the second semester. The main focus of the project is architecture.

### Results

~~Project deployed at [to come]().~~  
JavaDocs can be found [here](https://runi-vn.github.io/LegoHouse).  
Project discussion on the [wiki](https://github.com/Runi-VN/LegoHouse/wiki), including algorithm breakdown.

[Project description](https://datsoftlyngby.github.io/dat2sem2019Spring/Modul3/LegoHus.html)  
(Paraphrased)  
```markdown
A customer must be able to:
register, log in, create a LEGO house order.
View a list of their orders as well as order specifics ('bill of materials'). 

An employee must be able to:
log in, view a list of all orders.
modify their status from 'processing' to 'shipped'.

Furthermore:
The bill of materials will be generated on request and should not be saved to the database.

A lego house uses bricks with a standard width of 2 'dots' and a length of either 4, 2 or 1.
```

Tools: Java servlets, JSP, MySQL.  
Not required, but used: CSS, bootstrap

### Installation and use
This program takes use of the [sample login](https://github.com/DAT2SemKode/Modul3LogInSample) made by Kasper, with minor modifications.
1) Set up your database using the included SQL script. (Found in \_extra)
2) Change the DBConnector to your setup. (Found in the data layer)
3) Clean and build -> Run.

I have created users for you to use:  
Employee: `employee@test.com`|`1234`  
Customer: `customer@test.com`|`1234`

Many of the tests included *could* fail because they take use of a test database not included.



## Completed requirements:

### Database E/R Diagram  
This was based on the login database mentioned in discussion. I would/could have made this differently.
<img src="https://i.imgur.com/prWZHLR.png" alt="Database E.R. Diagram">

### Architecture
This program takes use of the following [design patterns](https://en.wikipedia.org/wiki/Software_design_pattern):  
- [Three-tier architecture](https://en.wikipedia.org/wiki/Multitier_architecture#Three-tier_architecture) (required)
- [Facade](https://en.wikipedia.org/wiki/Facade_pattern)
- [Front controller](https://en.wikipedia.org/wiki/Front_controller)
- [Controller](https://en.wikipedia.org/wiki/Command_pattern)
- [Singleton](https://en.wikipedia.org/wiki/Singleton_pattern)  
*minor* [Interfaces](https://en.wikipedia.org/wiki/Interface_(Java))

### UML Navigational Diagram
<img src="https://i.imgur.com/VCBvpr9.png" alt="PlantUML Navigational Diagram Image">

### Project demands (danish)
Please see the [wiki](https://github.com/Runi-VN/LegoHouse/wiki).


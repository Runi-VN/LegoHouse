# LegoHouse

This mandatory solo project is the second project of the second semester. The main focus of the project is architecture.

[Project description](https://datsoftlyngby.github.io/dat2sem2019Spring/Modul3/LegoHus.html)
(Paraphrased)  
```markdown
A customer must be able to:
register, log in, create a LEGO house order.
View a list of their orders as well as order specifics. 

An employee must be able to:
log in, view a list of all orders.
modify their status from 'processing' to 'shipped'.

Furthermore:
A bill of materials will be generated on request and should not be saved to the database.

A lego house uses bricks with a standard width of 2 'dots' and a length of either 4, 2 or 1.
```

Tools: Java servlets, JSP, MySQL.  
Not required, but used: CSS, bootstrap

### Discussion
This project was made in the week following [Cupcake](https://github.com/Castau/CupCake).  
The purpose of the project is to ensure that we (students) had learned the same required knowledge from the Cupcake project. 

Because of this, the overall design and some parts are straight up ripped from the Cupcake project.

This program takes use of the [sample login](https://github.com/DAT2SemKode/Modul3LogInSample) made by Kasper, with minor modifications.

### Installation and use
1) Set up your database using the included SQL script. (Found in \_extra)
2) Change the DBConnector to your setup. (Found in the data layer)
3) Clean and build -> Run.

I have created users for you to use:  
Employee: `employee@test.com`|`1234`  
Customer: `customer@test.com`|`1234`

Many of the tests included *could* fail because they take use of a test database not included.

## Completed requirements:

###  Walkthrough of basic algorithm  
For this simple walkthrough I only take account of the length of one side ("length") of the building.
```java  
public Bricks calculateBricks(Order order)
    {
        int length = order.getLength();
        Bricks bricks = null;
        
        /*We always want as many 4's as possible, then 2's, then 1's if necessary. (Hint: Uneven length)
          Generally speaking: 
          N/10 = left digit
          N%10 = right digit
          When we divide we get the actual count or "potential difference".
          When we use the modulus operator (%) we get the remainder*/
        
        /*IMPORTANT: Integers (in our case ints) do not allow decimals in the same way a double does. 
        In case of a decimal, we ALWAYS round down. 
        This will be used to our advantage*/
        
        
        //For our purpose lets test with the length 23
        int CalcFours = (length / 4);     //(23/4) = 5,75 ~ 5.
        int CalcRemainder = (length % 4); //(23%4) = 3. 
        
        //We do not have a 3-dot brick, so we need to apply the above technique to Twos.
        
        int CalcTwos = (CalcRemainder/2); //(3/2) = 1.5 ~ 1.
        //We still do not have a three-dot brick, but we do have a 1-dot brick to fix our problem.
        
        int CalcOnes = (CalcRemainder%2); //(3%2) = 1. 
        /*REMEMBER! This takes height of equal numbers and will always give 0 in that case 
        (if a 1-brick is not needed)*/
        
        //So the results should now be:
        //fours = 5 = 20
        //twos = 1 = 2
        //ones = 1 = 1
        //total: 23
        
        return bricks = (new Bricks(CalcFours, CalcTwos, CalcOnes));
        
    }
```  
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
<img src="https://i.imgur.com/4S9WaWw.png" alt="PlantUML Navigational Diagram Image">

### Project demands (danish)

#### Kundekrav
- Som kunde vil jeg gerne kunne oprette en ordre på et lego hus. ☑  
- Som kunde vil jeg gerne kunne se mine tidligere ordrer, sådan at jeg kan se hvad jeg tidligere har bestilt. ☑  
- Som kunde vil jeg gerne kunne se om min ordre er afsendt. ☑    
- Som kunde vil jeg gerne kunne se styklister for mine tidligere ordrer.☑    

#### Firma krav  
- Det skal være muligt for en ansat at se hvilke ordrer, der er i systemet.☑    
- Det skal være muligt for en ansat at markere en ordre som afsendt.☑    

#### Kvalitetskrav til afleveret system  
- Det færdige system skal ligge som netbeans projekt på github. ☑   
- Det færdige system skal være struktureret efter 3-lags modellen - præsentationslag, forretningslag og datalag.☑    --
- Det forventes, at der er en facade mellem præsentations og forretningslag og evt. mellem forretningslaget og datamappers.☑   
- Det forventes, at der IKKE kaldes forretningslogik (eller datamappers) fra JSP siderne.☑    
- Det forventes, at session og requests attributter anvendes korrekt. ☑   
- Vi vil anse det for en fejl, hvis der bruges redirect hvor der burde bruges forward.☑    
- Det forventes at styklisterne ikke gemmes i databasen, men beregnes i forretningslaget. ☑   
- Du skal håndtere exceptions. ☑   

#### Grønne, Gule og Røde krav  
##### Grøn  
- Det forventes, at du opfylder kundekrav 1 & 2. Altså at man kan oprette en ordre og få en stykliste for denne. ☑   
- Kravene til systemets kvalitet, som nævnt ovenfor, skal opfyldes.☑    
- Du skal fange exceptions i servletten.  ☑  
##### Gul  
- Det forventes, at du har kundekrav 4 med. ☑   
- Det forventes også, at du bygger i “forbandt” - at klodserne i lagene er forskudt i forhold til hinanden. ❌  
- Kravene til systemets kvalitet, som nævnt ovenfor, skal opfyldes.  ☑  
- Du skal lave en specialiseret exception, som du kaster fra datalaget og fanger i en servlet.  ☑  
##### Rød  
- Det forventes, at du også har kundekrav 3 med i din løsning.  ☑  
- Det forventes også, at du på den ene langside gør plads til et vindue, og på den anden langside gør plads til en dør❌  
- Kravene til systemets kvalitet, som nævnt ovenfor, skal opfyldes. ☑   
- Det forventes, at du bruger en front-controller som vist i det vedlagte oplæg. ☑   

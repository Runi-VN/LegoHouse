# LegoHouse

This project is the second project of the second semester and was made directly after [Cupcake](https://github.com/Castau/CupCake).  

[Project description](https://datsoftlyngby.github.io/dat2sem2019Spring/Modul3/LegoHus.html)

### Discussion
The purpose of the project is to ensure that we (students) had all learned the same required knowledge from the Cupcake project. Seeing as the project was developed in teams of 3-5 students, some might have missed out on essential knowledge.  
Therefore this project was made individually.  

Due to this, the overall design and some parts are straight up ripped from the Cupcake project.

This program takes use of the [sample login](https://github.com/DAT2SemKode/Modul3LogInSample) made by Kasper, with minor modifications.

### Installation and use
1) Set up your database using the included SQL script. (Found in \_extra)
2) Change the DBConnector to your setup. (Found in the data layer)
3) Clean and build. **The tests should fail**, considering you haven't set up a test database for my specific project. Either delete them or comment them out.  


## Completed requirements:

### Simple walkthrough of algorithm  
For this walkthrough I only take account of the length.
```java  
public Bricks calculateBricks(Order order)
    {
        int length = order.getLength();
        Bricks bricks = null;
        
        /*We always want as many 4's as possible, then 2's, then 1's if necessary. (Hint: Uneven length)
          When we divide we get the difference
          When we use the modulus operator (%) we get the remainder*/
        
        /*IMPORTANT: Integers (in our case ints) do not allow decimals in the same way a double does. 
        In case of a decimal, we ALWAYS round down. 
        This will be used to our advantage*/
        
        
        //For our purpose lets test with the length 23
        int CalcFours = (length / 4);     //(23/4) = 5,75 ~ 5 (remainder .75)
        int CalcRemainder = (length % 4); //(23%4) = 3. 
        
        //We do not have a 3-dot brick, so we need to apply the above technique to Twos.
        
        int CalcTwos = (CalcRemainder/2); //(3/2) = 1.5. 
        //We still do not have a three-dot brick, but we do have a 1-dot brick to fix our problem.
        
        int CalcOnes = (CalcRemainder%2); //(3%2) = 1. 
        /*REMEMBER! this takes height of equal numbers and will always give 0 in that case (if a 1-brick is not needed)*/
        
        //So the results should now be:
        //fours = 5 = 20
        //twos = 1 = 2
        //ones = 1 = 1
        //total: 23
        
        return bricks = (new Bricks(CalcFours, CalcTwos, CalcOnes));
        
    }
```  

### Kundekrav
Som kunde vil jeg gerne kunne oprette en ordre på et lego hus, sådan at jeg kan få en stykliste for huset. Ordren skal indeholde længde og bredde af lego husets vægge (angives i antal “prikker” huset skal være på hver led), samt hvor mange klodser man ønsker det skal være højt.

Som kunde vil jeg gerne kunne se mine tidligere ordrer, sådan at jeg kan se hvad jeg tidligere har bestilt.  

Som kunde vil jeg gerne kunne se om min ordre er afsendt, sådan at jeg kan planlægge hvornår jeg skal lege med lego.  
Som kunde vil jeg gerne kunne se styklister for mine tidligere ordrer.  

### Firma krav  
Det skal være muligt for en ansat at se hvilke ordrer, der er i systemet.  
Det skal være muligt for en ansat at markere en ordre som afsendt.  

### Kvalitetskrav til afleveret system
Det færdige system skal ligge som netbeans projekt på github.  

Det færdige system skal være struktureret efter 3-lags modellen - præsentationslag, forretningslag og datalag.  

Det forventes, at der er en facade mellem præsentations og forretningslag og evt. mellem forretningslaget og datamappers. 

Det forventes, at der IKKE kaldes forretningslogik (eller datamappers) fra JSP siderne.  

Det forventes, at session og requests attributter anvendes korrekt.  

Vi vil anse det for en fejl, hvis der bruges redirect hvor der burde bruges forward.  

Det forventes at styklisterne ikke gemmes i databasen, men beregnes i forretningslaget.  

Du skal håndtere exceptions.  

### Grønne, Gule og Røde krav  
#### Grøn  
Det forventes, at du opfylder kundekrav 1 & 2. Altså at man kan oprette en ordre og få en stykliste for denne.  
Kravene til systemets kvalitet, som nævnt ovenfor, skal opfyldes.  
Du skal fange exceptions i servletten.  
#### Gul  
Det forventes, at du har kundekrav 4 med.  
Det forventes også, at du bygger i “forbandt” - at klodserne i lagene er forskudt i forhold til hinanden. Her kan du blive inspireret til flotte forbandt mønstre.  
Kravene til systemets kvalitet, som nævnt ovenfor, skal opfyldes.  
Du skal lave en specialiseret exception, som du kaster fra datalaget og fanger i en servlet.  
#### Rød  
Det forventes, at du også har kundekrav 3 med i din løsning.  
Det forventes også, at du på den ene langside gør plads til et vindue (vælg selv en fast størrelse), og på den anden langside gør plads til en dør (vælg selv en fast størrelse.)  
Kravene til systemets kvalitet, som nævnt ovenfor, skal opfyldes.  
Det forventes, at du bruger en front-controller som vist i det vedlagte oplæg.  

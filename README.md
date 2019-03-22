# LegoHouse

This project is the second project of the second semester and was made directly after [Cupcake](https://github.com/Castau/CupCake).  

[Project description](https://datsoftlyngby.github.io/dat2sem2019Spring/Modul3/LegoHus.html)

### Discussion
The purpose of the project is to ensure that we (students) had all learned the same required knowledge from the Cupcake project. Therefore the project was made individually.  

This was primarily because we worked as 3-5-man groups, so some students might have missed out on some parts, i.e. how to use JDBC to connect to a database.

Due to this, the overall design and some parts are straight up ripped from the Cupcake project.

This program takes use of the [sample login](https://github.com/DAT2SemKode/Modul3LogInSample) made by Kasper, with minor modifications.

### Installation and use
1) Set up your database using the included SQL script. (Found in \_extra)
2) Change the DBConnector to your setup. (Found in the data layer)
3) Clean and build. **The tests should fail**, considering you haven't set up a test database for my specific project. Either delete them or comment them out.  


## Completed requirements:

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

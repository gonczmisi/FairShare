# Back-end

This document contains information about our backend.

## About technology

The application uses **Spring Boot**, an open source Java-based framework, with **Maven** as a build automation tool.

### Why Spring Boot?

Spring Boot provides a good platform to create an application that can *just run*. The main advantages of this framework is that the backend can run independently with minimum configurations, it can reduce development time, helps with useful auto-configuration methods and most importantly provides powerful batch processing and manages REST endpoints.

### Why Maven?

Maven is a good choice for a Java-based backend, because it's mainly designed to support that. Maven uses an easily configureable with the Project Object Model, a simple XML file. This file contains all the unique identifiers of the project, the dependencies and every necessary information for building.

## About back-end

In this section you can find information about the bakcend functions.

### Endpoints

#### GET


    
#### POST



#### PUT



#### DELETE



### Source code directory structure

+ **src\**
  + **main\**
    + **java\hu\elte\fairshare**
      + **controllers\** : contains the REST controller implementations
      + **entities\** : contains the entity implementations
      + **repositories\** : contains the CRUD repository implementations
      + **utils\** : contains useful utilities (mainly enumerator types)
    + **resources\** : contains resources required for the application (ex.: application property config file)

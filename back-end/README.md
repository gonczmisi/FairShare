# Back-end

This document contains information about our backend component.

## About technology

The application uses **Spring Boot**, an open source Java-based framework, with **Maven** as a build automation tool.

### Why Spring Boot?

Spring Boot provides a good platform to create an application that can *just run*. The main advantages of this framework is that the backend can run independently with minimum configurations, it can reduce development time, helps with useful auto-configuration methods and most importantly provides powerful batch processing and manages REST endpoints.

### Why Maven?

Maven is a good choice for a Java-based backend, because it's mainly designed to support that. Maven uses an easily configureable with the Project Object Model, a simple XML file. This file contains all the unique identifiers of the project, the dependencies and every necessary information for building.

#### Generating Java documentation

The source code contains the appropiate Java documentation comments at all of the classes, members, functions.
With the help of the ```maven-javadoc-plugin```, during the build process a nice, HTML and CSS based documentation is also generated to the project. Note, that if the documentation comments are missing, or the syntax is invalid, it will **break the whole build process**.

The artifacts are in the ```target``` folder.

#### Code styles checking

The source code have to fit some coding conventions, and the ```maven-checkstyle-plugin``` can check it before building.
The ```The checkstyle.xml``` file contains a slightly modified version of the coding conventions originally drafted by Sun Microsystems. Note, that if the source code doesn't fit these conventions, **the whole build process will fail**. SAY NO TO TRAILING WHITESPACES!

The artifacts are in the ```target``` folder.

### Endpoints

These are the endpoints of our backend component.

#### GET

```
/users
/users/id/{id}
/users/username/{username}
/users/email/{email}
/users/role/{role}

/items
/items/{id}

/receipts
/receipts/{id}
```
    
#### POST

```
/register

/items

/receipts
```

#### PUT

```
/users/username/{username}
/users/email/{email}
/users/role/{role}

/items/{name}

/receipts/{id}
```

#### DELETE

```
/users/id/{id}
/users/username/{username}

/items/{id}

/receipts/{id}
```

### Source code directory structure

+ **src\**
  + **main\**
    + **java\hu\elte\fairshare**
      + **controllers\** : contains the REST controller implementations
      + **entities\** : contains the entity implementations
      + **repositories\** : contains the CRUD repository implementations
      + **security\** : contains object crucial for security and authentication
      + **utils\** : contains useful utilities (mainly enumerator types)
    + **resources\** : contains resources required for the application (ex.: application property config file)
  + **test\**
    + **java\hu\elte\fairshare**
      + **controllers\** : controller integration tests
      + **entities\** : entity unit tests
      + **repositories\** : repository integration tests
      + **security\** : security unit tests
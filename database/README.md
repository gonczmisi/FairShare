# Database

This document contains information about our database.

## About

Our PostgreSQL database is running on a Linux virtual machine in Microsoft Azure.
Because we love our planet and we don't want to waste energy, the VM is turned off most of the time, so if you want to try it out, you should run an own PostgreSQL server (or you should be lucky to find our VM active).

## Connecting

Use [pgAdmin](https://www.pgadmin.org/) to connect and handle the database.

Credentials:
+ Host name/adress: 137.117.229.78
+ Port: 5432
+ Maintain database: FairShareDB
+ For further credentials, connect us!

## Files in this directory

You will find some SQL files in this directory. These files are for testing. If the database data is incorrect, the data driven unit and integration tests should fail. Before running the tests, please check if the database data is correct!
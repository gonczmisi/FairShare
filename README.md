# FairShare

Welcome to our project repository!

This README file only contains some essential informations about our project.
If you're after specific informations about the database, back-end or front-end of the application, please read the README files in the appropiate folders.

+ [About the database](../master/Database/README.md)
+ [About the back-end](../master/back-end/README.md)
+ [About the front-end](../master/front-end/README.md)

## What is FairShare?

FairShare is a simple but useful application which can help you and your community to manage the expenses.

Often, when you spend some quality time with your friends or family, only one person will go to the shop instead of everyone, and purchase the required ingredients for the dinner (or the 10 trays of beer for the night).
If it happens, it's always a torture to calculate who owes whom and how much money. It would be great to have another option, right?

Good news! There is! Or there will be... maybe. As time goes on, I'm getting more and more confident that this project will never be completed.

With FairShare, you can

+ create virtual receipts;
+ add your friends to the receipts (and also to items within them);
+ keep tracking your expenses and debits;
+ relax, and not to worry about getting your money back.

## About branching

The project uses two permanent branches:

+ __dev__: development branch
+ __master__: release branch (always stable)

We merge to the master branch often, with pull requests to make sure everybody approves the release.

## About CI

The project uses Mr. Jenkins as a solution for continuous integration. If you demurely knock on the door at http://137.117.229.78:8080, I'm sure he will welcome you and show our builds.

With the help of Jenkins, the project's tests and builds are running at least once every day (let's call it nightly build), and also on every single commit on the development (dev) and the production (master) branch.

__You can check our build history and trends without logging in!__

We are trying to merge from the development branch as often as we can, but only if there were meaningful improvements on our software.

### How the automated builds starting?

If someone commits to the development or to the production branch, the GitHub webhook we have configured will trigger Mr. Jenkins, and he will make sure if the commit (or merge) is right.

## Extra tools

The maven build comes with automated documentation generation and code style checking, both can break the build. For more information, check the backend documentation.
The artifacts are in the ```target``` folder.
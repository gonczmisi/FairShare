pipeline {
    agent none
    stages {
        stage('SCM Checkout') {
            git 'https://github.com/gonczmisi/FairShare'
        }
        stage('Build') {
            sh 'mvn install -Dmaven.test.skip=true -f back-end/fairshare/pom.xml'
        }
        stage('Test') {
            sh 'mvn test -f back-end/fairshare/pom.xml'
        }
    }
}

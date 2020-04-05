pipeline {
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests -f back-end/fairshare/pom.xml clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test -f back-end/fairshare/pom.xml'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
}

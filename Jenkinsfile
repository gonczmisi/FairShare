pipeline {
    agent none
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests --batch-mode --file back-end/fairshare/pom.xml'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test --file back-end/fairshare/pom.xml'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') {
            steps {
                sh 'echo "asd"'
            }
        }
    }
}

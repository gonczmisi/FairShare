node {
    stage('SCM checkout') {
        git 'https://github.com/gonczmisi/FairShare'
    }
    stage('Build') {
        sh 'mvn clean package -DskipTests --batch-mode --file back-end/fairshare/pom.xml'
    }
    stage('Test') {
        sh 'mvn test --file back-end/fairshare/pom.xml'
    }
    stage('Deliver') {
        sh 'echo "asd"'
    }
}

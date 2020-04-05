node {
    stage('SCM checkout') {
        git branch: 'jenkins', url: 'https://github.com/gonczmisi/FairShare'
    }
    stage('Build') {
        sh 'mvn clean package -DskipTests --batch-mode --file back-end/fairshare/pom.xml'
    }
    stage('Test') {
        sh 'mvn test --file back-end/fairshare/pom.xml'
    }
    stage('Run') {
        sh 'java -jar /var/lib/jenkins/workspace/fairshare-pipeline/back-end/fairshare/target/fairshare-0.0.1-SNAPSHOT.jar'
    }
}

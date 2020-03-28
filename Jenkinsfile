node {
    stage('SCM Checkout') {
        git 'https://github.com/gonczmisi/FairShare'
    }
    stage('Build') {
        sh 'mvn package -f back-end/fairshare'
    }
}

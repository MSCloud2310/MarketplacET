pipeline {
    agent any
    stages {
        stage("clean docker data") {
      steps {
        sh 'docker system prune --all --volumes'
      }
    }
        stage('build') {
            steps {
                sh 'docker compose up'
            }
        }
    }
}
pipeline {
    agent any
    stages {
        stage("Docker Stop") {
            steps {
                sh "docker compose down"
            }
        }
        stage("Docker build") {
            steps {
                sh "docker compose build"
            }
        }
        stage("Deploy to staging") {
            steps {
                sh "docker compose up -d"
            }
        }
    }
}
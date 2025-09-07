pipeline {
    agent any

    tools {
        maven 'Maven-3.8.5'   // This is the name you set in Jenkins global tools
    }

    environment {
        DOCKER_HUB_CREDENTIALS_ID = 'docker-hub-credentials'
        DOCKER_IMAGE = 'manjuk08/spring-boot-app'
        IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    bat "docker build -t ${DOCKER_IMAGE}:${IMAGE_TAG} ."
                }
            }
        }

       stage('Push Docker Image') {
           steps {
               withCredentials([usernamePassword(credentialsId: "${DOCKER_HUB_CREDENTIALS_ID}", passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                   retry(3) {
                       bat '''
                       docker login -u %DOCKER_USERNAME% -p %DOCKER_PASSWORD%
                       docker push manjuk08/spring-boot-app:latest
                       '''
                   }
               }
           }
       }

        stage('Deploy') {
            steps {
                bat 'docker-compose pull app'
                bat 'docker-compose up -d'
            }
        }
    }
}

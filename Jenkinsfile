pipeline{
    agent any

    environment{
      DOCKER_HUB_CREDENTIALS_ID= 'docker-hub-credentials'
      DOCKER_IMAGE = 'manjuk08/spring-boot-app'
      IMAGE_TAG = 'latest'
    }

    stages{
     stage('Checkout'){
        steps{
          checkout scm
        }
     }
     stage('Build with Maven'){
        steps{
          sh 'mvn clean package -DskipTests'
        }
     }
     stage('Build Docker Image'){
       steps{
         script{
            docker.build("${DOCKER_IMAGE}:${IMAGE_TAG}")
         }
       }
     }
     stage('Push Docker Image') {
         steps {
           script {
             docker.withRegistry('https://index.docker.io/v1/', "${DOCKER_HUB_CREDENTIALS_ID}") {
             docker.image("${DOCKER_IMAGE}:${IMAGE_TAG}").push()
              }
           }
         }
     }
      stage('Deploy') {
             steps {
                 sh 'docker-compose pull app'
                 sh 'docker-compose up -d'
             }
      }
      }
}
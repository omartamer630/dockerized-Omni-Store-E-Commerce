pipeline{
    agent any
    environment {
        DOCKER_USER = credentials('9') // Assuming credentials are stored in Jenkins
    }
    stages{      
        stage("Image Build"){
            steps{
                sh "docker compose build "
                sh "docker images"

            }
        }
        stage("Image Test"){
            steps{
                sh "docker compose up -d"
                sh "docker ps"

            }
        }
        stage("Image Push"){
            steps{
              withCredentials([usernamePassword(credentialsId: '9', usernameVariable: 'DOCKER_USER_USR', passwordVariable: 'DOCKER_USER_PSW')]) {
                    sh "echo $DOCKER_USER_PSW | docker login -u $DOCKER_USER_USR -p --password-stdin"
                    sh "docker push omartamer12/omni-store-e-commerce-frontend"
                    sh "docker push omartamer12/omni-store-e-commerce-backend"
                }
            }
        }
        }
    }
    post{
        success{
            echo "========pipeline executed successfully ========"
        }
        failure{
            echo "========pipeline execution failed========"
        }
    }



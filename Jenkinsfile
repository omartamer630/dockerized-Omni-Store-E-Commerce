pipeline{
    agent any
    environment {
        DOCKER_USER = credentials('9') // Assuming credentials are stored in Jenkins
    }
    stages{      
        stage("Image Build"){
            steps{
                    sh "docker build -f Dockerfile.back -t omartamer12/omni-store-e-commerce-backend ."
                    sh "docker build -f Dockerfile.front -t omartamer12/omni-store-e-commerce-front ."
                    sh "docker images"

            }
        }
        stage("Image Push"){
            steps{
              withCredentials([usernamePassword(credentials: '9', usernameVariable: 'DOCKER_USR', passwordVariable: 'DOCKER_PSW')]) {
                    sh "echo ${DOCKER_PSW} | docker login -u ${DOCKER_USR} --password-stdin"
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



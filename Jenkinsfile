pipeline{
    agent any
    environment {
        DOCKER_USER = credentials('9') // Assuming credentials are stored in Jenkins
    }
    tools {
        // Specify the tools you want to use
        dockerTool 'Docker' // Assuming 'Docker' is the name of the tool configured in Jenkins
        // Add other tools as needed, e.g., Maven, NodeJS, etc.
    }
    stages{      
        stage("Image Build"){
            steps{
                sh "docker-compose build "
                sh "docker images"

            }
        }
        stage("Image Test"){
            steps{
                sh "docker-compose up -d"
                sh "docker ps"
            }
        }
        stage("Image Push"){
            steps{
              withCredentials([usernamePassword(credentials: '9', usernameVariable: 'DOCKER_USR', passwordVariable: 'DOCKER_PSW')]) {
                    sh "echo ${DOCKER_PSW} | docker login -u ${DOCKER_USR} -p --password-stdin"
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



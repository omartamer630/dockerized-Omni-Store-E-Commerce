pipeline{
    agent {
        docker {
            image 'docker:20.10.8'  // Use Docker-in-Docker image
            args '-v /var/run/docker.sock:/var/run/docker.sock'  // Mount Docker socket for Docker-in-Docker
        }
    }
    environment {
        DOCKER_USER = credentials('9') // Assuming credentials are stored in Jenkins
    }
    stages{
        stage("Repo Clone"){
            steps{
                git "https://github.com/omartamer630/dockerized-Omni-Store-E-Commerce"
            }
            }
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
                sh "docker login -u $DOCKER_USER_USR -p $DOCKER_USER_PSW"
                sh "docker push omartamer12/omni-store-e-commerce-frontend "
                sh "docker push omartamer12/omni-store-e-commerce-backend "
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

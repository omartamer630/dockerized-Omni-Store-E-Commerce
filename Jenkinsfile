pipeline{
    agent any
    environment {
        DOCKER_USER = credentials('9') // Assuming credentials are stored in Jenkins
    }
    stages{
        stage("Repo Clone"){
            steps{
               sh "apt update"
               sh "apt install curl"
               sh "curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/trusted.gpg.d/docker.gpg"
               sh "add-apt-repository 'deb [arch=$(dpkg --print-architecture)] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable'"
               sh "apt -y install lsb-release gnupg apt-transport-https ca-certificates curl software-properties-common"
               sh "apt -y install docker-ce docker-ce-cli containerd.io docker-compose-plugin docker-registry"
               sh "usermod -aG docker $USER"
               sh "newgrp docker"
            }
            }
        stage("Docker Install"){
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



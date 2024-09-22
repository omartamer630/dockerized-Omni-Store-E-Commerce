pipeline {
    agent any

    stages {
        stage("Image Build") {
            steps {
                // Build the backend and frontend images
                sh '''
                    docker build -f Dockerfile.back -t omartamer12/omni-store-e-commerce:backend-${IMAGE_TAG} .
                    docker build -f Dockerfile.front -t omartamer12/omni-store-e-commerce:frontend-${IMAGE_TAG} .
                    docker images
                '''
            }
        }

        stage("Image Push") {
            steps {
                // Use withCredentials to securely handle credentials
                withCredentials([usernamePassword(credentialsId: '9', usernameVariable: 'DOCKER_USR', passwordVariable: 'DOCKER_PSW')]) {
                    sh '''
                        echo $DOCKER_PSW | docker login -u $DOCKER_USR --password-stdin
                        docker push omartamer12/omni-store-e-commerce:frontend-${IMAGE_TAG}
                        docker push omartamer12/omni-store-e-commerce:backend-${IMAGE_TAG}
                    '''
                }
            }
        }
    }

    post {
        success {
            echo "======== Pipeline executed successfully ========"
        }
        failure {
            echo "======== Pipeline execution failed ========"
        }
    }
}

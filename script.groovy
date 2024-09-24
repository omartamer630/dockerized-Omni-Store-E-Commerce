def versionChecker() {

    sh '''
    docker compose version
    '''

}

def cleanUp() {
  // -f forces the prune without confirmation
   sh '''
  docker system df
  docker system prune -f
  docker system df
  '''
}

def imageBuild() {
   // Build the backend and frontend images
  sh ''' 
      docker compose build
      docker tag omartamer12/omni-store-e-commerce-backend:latest omartamer12/omni-store-e-commerce:backend-${BUILD_NUMBER}
      docker tag omartamer12/omni-store-e-commerce-frontend:latest omartamer12/omni-store-e-commerce:frontend-${BUILD_NUMBER}
      docker images
    '''
}

def imageTest() {
  sh '''
    docker compose up -d
    docker ps -a
    docker compose down
  '''
}

def imagePush() {
   // Push the images to Docker Hub
  // Use withCredentials to securely handle credentials
    withCredentials([usernamePassword(credentialsId: '9', usernameVariable: 'DOCKER_USR', passwordVariable: 'DOCKER_PSW')]) {
 sh '''
    echo $DOCKER_PSW | docker login -u $DOCKER_USR --password-stdin
    docker push omartamer12/omni-store-e-commerce:frontend-${BUILD_NUMBER}
    docker push omartamer12/omni-store-e-commerce:backend-${BUILD_NUMBER}
    '''
    }
}

def deploy() {
   // Deploy the backend and frontend services
    echo 'deploying the application...'
}

return this

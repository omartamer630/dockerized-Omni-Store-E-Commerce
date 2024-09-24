def versionChecker() {

    sh '''
    docker compose version
    '''

}

def cleanUp() {
   sh '''
  docker system df
  docker system prune -f' // -f forces the prune without confirmation
  docker system df
  '''
}

def imageBuild() {
   // Build the backend and frontend images
  sh ''' 
      docker compose build
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
    docker push omartamer12/omni-store-e-commerce-backend
    docker push omartamer12/omni-store-e-commerce-frontend
    '''
    }
}

def deploy() {
   // Deploy the backend and frontend services
    echo 'deploying the application...'
}

return this

def cleanUp(){
   sh 'docker system prune -f' // -f forces the prune without confirmation
}

def imageBuild(){
               // Build the backend and frontend images
  sh ''' 
      docker build -f Dockerfile.back -t omartamer12/omni-store-e-commerce:backend-${BUILD_NUMBER} .
      docker build -f Dockerfile.front -t omartamer12/omni-store-e-commerce:frontend-${BUILD_NUMBER} .
      docker images
    '''
}

def imagePush(){
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

def deploy(){
   // Deploy the backend and frontend services
    echo 'deploying the application...'
}

return this

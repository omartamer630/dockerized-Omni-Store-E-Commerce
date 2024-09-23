def gv

pipeline {
    agent any

    stages {
        stage("init groovy") {
            steps {
              script {
                gv = load "script.groovy"
              }
            }
        }
        stage("Cleanup") {
          steps {
            script {
                gv.cleanUp()
            }
          }
        }
        stage("Image Build") {
            steps {
               script{
                gv.imageBuild()
               }
            }
        }

        stage("Image Push") {
            steps {
               script{
                gv.imagePush()
               }
            }
        }
        stage("Deploy") {
            steps {
               script{
                gv.deploy()
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

def gv

pipeline {
    agent any
    tools {
      dockerTool 'Docker'
    }
    stages {
        stage('Check Env') {
            steps {
                sh 'env'
            }
        }
        stage("init groovy") {
            steps {
              script {
                gv = load "script.groovy"
              }
            }
        }
        stage("Docker Version Checker") {
            steps {
            script {
              gv.versionChecker()
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
        stage("Image Test") {
          steps {
            script {
                gv.imageTest()
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

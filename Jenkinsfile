pipeline {
  agent any
  tools { maven 'Maven 3' }
  environment {
    DOCKERHUB = 'kiranreddykr7'
    IMAGE = "${DOCKERHUB}/medicure-service:latest"
  }
  stages {
    stage('Checkout') {
      steps { git branch: 'main', url: 'https://github.com/kirankr7reddy/medicure-service.git' }
    }
    stage('Build & Test') {
      steps {
        sh './mvnw -B clean package'
        sh './mvnw test'
      }
    }
    stage('Docker Build & Push') {
      steps {
        sh "docker build -t ${IMAGE} ."
        withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
          sh 'echo $PASS | docker login -u $USER --password-stdin'
          sh "docker push ${IMAGE}"
        }
      }
    }
  }
}

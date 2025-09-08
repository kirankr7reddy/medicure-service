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
        sh 'chmod +x ./mvnw'
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
    stage('Deploy to Kubernetes') {
      steps {
          sh 'sudo k3s kubectl apply -f k8s/manifest/deployment.yaml'
          sh 'sudo k3s kubectl apply -f k8s/manifest/service.yaml'
          sh 'sudo k3s kubectl rollout restart deployment/medicure-deployment'
      }
    }
    stage('Deploy Node Exporter') {
      steps {
          sh 'sudo k3s kubectl apply -f k8s/manifest/node-exporter-daemonset.yaml'
      }
    }
  }
}   
  


pipeline {
    agent any

    tools {
        maven 'Maven 3.9.x' // Must match the name in Jenkins Tool Configuration
        jdk 'JDK 17'       // Must match the name in Jenkins Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    // Replace 'jothiganesh69' with your Docker Hub ID
                    docker.withRegistry('', 'docker-hub-credentials-id') {
                        def appImage = docker.build("jothi357/payment-system:${env.BUILD_NUMBER}")
                        appImage.push()
                        appImage.push('latest')
                    }
                }
            }
        }

        stage('K8s Deploy') {
            steps {
                sh 'kubectl apply -f k8s/deployment.yaml'
                sh 'kubectl apply -f k8s/service.yaml'
            }
        }
    }
}

pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'rlaaudgus/my-test3'
        DOCKERFILE_PATH = 'web/Dockerfile'
        YAML_FILE_PATH = '/root/my-app3.yaml'  // Correct path to my-app3.yaml
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    git branch: 'main', credentialsId: 'github_access_token', url: 'https://github.com/myeonghyun-7011/ToyProject.git'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    def imageTag = env.BUILD_NUMBER
                    docker.build("${DOCKER_IMAGE_NAME}:${imageTag}", "--file ${DOCKERFILE_PATH} .")
                }
            }
        }
        stage('Update YAML with New Image Tag') {
            steps {
                script {
                    def imageTag = env.BUILD_NUMBER
                    sh "sed -i 's#image: ${DOCKER_IMAGE_NAME}:.*#image: ${DOCKER_IMAGE_NAME}:${imageTag}#' ${YAML_FILE_PATH}"
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                script {
                    sh "kubectl apply -f ${YAML_FILE_PATH}"
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                // Add your test commands here
            }
        }
        stage('Deploy to Docker Hub') {
            steps {
                script {
                    def imageTag = env.BUILD_NUMBER
                    docker.withRegistry('https://index.docker.io/v1/', 'hub-token') {
                        docker.image("${DOCKER_IMAGE_NAME}:${imageTag}").push()
                    }
                }
            }
        }
    }
    post {
        always {
            echo 'Pipeline finished.'
        }
    }
}

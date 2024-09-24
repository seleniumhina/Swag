pipeline {
    agent any
    
    environment {
        GIT_URL = 'https://github.com/seleniumhina/Swag.git'
        RECIPIENT = 'hinainamdar678@gmail.com'
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code...'
                git branch: 'main', url: "${https://github.com/seleniumhina/Swag}"
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                sh 'scp target/myapp.jar user@server:/path/to/deploy/'
            }
        }
    }
    
    post {
        success {
            echo 'Build succeeded!'
            mail to: "${hinainamdar678@gmail.com

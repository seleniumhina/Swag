pipeline {
    agent any  // Runs on any available agent (e.g., Jenkins node)
    
    stages {
        stage('Build') {
            steps {
                echo 'Building project...'
                // Example of running a build command
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Example of running tests
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                // Example of a deployment command
                sh 'scp target/myapp.jar user@server:/path/to/deploy/'
            }
        }
    }
    
    post {
        always {
            echo 'Cleaning up...'
            cleanWs() // Cleans the workspace after the pipeline runs
        }
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}

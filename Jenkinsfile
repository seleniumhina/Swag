pipeline {
    agent any
    tools {
        maven 'Maven_3.6.3' // Make sure this matches your Jenkins Maven installation name
        jdk 'JDK_18' // Replace with the Java version you're using
    }
    environment {
        CHROME_DRIVER = 'C:\Webdriver\chromedriver-win64\chromedriver-win64' // Path to the ChromeDriver
    }
    stages {
        stage('Checkout') {
            steps {
                // Pull the latest code from the repository
                git branch: 'master', url: 'https://github.com/seleniumhina/Swag.git'
            }
        }
        stage('Set Up Maven') {
            steps {
                // Set up any required environment variables or configurations
                sh 'export MAVEN_OPTS="-Xmx1024m"'
            }
        }
        stage('Build') {
            steps {
                // Build the project and run tests using Maven
                sh 'mvn clean install'
            }
        }
        stage('Execute Tests') {
            steps {
                // Execute the test cases, using TestNG or JUnit
                sh 'mvn test'
            }
        }
        stage('Post Test Actions') {
            steps {
                // Generate test reports, logs, or any post-build actions
                junit '**/target/surefire-reports/*.xml' // Change path if you're using a different framework
            }
        }
    }
    post {
        always {
            // Archive the reports and clean up
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            cleanWs() // Clean the workspace after execution
        }
    }
}

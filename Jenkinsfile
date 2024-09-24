pipeline {
    agent any    
    tools {
        jdk 'JAVA_HOME' // Use the correct name of the JDK set in Jenkins Global Tool Configuration
        maven 'apache-maven-3.9.8' // Use the correct name of the Maven installation
    }
    stages {
        stage('Git Checkout') {			
            steps {			
                git changelog: false, 
                    credentialsId: '28b72801-cbc2-44ed-bf9a-5f5f9abb64e6', 
                    poll: false, 
                    url: 'https://github.com/seleniumhina/Swag.git'
            }			
        }
        stage('COMPILE') {			
            steps {
                // Change 'sh' to 'bat' for Windows environments
                bat "mvn clean compile -DskipTests=true" // Use 'bat' for Windows
            }			
        }
        stage('TEST') { // Added TEST stage
            steps {
                bat "mvn test" // Run the tests
            }
        }
    }
    post {
        success {
            // If Maven was able to run the tests, even if some of the tests failed, record the test results and archive the report.
            publishHTML([				
                allowMissing: false, 				
                alwaysLinkToLastBuild: false, 				
                keepAll: false, 				
                reportDir: 'target/surefire-reports/', 				
                reportFiles: 'emailable-report.html', 				
                reportName: 'HTML Report', 				
                reportTitles: '', 				
                useWrapperFileDirectly: true
            ])
        }
    }
}

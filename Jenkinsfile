pipeline {						
    agent any						
 						
    stages {						
        stage('Test') {						
            steps {						
                // Run Maven with verbose mode to show detailed actions
                bat "mvn -X -B clean test"  
                
                // Show all actions in the console
                echo 'Running Maven build with verbose logging enabled'
            }						
 						
            post {                						
                // If Maven was able to run the tests, even if some of the test						
                // failed, record the test results and archive the jar file.						
                success {						
                   echo 'Publishing HTML Report'  // Log action for publishing HTML report
                   publishHTML([						
                       allowMissing: false, 						
                       alwaysLinkToLastBuild: false, 						
                       keepAll: false, 						
                       reportDir: 'target/surefire-reports/', 						
                       reportFiles: 'emailable-report.html', 						
                       reportName: 'HTML Report', 						
                       reportTitles: '', 						
                       useWrapperFileDirectly: true])						
                }						
            }						
        }						
    }						
}

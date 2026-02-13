pipeline {
    agent any

    stages {
        stage('Test') {
            agent {
                docker {
                    image 'selenium/standalone-chrome:latest'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn clean test -Dsuite="testng" -Dcucumber.filter.tags="@test"'
            }
        }
    }
}

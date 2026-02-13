pipeline {
    agent any

    stages {
        stage('Test') {
            agent {
                docker {
                    image 'maven:3.9.6-eclipse-temurin-17'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn clean test -Dsuite="testng" -Dcucumber.filter.tags="@test"'
            }
        }
    }
}

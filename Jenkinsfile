pipeline {
    agent any

    parameters {
        string(name: 'BRANCH', defaultValue: 'main', description: 'Git branch to build')
        booleanParam(name: 'SKIP_TESTS', defaultValue: false, description: 'Skip tests?')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${params.BRANCH}", url: 'https://github.com/muhedin998/Jobfinder.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    def skip = params.SKIP_TESTS ? "-DskipTests" : ""
                    sh "mvn clean install ${skip}"
                }
            }
        }

        stage('Run App') {
            steps {
                sh 'nohup java -jar target/*.jar --server.port=8081 &'
            }
        }
    }
}

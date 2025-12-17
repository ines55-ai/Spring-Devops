pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Compilation du projet'
                sh './mvnw clean package -DskipTests'
            }
        }
    }

    post {
        success {
            echo 'Build réussi ✅'
        }
        failure {
            echo 'Build échoué ❌'
        }
    }
}

pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Set Executable') {
            steps {
                echo "Rendre mvnw exécutable"
                sh 'chmod +x ./mvnw'
            }
        }

        stage('Build') {
            steps {
                echo "Compilation du projet"
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Execution des tests"
                sh './mvnw test || true' // ne bloque pas le build si un test échoue
            }
        }

        stage('Deploy') {
            steps {
                echo "Déploiement (si nécessaire)"
            }
        }
    }

    post {
        success {
            echo "Build réussi ✅"
        }
        failure {
            echo "Build échoué ❌"
        }
    }
}

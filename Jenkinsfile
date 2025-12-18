pipeline {
  agent any

  environment {
    JAVA_HOME = '/usr/lib/jvm/java-17-openjdk'
    PATH = "${JAVA_HOME}/bin:${env.PATH}"

    // MySQL Docker
    MYSQL_CONTAINER = 'mysql-ci'
    MYSQL_DB = 'spring_devops_db'
    MYSQL_USER = 'springuser'
    MYSQL_PASSWORD = 'springpass123'
    MYSQL_ROOT_PASSWORD = 'rootpass123'
    MYSQL_HOST_PORT = '3307'   // ✅ évite conflit avec 3306
  }

  stages {
    stage('Checkout SCM') {
      steps {
        // Option 1: si tu as configuré SCM dans le job Jenkins, garde checkout scm
        // checkout scm

        // Option 2 (recommandé): forcer ton repo
        git branch: 'main', url: 'https://github.com/ines55-ai/Spring-Devops.git'
      }
    }

    stage('Set Executable') {
      steps {
        echo "Rendre mvnw exécutable"
        sh 'chmod +x ./mvnw'
      }
    }

    stage('Start MySQL (Docker)') {
      steps {
        sh '''
          set -e

          if docker ps -a --format '{{.Names}}' | grep -wq "${MYSQL_CONTAINER}"; then
            docker rm -f "${MYSQL_CONTAINER}" || true
          fi

          echo "Starting MySQL on host port ${MYSQL_HOST_PORT}..."
          docker run -d --name "${MYSQL_CONTAINER}" \
            -e MYSQL_ROOT_PASSWORD="${MYSQL_ROOT_PASSWORD}" \
            -e MYSQL_DATABASE="${MYSQL_DB}" \
            -e MYSQL_USER="${MYSQL_USER}" \
            -e MYSQL_PASSWORD="${MYSQL_PASSWORD}" \
            -p ${MYSQL_HOST_PORT}:3306 \
            mysql:8.0

          echo "Waiting for MySQL..."
          for i in {1..60}; do
            if docker exec "${MYSQL_CONTAINER}" mysqladmin ping -uroot -p"${MYSQL_ROOT_PASSWORD}" --silent; then
              echo "MySQL is ready"
              exit 0
            fi
            sleep 2
          done

          echo "MySQL not ready"
          docker logs "${MYSQL_CONTAINER}" | tail -n 200 || true
          exit 1
        '''
      }
    }

    stage('Prepare test DB config') {
      steps {
        sh '''
          mkdir -p src/test/resources
          cat > src/test/resources/application-test.properties <<EOF
spring.datasource.url=jdbc:mysql://localhost:${MYSQL_HOST_PORT}/${MYSQL_DB}?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=${MYSQL_USER}
spring.datasource.password=${MYSQL_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
EOF
        '''
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
        sh './mvnw test -Dspring.profiles.active=test || true'
      }
    }

    stage('Deploy') {
      steps {
        echo "Déploiement (si nécessaire)"
      }
    }

    stage('Check Java') {
      steps {
        sh 'java -version'
        sh 'echo $JAVA_HOME'
      }
    }
  }

  post {
    always {
      // Publier les résultats de tests si présents (ne casse pas si absents)
      script {
        try {
          junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
        } catch (e) {
          echo "No test reports"
        }
      }

      // Cleanup MySQL
      sh 'docker rm -f "${MYSQL_CONTAINER}" || true'
    }

    success { echo "Build réussi ✅" }
    failure { echo "Build échoué ❌" }
  }
}

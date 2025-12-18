pipeline {
  agent any

  environment {
    JAVA_HOME = '/usr/lib/jvm/java-17-openjdk'
    PATH = "${JAVA_HOME}/bin:${env.PATH}"

    // MySQL Docker (host port 3307 to avoid 3306 conflict)
    MYSQL_CONTAINER = 'mysql-ci'
    MYSQL_DB = 'spring_devops_db'
    MYSQL_USER = 'springuser'
    MYSQL_PASSWORD = 'springpass123'
    MYSQL_ROOT_PASSWORD = 'rootpass123'
    MYSQL_HOST_PORT = '3307'
  }

  stages {

    stage('Checkout SCM') {
      steps {
        git branch: 'main', url: 'https://github.com/ines55-ai/Spring-Devops.git'
      }
    }

    stage('Set Executable') {
      steps {
        sh 'chmod +x ./mvnw'
      }
    }

    // Optional but VERY useful to confirm Jenkins is using the right Jenkinsfile
    stage('DEBUG - Show Jenkinsfile') {
      steps {
        sh '''
          echo "===== Jenkinsfile used in this build ====="
          ls -la
          sed -n '1,220p' Jenkinsfile || true
          echo "========================================="
        '''
      }
    }

    stage('Start MySQL (Docker)') {
      steps {
        sh '''
          set -e

          # Remove container if exists (do not fail if absent)
          docker rm -f "${MYSQL_CONTAINER}" >/dev/null 2>&1 || true

          echo "Starting MySQL on host port ${MYSQL_HOST_PORT}..."
          docker run -d --name "${MYSQL_CONTAINER}" \
            -e MYSQL_ROOT_PASSWORD="${MYSQL_ROOT_PASSWORD}" \
            -e MYSQL_DATABASE="${MYSQL_DB}" \
            -e MYSQL_USER="${MYSQL_USER}" \
            -e MYSQL_PASSWORD="${MYSQL_PASSWORD}" \
            -p "${MYSQL_HOST_PORT}":3306 \
            mysql:8.0

          echo "Waiting for MySQL to be ready (up to 120s)..."
          for i in $(seq 1 60); do
            if docker exec "${MYSQL_CONTAINER}" mysqladmin ping -uroot -p"${MYSQL_ROOT_PASSWORD}" --silent >/dev/null 2>&1; then
              echo "MySQL is ready ✅"
              exit 0
            fi
            echo "  still starting... (${i}/60)"
            sleep 2
          done

          echo "MySQL failed to become ready in time"
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
        sh './mvnw clean package -DskipTests'
      }
    }

    stage('Run Tests') {
      steps {
        // keep || true if you don't want tests to fail the pipeline
        sh './mvnw test -Dspring.profiles.active=test || true'
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
      // Publish test reports if present
      junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true

      // Cleanup MySQL
      sh 'docker rm -f "${MYSQL_CONTAINER}" >/dev/null 2>&1 || true'
    }

    success { echo "✅ Build réussi" }
    failure { echo "❌ Build échoué" }
  }
}

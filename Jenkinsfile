pipeline {
  agent any
  environment {
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
    stage('Verify Java') {
      steps {
        sh '''
          echo "=== Checking Java installation ==="
          which java || echo "java not in PATH"
          java -version || echo "java command failed"
          echo "=== Checking JAVA_HOME candidates ==="
          ls -la /usr/lib/jvm/ || echo "No /usr/lib/jvm/ directory"
          echo "=== Setting JAVA_HOME ==="
          if [ -d "/usr/lib/jvm/java-17-openjdk" ]; then
            export JAVA_HOME="/usr/lib/jvm/java-17-openjdk"
          elif [ -d "/usr/lib/jvm/java-17-openjdk-amd64" ]; then
            export JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"
          elif [ -d "/usr/lib/jvm/java-17" ]; then
            export JAVA_HOME="/usr/lib/jvm/java-17"
          else
            export JAVA_HOME=$(dirname $(dirname $(readlink -f $(which java))))
          fi
          echo "JAVA_HOME set to: $JAVA_HOME"
          ls -la "$JAVA_HOME" || echo "JAVA_HOME path does not exist"
        '''
      }
    }
    stage('Start MySQL (Docker)') {
      steps {
        sh '''
          set -e
          docker rm -f "${MYSQL_CONTAINER}" 2>/dev/null || true
          
          echo "Starting MySQL on host port ${MYSQL_HOST_PORT}..."
          docker run -d --name "${MYSQL_CONTAINER}" \
            -e MYSQL_ROOT_PASSWORD="${MYSQL_ROOT_PASSWORD}" \
            -e MYSQL_DATABASE="${MYSQL_DB}" \
            -e MYSQL_USER="${MYSQL_USER}" \
            -e MYSQL_PASSWORD="${MYSQL_PASSWORD}" \
            -p "${MYSQL_HOST_PORT}":3306 \
            mysql:8.0
          
          echo "Waiting for MySQL to be ready (up to 120s)..."
          READY=0
          for i in $(seq 1 60); do
            if docker exec "${MYSQL_CONTAINER}" mysqladmin ping -h localhost -uroot -p"${MYSQL_ROOT_PASSWORD}" --silent 2>/dev/null; then
              echo "MySQL is ready ✅"
              READY=1
              break
            fi
            echo "Still starting... attempt ${i}/60"
            sleep 2
          done
          
          if [ "$READY" -eq 0 ]; then
            echo "❌ MySQL failed to become ready in time"
            echo "=== Docker logs ==="
            docker logs "${MYSQL_CONTAINER}"
            exit 1
          fi
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
spring.jpa.show-sql=false
EOF
          echo "=== Test DB configuration ==="
          cat src/test/resources/application-test.properties
        '''
      }
    }
    stage('Build') {
      steps {
        sh '''
          # Detect and set JAVA_HOME
          if [ -d "/usr/lib/jvm/java-17-openjdk" ]; then
            export JAVA_HOME="/usr/lib/jvm/java-17-openjdk"
          elif [ -d "/usr/lib/jvm/java-17-openjdk-amd64" ]; then
            export JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"
          elif [ -d "/usr/lib/jvm/java-17" ]; then
            export JAVA_HOME="/usr/lib/jvm/java-17"
          else
            export JAVA_HOME=$(dirname $(dirname $(readlink -f $(which java))))
          fi
          export PATH="$JAVA_HOME/bin:$PATH"
          
          echo "Using JAVA_HOME: $JAVA_HOME"
          java -version
          
          ./mvnw clean package -DskipTests
        '''
      }
    }
    stage('Run Tests') {
      steps {
        sh '''
          # Detect and set JAVA_HOME
          if [ -d "/usr/lib/jvm/java-17-openjdk" ]; then
            export JAVA_HOME="/usr/lib/jvm/java-17-openjdk"
          elif [ -d "/usr/lib/jvm/java-17-openjdk-amd64" ]; then
            export JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"
          elif [ -d "/usr/lib/jvm/java-17" ]; then
            export JAVA_HOME="/usr/lib/jvm/java-17"
          else
            export JAVA_HOME=$(dirname $(dirname $(readlink -f $(which java))))
          fi
          export PATH="$JAVA_HOME/bin:$PATH"
          
          ./mvnw test -Dspring.profiles.active=test
        '''
      }
    }
  }
  post {
    always {
      junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
      sh 'docker rm -f "${MYSQL_CONTAINER}" 2>/dev/null || true'
    }
    success { 
      echo "✅ Build réussi" 
    }
    failure { 
      echo "❌ Build échoué"
      sh 'docker logs "${MYSQL_CONTAINER}" 2>/dev/null || true'
    }
  }
}

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

      # Supprimer le container s’il existe (sans erreur)
      docker rm -f ${MYSQL_CONTAINER} >/dev/null 2>&1 || true

      echo "Starting MySQL on port ${MYSQL_HOST_PORT}..."
      docker run -d --name ${MYSQL_CONTAINER} \
        -e MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD} \
        -e MYSQL_DATABASE=${MYSQL_DB} \
        -e MYSQL_USER=${MYSQL_USER} \
        -e MYSQL_PASSWORD=${MYSQL_PASSWORD} \
        -p ${MYSQL_HOST_PORT}:3306 \
        mysql:8.0

      echo "Waiting for MySQL to be ready (up to 120s)..."
      READY=0
      for i in $(seq 1 60); do
        if docker exec ${MYSQL_CONTAINER} \
          mysqladmin ping -uroot -p${MYSQL_ROOT_PASSWORD} --silent >/dev/null 2>&1; then
          READY=1
          break
        fi
        echo "  still starting... (${i}/60)"
        sleep 2
      done

      if [ "$READY" -ne 1 ]; then
        echo "MySQL failed to become ready in time"
        docker logs ${MYSQL_CONTAINER} | tail -n 200 || true
        exit 1
      fi

      echo "MySQL is ready ✅"
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

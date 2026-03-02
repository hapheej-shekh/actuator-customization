pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                echo 'Downloads the latest code from your GitHub repository'
                git branch: 'main', url: 'https://github.com/hapheej-shekh/actuator-customization.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Compiles the code, runs tests, and packages it into a runnable JAR'
                sh "mvn clean package -DskipTests" 
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo 'Saves the JAR file in Jenkins so it can be downloaded or used later'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
        
        stage('Deploy') {
            steps {
                script {
                    def ws = pwd()
                    def jarName = "actuator-customization-0.0.1-SNAPSHOT.jar"
                    
                    echo "Stopping old process on 9091..."
                    sh "fuser -k 9091/tcp || true"
                    
                    echo "Starting Application..."
                    // Remove the second 'sh' inside the triple quotes
                    sh """
                        JENKINS_NODE_COOKIE=dontKillMe nohup java -jar ${ws}/target/${jarName} --server.port=9091 > ${ws}/app.log 2>&1 &
                    """
                    
                    echo "Waiting for app to initialize..."
                    sh "sleep 10"
                    
                    // This verifies the port is actually active
                    sh "netstat -tulpn | grep :9091 || true"
                }
            }
        }
        
        /*
        stage('Deploy') {
            desc 'Moves the JAR to the target server and starts the application'
            steps {
                echo 'Deploying JAR to target server...'
                // For JARs, you typically use SSH to move the file and run it:
                // sh "scp target/*.jar user@your-ec2-ip:/home/ubuntu/"
                // sh "ssh user@your-ec2-ip 'java -jar /home/ubuntu/*.jar &'"
            }
        }*/
    }
}

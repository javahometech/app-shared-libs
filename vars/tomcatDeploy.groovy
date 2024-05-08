def call(){
    sshagent(['tomcatdev-7am']) {
    sh "scp -o StrictHostKeyChecking=no target/devops-app.war ec2-user@54.82.16.197:/opt/tomcat9/webapps"
    sh "ssh ec2-user@54.82.16.197 /opt/tomcat9/bin/shutdown.sh"
    sh "ssh ec2-user@54.82.16.197 /opt/tomcat9/bin/startup.sh"
}

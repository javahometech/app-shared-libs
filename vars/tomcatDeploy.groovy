def call(tomcatIp){
    sshagent(['tomcatdev-7am']) {
    sh "scp -o StrictHostKeyChecking=no target/devops-app.war ec2-user@${tomcatIp}:/opt/tomcat9/webapps"
    sh "ssh ec2-user@${tomcatIp} /opt/tomcat9/bin/shutdown.sh"
    sh "ssh ec2-user@${tomcatIp} /opt/tomcat9/bin/startup.sh"
}

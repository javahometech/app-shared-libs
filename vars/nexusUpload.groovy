def call(repoName){
  def pom = readMavenPom file: "pom.xml"
  def version = pom.version
  def groupId = pom.groupId
  def artifactId = pom.artifactId
  nexusArtifactUploader artifacts: [[artifactId: "${artifactId}", classifier: '', file: "target/${artifactId}.war", type: 'war']], 
  credentialsId: 'nexus3', 
  groupId: "${groupId}", 
  nexusUrl: '34.226.210.113:8081/', 
  nexusVersion: 'nexus3', protocol: 'http', repository: "${repoName}", version: "${version}"
}

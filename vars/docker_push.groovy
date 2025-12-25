/*def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
      sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
*/

// vars/docker_push.groovy
def call(String Project, String ImageTag, String acrServer){
  // Use the Credential ID created in Jenkins for Azure ACR
  withCredentials([usernamePassword(credentialsId: 'azure-acr-creds', passwordVariable: 'acrPass', usernameVariable: 'acrUser')]) {
      sh "docker login ${acrServer} -u ${acrUser} -p ${acrPass}"
  }
  sh "docker push ${acrServer}/${Project}:${ImageTag}"
}


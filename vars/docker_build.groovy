// Define function
/*def call(String ProjectName, String ImageTag, String DockerHubUser){
  sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag} ."
}
*/

// vars/docker_build.groovy
def call(String ProjectName, String ImageTag, String acrServer){
  // Tags the image with the full ACR path: registry.azurecr.io/image:tag
  sh "docker build -t ${acrServer}/${ProjectName}:${ImageTag} ."
}


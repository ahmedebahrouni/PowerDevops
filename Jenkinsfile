pipeline{
    agent any



    stages {


        stage('Getting project from Git') {
            steps{
      			checkout([$class: 'GitSCM', branches: [[name: '*/main']],
			extensions: [],
			userRemoteConfigs: [[url: 'https://github.com/ahmedebahrouni/PowerDevops.git']]])
            }
        }


       stage('Cleaning the project') {
            steps{
                	sh "mvn -B -DskipTests clean  "

            }
        }



        stage('Artifact Construction') {
            steps{
                	sh "mvn -B -DskipTests package "
            }
        }



         stage('Unit Tests') {
            steps{
               		 sh "mvn test "
            }
        }




                 stage('Code Quality Check via SonarQube') {
                   steps{

       sh " mvn clean verify sonar:sonar -Dsonar.projectKey=powerdevops -Dsonar.projectName='powerdevops' -Dsonar.host.url=http://192.168.33.10:9000 -Dsonar.token=sqp_09b8c5e3f3d0ff40ae63a2ab52ac6b90190c5076"
                   }
               }


                stage('Publish to Nexus') {
                   steps {



         sh 'mvn clean package deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=achat -Dversion=1.2 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.33.10:8081/repository/maven-releases/ -Dfile=target/achat-1.2.jar'



                   }
               }

 stage('Build Docker Image') {
                      steps {
                          script {
                            sh 'docker build -t ahmed1919/ahmedtest:back .'
                          }
                      }
                  }

                  stage('login dockerhub') {
                                        steps {

				sh 'docker login -u ahmed1919 --password dckr_pat_wRsBljrIeVpG1l8CBB5TxXBXKqA'
                                            }
		  }

	                      stage('Push Docker Image') {
                                        steps {
                                   sh 'docker push ahmed1919/ahmedtest:back'
                                            }
		  }


/*
stage('clone frontend'){
         steps{
             script{
                   checkout([$class: 'GitSCM', branches: [[name: '*//*
 */
/*  *//*
 */
/*  *//*
 */
/*  *//*
 */
/*  *//*
 */
/*  *//*
 */
/*  *//*
 */
/*  *//*
 */
/*  *//*
 */
/*  *//*
 */
/*  *//*
 */
/*  *//*
 */
/*  *//*
 */
/*  *//*
 */
/*  *//*
 */
/*  *//*
 */
/* main']], extensions: [], userRemoteConfigs: [[url:"https://github.com/ahmedebahrouni/front.git"


]]])
             }
         }

 }





	    stage('Build Frontend Docker Image') {
                      steps {
                          script {
                             sh 'docker login -u ahmed1919 --password dckr_pat_wRsBljrIeVpG1l8CBB5TxXBXKqA'
                            sh 'docker build -t ahmed1919/ahmedtest:front .'
                          }
                      }
                  }

 stage("Push Frontend Docker image") {


            steps {
                script {

             sh 'docker login -u ahmed1919 --password dckr_pat_wRsBljrIeVpG1l8CBB5TxXBXKqA'

             sh "docker push ahmed1919/ahmedtest:front"

                }
            }




            }
 */

		   stage('Run Spring && MySQL Containers yes') {
               steps {
                   script {
                       sh 'docker-compose up '

                   }
               }
           }







}


        post {
		success{
		mail bcc: '', body: '''Dear Med ahmed bahrouni ,
we are happy to inform you that your pipeline build was successful.
Great work !
-Jenkins Team-''', cc: '', from: 'ahmed.bahrouni@esprit.tn', replyTo: '', subject: 'Build Finished - Success', to: 'ahmed.bahrouni@esprit.tn'
		}

		failure{
mail bcc: '', body: '''Dear bahrouni ahmed,
we are sorry to inform you that your pipeline build failed.
Keep working !
-Jenkins Team-''', cc: '', from: 'ahmed.bahrouni@esprit.tn', replyTo: '', subject: 'Build Finished - Failure', to: 'ahmed.bahrouni@esprit.tn'
		}

       always {
		emailext attachLog: true, body: '', subject: 'Build finished',from: 'ahmed.bahrouni@esprit.tn' , to: 'ahmed.bahrouni@esprit.tn'
            cleanWs()
       }
    }



}
       

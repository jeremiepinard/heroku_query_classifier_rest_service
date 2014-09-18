mkdir repo
cp ~/.m2/repository/com/radialpoint/queryclassifier/classifier/0.0.1-139/classifier-0.0.1-139.jar .
# replace the local repo path with the one where you are executing this task
mvn deploy:deploy-file -Durl=file:///home/jeremies/hackathon/sept2014/heroku_query_classifier_rest_service/repo/ -Dfile=classifier-0.0.1-139.jar -DgroupId=com.radialpoint.queryclassifier -DartifactId=classifier -Dpackaging=jar -Dversion=0.0.1-139

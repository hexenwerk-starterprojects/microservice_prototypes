# How to run JavaFx clients

The steps are the same troughout all projects

## run JavaFx in web browser
* JavaFx client can run in docker container and is accessible from thanks to [JPro framework](https://www.jpro.one/)
* You can star the local docker stack by running ```docker-compose.yml```. Important, you must build the mdm-client project befor starting the docker container by running ```mvn clean jpro:release``` (the dockerfile uses the generated artifacts from target folder to build the image.)

![running dockerized JavaFx client in browser](jpro_dockerized_screenshot.gif)


## run JavaFx as desktop app
* You can also run the JavaFx client as a desktop application. 
    * Either from your IDE by starting spring boot application. (mostly called ```Applicatoin.java``` in every project)
    * or by running executable JAR file which you find in your target folder after execuring ```mvn clean install``` command

![running standalone JavaFx client](executable_jar_screenshot.gif)

FYI: if you wonder what the name MDM means, then it is a shortcut for Master Data Management. As I plan to use this starter project to build more comples master data management service for my client.
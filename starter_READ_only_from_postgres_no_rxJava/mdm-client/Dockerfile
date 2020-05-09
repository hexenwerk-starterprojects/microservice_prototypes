FROM adoptopenjdk:11-hotspot-bionic
RUN apt-get update

# packages for successfull running of Jpro service (see Jpro home page documentation)
RUN apt-get -y install xorg gtk2-engines libasound2 libgtk2.0-0
RUN apt-get -y install unzip

WORKDIR /temp

# copy source code from host machine into image's temp folder
COPY ./target/mdm-client-jpro.zip /temp/
COPY ./start_jpro.sh /temp/

# build and assemble JPRO with the application
RUN unzip mdm-client-jpro.zip &&\
    rm -r mdm-client-jpro.zip &&\
    cp start_jpro.sh ./mdm-client-jpro/bin/start.sh &&\
    chmod +x ./mdm-client-jpro/bin/start.sh

WORKDIR /app
RUN mv /temp/mdm-client-jpro /app && rm -r /temp

RUN ["sh", "-c", "echo  -Dhttp.port=$JPRO_SERVER_PORT"]
CMD ["sh", "-c", "./mdm-client-jpro/bin/start.sh  -Dhttp.port=$JPRO_SERVER_PORT"]
FROM adoptopenjdk:11-hotspot-bionic
RUN apt-get update

# packages for successfull running of Jpro service (see Jpro home page documentation)
RUN apt-get -y install xorg gtk2-engines libasound2 libgtk2.0-0
RUN apt-get -y install unzip

WORKDIR /temp

# copy source code from host machine into image's temp folder
COPY ./target/starter_CRUD_with_DB_fxclient-jpro.zip /temp/
COPY ./start_jpro.sh /temp/

# build and assemble JPRO with the application
RUN unzip starter_CRUD_with_DB_fxclient-jpro.zip &&\
    rm -r starter_CRUD_with_DB_fxclient-jpro.zip &&\
    cp start_jpro.sh ./starter_CRUD_with_DB_fxclient-jpro/bin/start.sh &&\
    chmod +x ./starter_CRUD_with_DB_fxclient-jpro/bin/start.sh

WORKDIR /app
RUN mv /temp/starter_CRUD_with_DB_fxclient-jpro /app && rm -r /temp

RUN ["sh", "-c", "echo  -Dhttp.port=$JPRO_SERVER_PORT"]
CMD ["sh", "-c", "./starter_CRUD_with_DB_fxclient-jpro/bin/start.sh  -Dhttp.port=$JPRO_SERVER_PORT"]
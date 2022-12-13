FROM gradle:7.5.1-jdk17

WORKDIR /deploy

COPY /deploy .

RUN gradle installDist

CMD ./build/install/deploy/bin/deploy

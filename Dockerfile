FROM adp-base:latest

# Define working directory.
WORKDIR /books

# Prepare by downloading dependencies
ADD . /books
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]
RUN ["mvn", "package"]

EXPOSE 8080

#ENTRYPOINT ["mvn","spring-boot:run"]

ADD ./books-startup.sh /books-startup.sh
RUN bash -c 'chmod +x /books-startup.sh'
# Define default command.
#ENTRYPOINT ["bash"]
#ENTRYPOINT ["mvn","spring-boot:run"]
ENTRYPOINT ["/bin/bash", "/books-startup.sh"]

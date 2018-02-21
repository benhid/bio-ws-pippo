FROM jboss/wildfly:latest

#Set user admin by default
RUN /opt/jboss/wildfly/bin/add-user.sh admin 12345 --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

#Change default image TimeZone
USER root

ENV TZ=Europe/Madrid
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone


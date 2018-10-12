FROM jboss/wildfly:14.0.1.Final

USER root
RUN sed -i s/langs=en_US.utf8/langs=de_DE.utf8/g /etc/yum.conf; \
    yum -y -q reinstall glibc-common
USER jboss

COPY resteasy-docker.war wildfly/standalone/deployments/

EXPOSE 8080 8443 9990 8787

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

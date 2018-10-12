# Resteasy-Docker Locales
When using resteasy on a dockerized wildfly you may have the problem with german umlauts or other
characters wich are not commonly used in an english speaking environment. The jboss/wildfly
docker image only supports the language encoding en_US.utf8 and has no other language installed.
This encoding can not handle umlauts like ä,ö,ü,Ä,Ö,Ü oder signs like ß. To enable the
de_DE.utf8 or simliar encodings you may follow the steps described in the links below
which I used in this example project.   

## Userful Links
[https://serverfault.com/questions/616790/how-to-add-language-support-on-centos-7-on-docker]
[https://major.io/2010/12/08/locate-rpm-packages-which-contain-a-certain-file/]

## Commands
The commands can be run after compiling the project with _maven clean package_ from the _target/docker_
directory.
````
docker build -t mydocker .
docker run -d -p 8080:8080 -p 9990:9990 --name test -e LC_ALL=de_DE.utf8 mydocker
docker exec -it test /bin/bash

or if you want root rights
docker exec -it test -u root /bin/bash
````

If everything has worked as expected the server.log output should look like this:
````
2018-10-12 18:57:50,752 INFO  [stdout] (default task-1) TestPojo{testString='UmlauteäöüÄÖÜß'}
````
Otherwise you will see something like this:
````
2018-10-12 18:57:50,752 INFO  [stdout] (default task-1) TestPojo{testString='Umlaute??????'}
````
To view the logfile you have to connect to your running container with _docker exec ..._ 
and use the command _tail -f /opt/jboss/wildfly/standalone/logs/server.log_

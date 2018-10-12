# Resteasy-Docker Locales

[https://serverfault.com/questions/616790/how-to-add-language-support-on-centos-7-on-docker]
[https://major.io/2010/12/08/locate-rpm-packages-which-contain-a-certain-file/]

## Commands

````
docker build -t mydocker .
docker run -d -p 8080:8080 -p 9990:9990 --name test -e LC_ALL=de_DE.utf8 mydocker
docker exec -it test /bin/bash
docker exec -it test -u root /bin/bash
````


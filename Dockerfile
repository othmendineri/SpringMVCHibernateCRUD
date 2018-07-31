FROM ubuntu:16.04

MAINTAINER Niko Benkler and Tobias Haßberg

# Set environment variables
ENV MD5=4e7ce65489347960e9797d2161e0ada2 \
    JAVA_HOME=/usr/lib/jvm/java-8-oracle \
	PASSWORD=password

ADD startdomain.sh /startdomain.sh 
ADD stopdomain.sh /stopdomain.sh  
ADD restart.sh /restart.sh
ADD pullChanges.sh /pullChanges.sh

RUN \
	apt-get update &&\
	apt-get install -y software-properties-common && \
	add-apt-repository -y ppa:webupd8team/java && \
	echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
	apt-get update &&\
	apt-get install -y oracle-java8-installer python-software-properties unzip ant git python-virtualenv maven && \
	rm -rf /var/lib/apt/lists/* && \
	rm -rf /var/cache/oracle-jdk8-installer

#get glassfish domains 
RUN git clone https://github.com/cocome-community-case-study/cocome-cloud-jee-docker.git usr/src/ && \
 	rm usr/src/*.md  && \
	rm -r usr/src/docker && \
	rm usr/src/glassfish/README.md


ADD cocome-maven-project-setting.xml /usr/src/cocome-maven-project-setting.xml
ADD serviceadapter-settings.xml /usr/src/serviceadapter-settings.xml

#changeFromat and uninstall dos2unix
RUN apt-get update && apt-get install -y dos2unix &&\
	dos2unix /startdomain.sh && \
    dos2unix /restart.sh && \
    dos2unix /pullChanges.sh && \
    dos2unix /stopdomain.sh && apt-get --purge remove -y dos2unix && rm -rf /var/lib/apt/lists/

#Make the scripts executable 
RUN chmod +x /*.sh

# 4848 (administration), 8080 (HTTP listener), 8181 (HTTPS listener)
EXPOSE 8048 8080 8081 8148 8180 8181 8248 8280 8281 8348 8380 8381 8448 8480 8481

CMD ["/startdomain.sh"]

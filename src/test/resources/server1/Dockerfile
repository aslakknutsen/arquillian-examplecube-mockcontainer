FROM centos:7

RUN yum install -y nmap-ncat

EXPOSE 8085
CMD nc -k -l 0.0.0.0 8085 -c 'curl -D - http://pastebin.com'
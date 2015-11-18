FROM phusion/baseimage

EXPOSE 80
CMD while true; do { echo 'HTTP/1.1 200 OK' && echo '' && echo 'INTERCEPTED'; } | nc -vv -l 0.0.0.0 80; done 
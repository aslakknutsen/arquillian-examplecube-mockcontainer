FROM phusion/baseimage

EXPOSE 8085
CMD while true; do { curl -D - http://www.google.com/; } | nc -vv -l 0.0.0.0 8085; done 
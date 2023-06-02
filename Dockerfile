FROM ubuntu:latest
LABEL authors="kahono"

ENTRYPOINT ["top", "-b"]
#!/usr/bin/env sh

CERTS_DIR=$(dirname $0)/certs
echo $CERTS_DIR

openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout $CERTS_DIR/nginx-selfsigned.key -out $CERTS_DIR/nginx-selfsigned.crt
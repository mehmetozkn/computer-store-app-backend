#!/bin/sh

host="$1"
shift
port="$1"
shift

while ! nc -z "$host" "$port" >/dev/null 2>&1; do
  echo "Waiting for $host:$port..."
  sleep 1
done

echo "$host:$port is available, continuing..."

exec "$@"
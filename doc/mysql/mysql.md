# MySQL

## Docker部署

```shell
docker pull mysql
```

```shell
docker run \
-p 6379:6379 \
--name redis-server \
-v /home/docker/redis/data:/data \
-v /home/docker/redis/conf/redis.conf:/etc/redis/redis.conf \
-d redis \
redis-server /etc/redis/redis.conf
```

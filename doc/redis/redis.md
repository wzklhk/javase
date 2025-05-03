# Redis

## Docker部署

```shell
docker pull redis
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

## 数据结构

字符串（str）
列表（list）
集合（set）
有序集合（zset）
哈希（hash）


```json
{
  "str": "value",
  "hash": {
    "name": "Tom",
    "age": "18"
  },
  "list": [
    1,
    2,
    3,
    4,
    4,
    5
  ],
  "set": [
    "cherry",
    "banana",
    "apple"
  ],
  "zset": [
    {
      "member": "Tom",
      "score": 100
    },
    {
      "member": "Spike",
      "score": 150
    },
    {
      "member": "Jerry",
      "score": 200
    }
  ]
}

```

## 应用案例

### 用缓存减轻数据库压力，拉高读写性能。

用 Redis 当 Spring Boot 服务 和 数据库（比如 MySQL）之间的"加速器"

**核心思想**

读的时候：

* 先查 Redis（命中缓存就直接用，数据库都不用看）。
* 没查到 → 再去数据库捞 → 捞完再塞回 Redis。

写的时候：

* 写数据库 ✅
* 同时更新 or 删除 Redis 缓存 ✅（保持一致性，不然就脏了）
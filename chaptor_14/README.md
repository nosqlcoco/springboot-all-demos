#### springboot redis 自定义缓存对象
Core Point：
1. 从 JedisConnectionFactory 获取 RedisConnectionFactory
2. 创建 RedisTemplate 对象，并将 RedisTemplate 的连接工厂设置为 RedisConnectionFactory
3. 在其他类注入 RedisTemplate, RedisTemplate.execute 执行添加/删除/更新操作
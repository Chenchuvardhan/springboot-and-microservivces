package in.cipla.entity;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;
@Data
@RedisHash(value = "ProductHash")
public class Product {
private Integer id;
private String name;
}

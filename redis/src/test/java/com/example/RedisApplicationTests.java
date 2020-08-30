package com.example;

import com.example.entity.Address;
import com.example.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisApplicationTests {

    @Test
    void contextLoads() {
    }


    @Resource(name = "redisTemplate")
    private ValueOperations<String, Object> valueOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> hashOperations;

    @Resource(name = "redisTemplate")
    private ListOperations<String, Object> listOperations;

    @Resource(name = "redisTemplate")
    private SetOperations<String, Object> setOperations;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, Object> zSetOperations;

    @Test
    public void testValueOperation() {
        Person person = new Person("su", "yan");
        person.setAddress(new Address("广州", "中国"));
        // 10 秒之后数据消失
        valueOperations.set("player:1", person, 20, TimeUnit.SECONDS);
        Person getBack = (Person) valueOperations.get("player:1");
        System.out.println(getBack);
    }


    @Test
    public void testSetOperation() {
        Person person1 = new Person("生", "苏");
        Person person2 = new Person("洛", "苏");
        setOperations.add("playerSet", person1, person2);
        Set<Object> result = setOperations.members("playerSet");
        System.out.println(result);
    }

    @Test
    public void testHashOperation() {
        Person person = new Person("su", "yan");
        hashOperations.put("hash:player", "firstName", person.getFirstName());
        hashOperations.put("hash:player", "lastName", person.getLastName());
        hashOperations.put("hash:player", "address", person.getAddress());
        System.out.println(hashOperations.get("hash:player", "firstName"));
    }

    @Test
    public void testListOperation() {
        listOperations.leftPush("list:player", new Person("初见", "苏"));
        listOperations.leftPush("list:player", new Person("人生", "苏"));
        listOperations.leftPush("list:player", new Person("恋爱", "苏"));
        System.out.println(listOperations.leftPop("list:player"));
    }
}

package com.example;

import com.example.entity.Address;
import com.example.entity.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author suYan
 * @Date 2020/8/12 22:18
 * 使用 RedisTemplate操作数据
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RedisConfigTest {

    @Autowired
    private RedisTemplate redisTemplate;

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
    public void testValueOperation() throws Exception {
        Person person = new Person("su", "yan");
        person.setAddress(new Address("广州", "中国"));
        // 10 秒之后数据消失
        valueOperations.set("player:1", person, 20, TimeUnit.SECONDS);
        Person getBack = (Person) valueOperations.get("player:1");
        System.out.println(getBack);
    }


    @Test
    public void testSetOperation() throws Exception {
        Person person1 = new Person("生", "苏");
        Person person2 = new Person("洛", "苏");
        setOperations.add("playerSet", person1, person2);
        Set<Object> result = setOperations.members("playerSet");
        System.out.println(result);
    }

    @Test
    public void testHashOperation() throws  Exception {
        Person person = new Person("su", "yan");
        hashOperations.put("hash:player", "firstName", person.getFirstName());
        hashOperations.put("hash:player", "lastName", person.getLastName());
        hashOperations.put("hash:player", "address", person.getAddress());
        System.out.println(hashOperations.get("hash:player", "firstName"));
    }

    @Test
    public void testListOperation() throws Exception {
        listOperations.leftPush("list:player", new Person("初见", "苏"));
        listOperations.leftPush("list:player", new Person("人生", "苏"));
        listOperations.leftPush("list:player", new Person("恋爱", "苏"));
        System.out.println(listOperations.leftPop("list:player"));
    }

}

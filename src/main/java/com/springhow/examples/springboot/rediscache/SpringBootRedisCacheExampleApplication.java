package com.springhow.examples.springboot.rediscache;

import com.springhow.examples.springboot.rediscache.entities.Item;
import com.springhow.examples.springboot.rediscache.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.math.BigDecimal;

@EnableCaching
@SpringBootApplication
public class SpringBootRedisCacheExampleApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootRedisCacheExampleApplication.class);

    @Autowired
    private ItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisCacheExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading test data.");
        itemService.createItem(new Item("Shirt Small", BigDecimal.valueOf(28.99)));
        itemService.createItem(new Item("Pants Large", BigDecimal.valueOf(21.99)));
    }
}

package com.resentek.mongo.test.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClientFactory;
import com.mongodb.client.internal.MongoClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.resentek.mongo.repository")
@ComponentScan(basePackages = {"com.resentek.mongo.service"})
@PropertySource("classpath:db/mongo.properties")
public class TestConfig {
    @Value("${db.database}")
    private String dbName;
    @Value("${db.host}")
    private String host;
    @Value("${db.port}")
    private int port;
    private String user;
    @Value("${db.user}")
    public void setUser(String user){
        this.user = user;
    }
    private String password;
    @Value("${db.password}")
    public void setPassword(String password){
        this.password = password;
    }
    private String authDatabase;
    @Value("${db.auth.database}")
    public void setAuthDatabase(String db){
        this.authDatabase = db;
    }
    private String replSet;
    @Value("${db.replSet}")
    public void setReplicationSet(String name) {
        this.replSet = name;
    }

    private final Logger logger = LoggerFactory.getLogger(TestConfig.class);

    @Bean
    public MongoDbFactory mongoDb() {
        return new SimpleMongoClientDbFactory(String.format("mongodb://%s:%s@%s:%d/%s?authSource=%s", user, password, host, port, dbName, authDatabase));
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDb());
    }
}

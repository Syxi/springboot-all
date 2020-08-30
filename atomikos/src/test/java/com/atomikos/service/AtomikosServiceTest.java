package com.atomikos.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AtomikosServiceTest {
    @Autowired
    AtomikosService atomikosService;

    @Test
    void addArticle() {
        atomikosService.addArticle();
    }

    @Test
    void addMessage() {
        atomikosService.addMessage();
    }
}
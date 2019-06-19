package com.example;

import com.example.observer.spring.MyEvent;
import com.example.observer.spring.MyPublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignPatternsApplicationTests {

    @Autowired
    private MyPublisher myPublisher;
    @Autowired
    private MyEvent myEvent;

    @Test
    public void contextLoads() {
        myPublisher.publisherEvent(myEvent);
    }
}

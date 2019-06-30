package com.leevan.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author Leevan
 * @Date： 2019/5/2 20:11
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Logtest {
    @Test
    public void test1(){
        log.debug("debug");

    }
}

package com.demo.springboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Date;

public class LoggerUtil {
    private Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    public void demo() {
        logger.trace("第一级别：trace");
        logger.debug("第二级别：debug");
        logger.info("第三级别：info");
        logger.warn("第四级别：warn");
        logger.error("第五级别：error");

        System.out.println(new Timestamp(new Date().getTime()));
    }
}

package com.demo.java.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by weimaosheng on 2017/2/28.
 */
public class LogDemo {
    private static Logger logger = LogManager.getLogger(LogDemo.class.getName());

    public static void test(){
        logger.info("信息日志");
        logger.debug("调试日志");
        logger.warn("警告日志");
        logger.error("错误日志");
        logger.exit();
    }

    public static void main(String[] args){
        test();
    }
}

package com.demo.java.annotation.target;

/**
 * Created by maosheng on 2017/5/18.
 */
public class TargetTest {
    @B
    private String name;

    /**
     * 注解B下载setName方法上，会直接报错。
     * @param name
     */
    //@B
    public void setName(String name){
        this.name = name;
    }


}

package com.demo.java.thrift;

import org.apache.thrift.TException;

/**
 * Created by Administrator on 2016/12/6.
 */
public class HelloWorldServiceImpl implements HelloWorldIface.Iface{

    @Override
    public String sayHello(String username) throws TException {

        return "******" + username + "******";
    }
}

package com.demo.java.thrift;

import org.apache.thrift.TException;

/**
 * thrift不能处理null，否则会报错
 * Created by Administrator on 2016/12/5.
 */
public class ThriftIface implements Hello.Iface{
    @Override
    public String helloString(String para) throws TException {
        System.out.println("************" + para);
        return para;
    }

    @Override
    public int helloInt(int para) throws TException {
        return 0;
    }

    @Override
    public boolean helloBoolean(boolean para) throws TException {
        return false;
    }

    @Override
    public void helloVoid() throws TException {

    }

    @Override
    public String helloNull() throws TException {
        return null;
    }
}

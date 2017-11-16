package com.demo.java.spring.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RestTemplate的测试。
 * Created by maosheng on 2017/11/16.
 */
@Controller
public class RestTemplateTest {
    private static String url = "http://localhost:8085/wecorpcheckinguser/select";

    private static RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("list")
    public static void testList(){

        /**
         * 使用这种方式获取的List，List中的值为LinkedHashMap，所以，要遍历listBad时，会发生错误：
         *      java.util.LinkedHashMap cannot be cast to com.thunis.wecorp.model.HrWecorpCheckingUser
         * 但如果只把listBad返回，不做任何处理的时候，这种用法是没问题的。
         */
        Map<String,String> param = new HashMap<>();
        List<HrWecorpCheckingUser> listBad = restTemplate.getForObject(url, ArrayList.class, param);

        //for (HrWecorpCheckingUser hrWecorpCheckingUser : listBad) {
        //    System.out.println(hrWecorpCheckingUser);
        //}

        /**
         * 使用这种方式，才能达到我们处理List的效果。
         */
        ParameterizedTypeReference<List<HrWecorpCheckingUser>> responseType = new ParameterizedTypeReference<List<HrWecorpCheckingUser>>(){};//匿名内部类
        ResponseEntity<List<HrWecorpCheckingUser>> exchange = restTemplate.exchange(url, HttpMethod.GET, null, responseType, param);
        List<HrWecorpCheckingUser> listGood = exchange.getBody();
        for (HrWecorpCheckingUser hrWecorpCheckingUser : listGood) {
            System.out.println(hrWecorpCheckingUser);
        }
    }

    public void testPost(){

    }

    public static void main (String[] org0){
        testList();
    }

}

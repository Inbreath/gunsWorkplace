package com.stylefeng.guns.rest.modular.house;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/housemgr")
public class HouseController {

    @RequestMapping("test")
    public void test(String str)
    {
        System.out.println(str);

    }
}

package com.stylefeng.guns.rest.modular.house;


import com.stylefeng.guns.rest.modular.house.service.ITblHouseService;
import com.stylefeng.guns.rest.persistence.model.TblHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/housemgr")
public class HouseController {


    @Autowired
    private ITblHouseService iTblHouseService;

    @RequestMapping("test02")
    public TblHouse test02 (@RequestBody TblHouse house) {

        System.out.println("house="+house);

        boolean flag = iTblHouseService.insert(house);

        return house;
    }

    @RequestMapping("test")
    public void test(String str)
    {
        System.out.println(str);

    }
}

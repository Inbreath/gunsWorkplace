package com.stylefeng.guns.jwt;

import com.alibaba.fastjson.JSON;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.SimpleObject;
import com.stylefeng.guns.rest.modular.auth.converter.BaseTransferEntity;
import com.stylefeng.guns.rest.modular.auth.security.impl.Base64SecurityAction;
import com.stylefeng.guns.rest.persistence.model.TblHouse;

/**
 * jwt测试
 *
 * @author fengshuonan
 * @date 2017-08-21 16:34
 */
public class DecryptTest {

    public static void main(String[] args) {

        // 获取服务器端钥匙以后的结果
        String salt = "qqs4u2";
        String compactJws = "eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJxcXM0dTIiLCJzdWIiOiJhZG1pbiIsImV4cCI6MTUzMDA2NTUwNiwiaWF0IjoxNTI5NDYwNzA2fQ.zTDAYmAZxXBgh7W-m2HM1uGlYFm9oRnIlZX1EMJzI82PZrHipPrjQNer07nJh8-v8RkQXFVNE6WP8MT1pvfQIA";

        // 客户端进行业务操作
        // 新增一个house对象
        TblHouse house = new TblHouse();
        house.setHouseAddress("jwtAddress");
        house.setHouseDesc("jwtDesc");
        house.setHouseUser("张三");

        String jsonString = JSON.toJSONString(house);

        // 签名的过程
        String encode = new Base64SecurityAction().doAction(jsonString);  // base64的编码
        String md5 = MD5Util.encrypt(encode + salt);  // MD5加密

        // 返回给guns处理的数据实体
        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        baseTransferEntity.setObject(encode);
        baseTransferEntity.setSign(md5);

        System.out.println(JSON.toJSONString(baseTransferEntity));
    }
}

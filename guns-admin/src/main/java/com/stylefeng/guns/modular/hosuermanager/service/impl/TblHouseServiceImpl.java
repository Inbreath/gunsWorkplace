package com.stylefeng.guns.modular.hosuermanager.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.modular.system.model.TblHouse;
import com.stylefeng.guns.modular.system.dao.TblHouseMapper;
import com.stylefeng.guns.modular.hosuermanager.service.ITblHouseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Allen123
 * @since 2018-05-14
 */
@Service
@Transactional
public class TblHouseServiceImpl extends ServiceImpl<TblHouseMapper, TblHouse> implements ITblHouseService {

    @Override
    public boolean insert(TblHouse entity) {

        boolean flag = super.insert(entity);

        int id = entity.getId();
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("id", id);
        entity.setHouseUser(entity.getHouseUser()+"Test");
        flag = super.update(entity,entityWrapper);

        return flag;
    }
}

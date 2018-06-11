package com.ums.mbr.service.core.service.impl;

import com.ums.mbr.service.core.mapper.TermMapper;
import com.ums.mbr.service.core.service.TermService;
import com.ums.mbr.service.domain.Term;
import com.ums.mbr.service.domain.TermKey;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TermServiceImpl implements TermService {
    @Resource
    private TermMapper termMapper;

    @Override
    public Term findByPrimaryKey(String mchtNo, String termNo) {

        TermKey termKey = new TermKey();
        termKey.setMchtno(mchtNo);
        termKey.setTermno(termNo);

        return termMapper.selectByPrimaryKey(termKey);
    }

    @Override
    public int updateByPrimaryKey(Term term) {
        return termMapper.updateByPrimaryKeySelective(term);
    }
}

package com.ums.mbr.service.core.service;

import com.ums.mbr.service.domain.RootKey;

/**
 * Author: jcouyang@chinaums.com
 * Date: 2018/3/8 14:22
 */
public interface RootkeyService {
    /**
     * 根据ID查找密钥
     * @param idx
     * @return
     */
    RootKey getRootKey(int idx);
}

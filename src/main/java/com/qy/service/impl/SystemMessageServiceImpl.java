package com.qy.service.impl;

import com.qy.dao.SystemMessageMapper;
import com.qy.model.SystemMessage;
import com.qy.service.SystemMessageService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zaq on 2018/04/14.
 */
@Service
@Transactional
public class SystemMessageServiceImpl extends AbstractService<SystemMessage> implements SystemMessageService {
    @Resource
    private SystemMessageMapper systemMessageMapper;

}

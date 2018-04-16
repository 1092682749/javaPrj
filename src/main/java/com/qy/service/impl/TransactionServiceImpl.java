package com.qy.service.impl;

import com.qy.dao.TransactionMapper;
import com.qy.model.Transaction;
import com.qy.service.TransactionService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zaq on 2018/04/14.
 */
@Service
@Transactional
public class TransactionServiceImpl extends AbstractService<Transaction> implements TransactionService {
    @Resource
    private TransactionMapper transactionMapper;

}

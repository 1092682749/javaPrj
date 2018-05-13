package com.qy.service.impl;

import com.qy.dao.IndexBannerMapper;
import com.qy.model.IndexBanner;
import com.qy.service.IndexBannerService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by dyz on 2018/04/23.
 */
@Service
@Transactional
public class IndexBannerServiceImpl extends AbstractService<IndexBanner> implements IndexBannerService {
    @Resource
    private IndexBannerMapper indexBannerMapper;

    @Override
    public int addIndexBanner(IndexBanner banner) {
        return indexBannerMapper.addIndexBanner(banner);
    }
}

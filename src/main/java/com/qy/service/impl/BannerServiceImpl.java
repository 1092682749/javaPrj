package com.qy.service.impl;

import com.qy.dao.BannerMapper;
import com.qy.model.Banner;
import com.qy.service.BannerService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by zaq on 2018/04/14.
 */
@Service
@Transactional
public class BannerServiceImpl extends AbstractService<Banner> implements BannerService {
    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> findBannersById(Integer id) {
        return bannerMapper.findBannersById(id);
    }
}

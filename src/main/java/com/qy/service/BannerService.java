package com.qy.service;
import com.qy.model.Banner;
import com.qy.base.core.Service;

import java.util.List;


/**
 * Created by zaq on 2018/04/14.
 */
public interface BannerService extends Service<Banner> {
    public List<Banner> findBannersById(Integer id);

}

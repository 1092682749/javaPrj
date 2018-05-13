package com.qy.service;
import com.qy.model.Banner;
import com.qy.model.IndexBanner;
import com.qy.base.core.Service;


/**
 * Created by dyz on 2018/04/23.
 */
public interface IndexBannerService extends Service<IndexBanner> {
    public int addIndexBanner(IndexBanner banner);
}

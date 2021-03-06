package com.qy.controller;
import com.github.pagehelper.PageInfo;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.base.utils.UploadFile;
import com.qy.model.*;
import com.qy.service.*;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;
    @Resource
    private BannerService bannerService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private EvaluateService evaluateService;
    @Resource
    private MemberService memberService;
    @Resource
    private ShoppingCartService shoppingCartService;
    @Resource
    private IndexBannerService indexBannerService;

    @PostMapping("/add")
    public ModelAndView add(Goods goods) {
        String goodsSrc = "http://localhost:8080/" + UploadFile.uploadBase64(goods.getGoods_img());
        goods.setGoods_img(goodsSrc);
        Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dataStr = format.format(data);
        goods.setG_add_time(dataStr);
        goodsService.save(goods);
        ModelAndView mav = new ModelAndView("redirect:./manage");
        return mav;
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        goodsService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Goods goods) {
        goodsService.update(goods);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Goods goods = goodsService.findById(id);
        return ResultGenerator.successResult(goods);
    }

    @GetMapping("/list")
    public Result list(PageBean<Goods> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Goods> list = goodsService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
    @RequestMapping("/details")
    public ModelAndView details(Integer id,@SessionAttribute Member member)
    {
        ModelAndView mav = new ModelAndView("shopDetails");
        //通过java代码使评价和用户绑定
        Map<Evaluate,Member> valuateMemberMap = evaluateService.evaluateMemberMap(id);
        //通过sql查询返回评价和用户绑定的map
        List<Map<Evaluate,Member>> evaluateMemberMap = evaluateService.findEvaluateByGoodsIdSql(id);
        System.out.println(member.getId());
        List<Banner> banners = bannerService.findBannersById(id);
        Goods goods = goodsService.findGoodsById(id);
        Map<ShoppingCart,Goods> shoppingCartMemberMap = shoppingCartService.findAllShoppingCartByMemberId(member.getId());
        mav.addObject("cartGoodsNum",shoppingCartMemberMap.size());
        mav.addObject("evaluateMemberMap",evaluateMemberMap);
        mav.addObject("banners",banners);
        mav.addObject("goods",goods);
        return mav;
    }
    @RequestMapping("/shopAll")
    public ModelAndView shopAll()
    {
        ModelAndView mav = new ModelAndView("shopAll");
        Map<Integer,Category> categoryMap = categoryService.categoryMap();
        Map<IndexBanner,String> indexBannerStringMap = new HashMap<>();
        List<Goods> goodsList = goodsService.findAll();
        List<IndexBanner> indexBannerList = indexBannerService.findAll();
        mav.addObject("categoryMap",categoryMap);
        mav.addObject("goodsList",goodsList);

        for (IndexBanner indexBanner : indexBannerList){
            //设置map使区分活动和商品
            String src = "#";
            if (indexBanner.getType() == 0){
                src = "#";
            }else if (indexBanner.getType() == 1){
                src = "/goods/details?id="+indexBanner.getGoods_id();
            }
            indexBannerStringMap.put(indexBanner,src);
        }
        mav.addObject("indexBannerStringMap",indexBannerStringMap);
//        for (Goods g : goodsList) {
//            System.out.println(g.getCategory_id());
//            System.out.println(categoryMap.get(g.getCategory_id()).getC_name());
//        }
        return mav;
    }
    @RequestMapping("/manage")
    public ModelAndView manage(@SessionAttribute Admin user,@RequestParam(name = "pn",defaultValue = "1")Integer pn){
        ModelAndView mav = new ModelAndView("admin/goodsManage");
        PageHelper.startPage(pn,6);
        List<Goods> goodsList = goodsService.findAll();
        PageInfo pageInfo = new PageInfo(goodsList,5);
        Map<Integer,Category> categoryMap = categoryService.categoryMap();
        List<Category> categoryList = categoryService.findAll();
        mav.addObject("pageInfo",pageInfo);
        mav.addObject("goodsList",goodsList);
        mav.addObject("categoryMap",categoryMap);
        mav.addObject("categoryList",categoryList);
        return mav;
    }

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(Integer id){
        Goods goods = goodsService.findGoodsById(id);
        ModelAndView mav = new ModelAndView("admin/editgoods");
        Map<Integer,Category> categoryMap = categoryService.categoryMap();
        mav.addObject("goods",goods);
        mav.addObject("categoryMap",categoryMap);
        return mav;
    }

    @RequestMapping("/findGoodsByLikeQuery")
    public ModelAndView findGoodsByLikeQuery(@RequestParam(name = "goodsName",defaultValue = "") String goodsName, String categoryId, String isPut, @RequestParam(name = "pn",defaultValue = "1")Integer pn, Model model){
        ModelAndView mav = new ModelAndView("admin/goodsManage");
        PageHelper.startPage(pn,5);
        List<Goods> goodsList = goodsService.findGoodsByLikeQuery(categoryId,isPut,goodsName);
        PageInfo pageInfo = new PageInfo(goodsList,5);
        Map<Integer,Category> categoryMap = categoryService.categoryMap();
        List<Category> categoryList = categoryService.findAll();
        mav.addObject("categoryMap",categoryMap);
        mav.addObject("goodsList",goodsList);
        mav.addObject("categoryList",categoryList);
        mav.addObject("pageInfo",pageInfo);
        model.addAttribute("goodsName",goodsName);
        model.addAttribute("categoryId",categoryId);
        model.addAttribute("isPut",isPut);
        return mav;
    }

    @RequestMapping("/findGoodsByLikeQueryPage")
    public ModelAndView findGoodsByLikeQueryPage(Model model, Integer pn){
        ModelAndView mav = new ModelAndView("admin/goodsManage");
        PageHelper.startPage(pn,5);
        Map modelMap = model.asMap();
        List<Goods> goodsList = goodsService.findGoodsByLikeQuery((String)modelMap.get("categoryId"),(String)modelMap.get("isPut"),(String)modelMap.get("goodsName"));
        PageInfo pageInfo = new PageInfo(goodsList,5);
        Map<Integer,Category> categoryMap = categoryService.categoryMap();
        List<Category> categoryList = categoryService.findAll();
        mav.addObject("categoryMap",categoryMap);
        mav.addObject("goodsList",goodsList);
        mav.addObject("categoryList",categoryList);
        mav.addObject("pageInfo",pageInfo);
        return mav;
    }
}

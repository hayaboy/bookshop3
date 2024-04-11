package com.green.bookshop3.goods.controller;

import com.green.bookshop3.common.base.BaseController;
import com.green.bookshop3.goods.service.GoodsService;
import com.green.bookshop3.goods.vo.GoodsVO;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller("goodsController")
@RequestMapping(value="/goods")
public class GoodsControllerImpl extends BaseController  implements GoodsController{

    @Autowired
    private GoodsService goodsService;

    //제품 상세 페이지
    @Override
    @RequestMapping(value="/goodsDetail.do" ,method = RequestMethod.GET)
    public ModelAndView goodsDetail(@RequestParam("goods_id") String goods_id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String viewName=(String)request.getAttribute("viewName");
        HttpSession session=request.getSession();
        Map goodsMap=goodsService.goodsDetail(goods_id);
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("goodsMap", goodsMap);

        GoodsVO goodsVO=(GoodsVO)goodsMap.get("goodsVO");
       addGoodsInQuick(goods_id,goodsVO,session);
        return mav;
    }

    //키워드 제품 검색
    @Override
    @RequestMapping(value="/keywordSearch.do",method = RequestMethod.GET,produces = "application/text; charset=utf8")
    @ResponseBody
    public String keywordSearch(@RequestParam("keyword") String keyword, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //System.out.println(keyword);
        if(keyword == null || keyword.equals(""))
            return null ;

        keyword = keyword.toUpperCase();
        List<String> keywordList =goodsService.keywordSearch(keyword);

        // 최종 완성될 JSONObject 선언(전체)
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("keyword", keywordList);

        String jsonInfo = jsonObject.toString();
        // System.out.println(jsonInfo);
        return jsonInfo ;
    }

    @Override
    public ModelAndView searchGoods(String searchWord, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }



    //퀵메뉴에 제품 추가(추후 다시 검토)
    private void addGoodsInQuick(String goods_id,GoodsVO goodsVO,HttpSession session){
        boolean already_existed=false;
        List<GoodsVO> quickGoodsList; //최근 본 상품 저장 ArrayList
        quickGoodsList=(ArrayList<GoodsVO>)session.getAttribute("quickGoodsList");

        if(quickGoodsList!=null){
            System.out.println("quickGoodsListNum : " + quickGoodsList.size());
            if(quickGoodsList.size() < 4){ //미리본 상품 리스트에 상품개수가 네개 이하인 경우
                for(int i=0; i<quickGoodsList.size();i++){
                    GoodsVO _goodsBean=(GoodsVO)quickGoodsList.get(i);
                    if(goods_id.equals(_goodsBean.getGoods_id())){
                        already_existed=true;
                        break;
                    }
                }
                if(already_existed==false){
                    quickGoodsList.add(goodsVO);
                }
            }

        }else{
            quickGoodsList =new ArrayList<GoodsVO>();
            quickGoodsList.add(goodsVO);

        }
        session.setAttribute("quickGoodsList",quickGoodsList);
        session.setAttribute("quickGoodsListNum", quickGoodsList.size());
    }
}

package net.xb.easybuy.webmvc;

import net.xb.easybuy.baen.News;
import net.xb.easybuy.baen.PagBean;
import net.xb.easybuy.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by asus on 2017/6/20.
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Resource
    private NewsService newsService;

    @RequestMapping("/manageNews")
    public String manageNews(Model model,@RequestParam(defaultValue = "1")Integer cur){

        PagBean p = new PagBean();
        int coun = newsService.findAllCount();
        p.setTotal_count(coun);//总共统计飞数据
        p.setUnit_count(6);//一页显示3条
        p.setTotal_page(0);
        p.setCur_page(cur);//当前页面
        int start = (p.getCur_page()-1)*p.getUnit_count();
        List<News> newss = newsService.PageProduct(start,p.getUnit_count());
        int[] arr = new int[p.getTotal_page()];
        for (int i=0;i<arr.length;i++){
            arr[i] = i+1;
        }
        model.addAttribute("cur_page",p.getCur_page());
        model.addAttribute("total_page",arr);
        model.addAttribute("newss",newss);
        return "/manage/news";
    }

    @RequestMapping("/DeleteNews")
    public String DeleteNews(@RequestParam("id") String id,Model model){
        int a = newsService.delete(id);
        if (a>0){
            return "/manage/manage-result";
        }
        model.addAttribute("DeleteMsg","删除失败");
        return "/manage/news";
    }

    @RequestMapping("/AddNews")
    public String AddNews(@RequestParam("title") String title,
                          @RequestParam("name") String content){
        Timestamp registerTime = new Timestamp(System.currentTimeMillis());
        News news = new News();
        news.setEn_title(title);
        news.setEn_content(content);
        news.setEn_create_time(registerTime);
        int a = newsService.insert(news);
        if (a>0){
            return "/manage/manage-result";
        }
        return "";
    }

    @RequestMapping("/manageNewsM")
    public String manageNewsM(@RequestParam("id") Integer id, Model model){
        News news = newsService.findById(id);
        model.addAttribute("news",news);
        return "/manage/news-modify";
    }

    @RequestMapping("/manageNewsMUp")
    public String manageNewsMUp(Model model,@RequestParam("title") String title,
                               @RequestParam("content") String content,
                                @RequestParam("id") Integer id){
        News news = new News();
        news.setEn_id(id);
        news.setEn_title(title);
        news.setEn_content(content);
        news.setEn_create_time(new Date());
        int a = newsService.update(news);
        if (a>0) {
            return "/manage/manage-result";
        }
        return "/manage/news-modify";
    }


    @RequestMapping("/NewsView")
    public String NewsView(@RequestParam("id") Integer id, Model model){
        News news = newsService.findById(id);
        List<News> newss =newsService.findAll();
        model.addAttribute("newss",newss);
        model.addAttribute("news",news);
        return "/news-view";
    }

}

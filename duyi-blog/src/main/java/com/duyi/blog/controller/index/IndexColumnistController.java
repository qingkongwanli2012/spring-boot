package com.duyi.blog.controller.index;

import com.duyi.blog.entity.Blog;
import com.duyi.blog.entity.Columnist;
import com.duyi.blog.service.BlogService;
import com.duyi.blog.service.ColumnistService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class IndexColumnistController {

    @Autowired
    ColumnistService columnistService;

    @Autowired
    BlogService blogService;

    @GetMapping("/columnistIdPage")
    public String columnistIdPage(Model model, int cid) {

        PageHelper.startPage(1, 8);
        // 专栏
        PageInfo<Columnist> pageInfo = columnistService.getColumnistByCondition(null);

        Columnist columnist = pageInfo.getList().get(0);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("columnId", cid);
        PageInfo<Blog> blogList = blogService.getBlogByCondition(map);

        // 对应第一个专栏ID的博客
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("typeId", cid);
        model.addAttribute("blogList", blogList);
        model.addAttribute("blogNav", 2);

        return "columnist";
    }
}

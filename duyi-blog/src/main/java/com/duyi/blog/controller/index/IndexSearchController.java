package com.duyi.blog.controller.index;

import com.duyi.blog.entity.Blog;
import com.duyi.blog.service.BlogService;
import com.duyi.blog.service.ColumnistService;
import com.duyi.blog.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class IndexSearchController {

    @Autowired
    ColumnistService columnistService;

    @Autowired
    TagService tagService;

    @Autowired
    BlogService blogService;

    @GetMapping("/search")
    public String search(Model model, String title) {


        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", title);
        PageInfo<Blog> pageInfo = blogService.getBlogByCondition(map);

        model.addAttribute("blogs", pageInfo.getList());

        return "search";
    }


}

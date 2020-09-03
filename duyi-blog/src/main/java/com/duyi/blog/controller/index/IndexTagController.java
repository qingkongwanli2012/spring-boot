package com.duyi.blog.controller.index;

import com.duyi.blog.entity.Blog;
import com.duyi.blog.entity.Tag;
import com.duyi.blog.service.BlogService;
import com.duyi.blog.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class IndexTagController {

    @Autowired
    TagService tagService;

    @Autowired
    BlogService blogService;

    @GetMapping("/tagIdPage")
    public String columnistIdPage(Model model, int tagId) {

        PageHelper.startPage(1, 8);

        PageInfo<Tag> pageInfo = tagService.getTagByCondition(null);

        Tag tag = pageInfo.getList().get(0);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("tags", tagId);
        PageInfo<Blog> blogList = blogService.getBlogByCondition(map);

        // 对应第一个专栏ID的博客
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("tagId", tagId);
        model.addAttribute("blogList", blogList);
        model.addAttribute("blogNav", 3);

        return "tags";
    }
}

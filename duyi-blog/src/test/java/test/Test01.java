package test;


import com.duyi.blog.App;
import com.duyi.blog.dao.*;
import com.duyi.blog.entity.Blog;
import com.duyi.blog.entity.Columnist;
import com.duyi.blog.entity.Tag;
import com.duyi.blog.entity.User;
import com.duyi.blog.service.BlogService;
import com.duyi.blog.utils.MarkdownUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class Test01 {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ColumnistMapper columnistMapper;

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    BlogService blogService;


    @Test
    public void testPage() {

        // {pageNum=1, title=Java, columnId=}


        PageHelper.startPage(2, 8);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "Java");
        map.put("columnId", "");

        PageInfo<Blog> pageInfo = blogService.getBlogByCondition(map);

//        System.out.println(pageInfo.getList().size());

        for (Blog blog : pageInfo.getList()) {
            System.out.println("getId = " + blog.getId());
        }


    }

    @Test
    public void t1() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "root");
        User user = userMapper.findUserByCondition(map);
        System.out.println(user.getName());

//        userMapper.findUserAll();
//        System.out.println("=================="+userMapper);
    }

    @Test
    public void t2() {


        Tag tag = new Tag();
        tag.setId(1);
        tag.setBlogCount(2);
        tag.setCreateTime(new Date());
        tag.setName("spring");
//
//        tagMapper.insertTag(tag);

//        System.out.println(tagMapper.findTagAll());
//
//        tagMapper.updateTag(tag);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "spring");
        System.out.println(tagMapper.findTagByCondition(map));
    }


    @Test
    public void t30() {
        blogService.delBlog(175);


    }

    @Test
    public void t3() {
        System.out.println(commentMapper.findCommentAll());
    }


    @Test
    public void testColunmist() {
        for (int i = 0; i < 100; i++) {
            Columnist c = new Columnist();
            c.setBlogCount(1);
            c.setCreateTime(new Date());
            c.setIntro("java" + i);
            c.setName("springboot" + i);
            c.setUpdateTime(new Date());
            c.setColumnistState(0);

            columnistMapper.insertColumnist(c);
        }
    }

    @Test
    public void testInsertBlog() {
//         #{id},
//            #{title},
//            #{summary},
//            #{content},
//            #{publishDate},
//            #{columnId},
//            #{views},
//            #{tags},
//            #{comments},
//            #{blogImg},
//            #{blogState},
//            #{admireState},
//            #{commentState},
//            #{recommendState},
//            #{reprintState},
//            #{createTime}
//            #{updateTime}
        for (int i = 0; i < 100; i++) {

            Blog blog = new Blog();
            blog.setId(100 + i);
            blog.setTitle("你好" + i);
            blog.setContent("内容" + i);
            blog.setSummary("中文" + i);
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setColumnId(1);
            blog.setTags("1");
            blog.setComments("c");
            blog.setBlogImg("aaa");
            blog.setAdmireState(1);
            blog.setCommentState(1);
            blog.setRecommendState(1);
            blog.setReprintState(1);
            blog.setBlogState(0);
            blog.setViews(100);

            blogMapper.insertBlog(blog);
        }
    }

    @Test
    public void t4() {
//        Blog blog = new Blog();
//        blog.setTitle("你好");
//        blog.setContent("内容");
//        blog.setSummary("中文");
//
//        blogMapper.insertBlog(blog);

        List<Blog> list = blogMapper.findBlogAll();

        for (Blog b : list) {
            String mdSource = b.getContent();
            String htmlSource = MarkdownUtil.markdownToHtmlExtens(mdSource);
            System.out.println(htmlSource);
        }

        System.out.println();
    }
}

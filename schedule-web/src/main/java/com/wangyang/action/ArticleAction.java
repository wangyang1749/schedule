package com.wangyang.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller("articleAction")
@Scope("prototype")
public class ArticleAction extends ActionSupport implements ModelDriven<Article> {
    Article article;
    int userId;
    int gradeId;
    int courseId;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    @Resource(name = "articleService")
    IArticleService articleService;
    public String addInput(){
        return SUCCESS;
    }
    public String add(){
        articleService.add(article,userId,gradeId,courseId);
        ActionContext.getContext().put("url","article_find");
        return "redirect";

    }
    public String find(){
        Pager<Article> articlePager = articleService.find("");
        ActionContext.getContext().put("article",articlePager);
        return SUCCESS;
    }
    public String findByGradeId(){
        Pager<Article> articlePager = articleService.findByGradeId(gradeId,"");
        ActionContext.getContext().put("article",articlePager);
        return SUCCESS;
    }
    public String delete(){
        articleService.delete(article.getId());
        ActionContext.getContext().put("url","article_find");
        return "redirect";
    }
    public String load(){
        Article article = articleService.load(this.article.getId());
        ActionContext.getContext().put("article",article);
        return SUCCESS;
    }
    public void findByGradeAndCourseId(){
        String article = articleService.findByGradeAndCourseId(gradeId, courseId, "");
        PrintWriter writer;
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            writer.print(article);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public Article getModel() {
        if(article==null)article = new Article();
        return article;
    }

}

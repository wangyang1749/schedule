package com.wangyang.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public String hello(){
        return SUCCESS;
    }
    IUserService userService;

    @Resource(name = "userService")
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String myInfo(){
        return SUCCESS;
    }

    public String load(){
        ActionContext.getContext().put("user",userService.load(1));
        return SUCCESS;

    }
    public String login(){
        String token = null;
        try {
            token = userService.login(user.getId());
        } catch (ScheduleException e) {
            System.out.println(e.getMessage());
            return "loginInput";
        }
        Cookie cookie = new Cookie("token",""+token);
        ServletActionContext.getResponse().addCookie(cookie);

        System.out.println(token);
        ActionContext.getContext().put("url","admin_list");
        return "redirect";

    }
    public String loginInput(){
        return SUCCESS;
    }

    public String find(){
        Pager<User> userPager = userService.find("");
        ActionContext.getContext().put("user",userPager);
        return SUCCESS;
    }

    public String addInput(){
        return SUCCESS;
    }
    public String add(){
        userService.add(user);
        ActionContext.getContext().put("url","user_find");
        return "redirect";
    }
    public String updateInput(){
        User _user = userService.load(user.getId());
        if(user==null){
            throw new ScheduleException("更新的用户不存在");
        }
        user=_user;
        return SUCCESS;
    }
    public String update(){
        userService.update(user);
        ActionContext.getContext().put("url","user_find");
        return "redirect";
    }
    public String delete(){
        userService.delete(user.getId());
        ActionContext.getContext().put("url","user_find");
        return "redirect";
    }

    @Override
    public User getModel() {
        if(user==null)user = new User();
        return user;

    }
}

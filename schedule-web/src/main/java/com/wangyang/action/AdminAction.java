package com.wangyang.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

@Controller("adminAction")
public class AdminAction extends ActionSupport {
    @Validation
    public String list(){

        return SUCCESS;
    }
}

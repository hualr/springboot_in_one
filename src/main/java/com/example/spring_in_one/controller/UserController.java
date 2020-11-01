package com.example.spring_in_one.controller;

import com.example.spring_in_one.base.controller.BaseController;
import com.example.spring_in_one.base.utils.StateParameter;
import com.example.spring_in_one.entity.User;
import com.example.spring_in_one.service.UserService;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap add(User user){
        try {
            if(StringUtils.isEmpty(user.getId())){
                user.setId(getUuid());
            }else{
                user.setUpdateDate(new Date());
            }
            userService.save(user);
            logger.info("保存成功");
            return getModelMap(StateParameter.SUCCESS, user, "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "保存失败");
        }
    }

    @RequestMapping(value="/delete", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap delete(String id){
        try {
            User user = userService.findById(id);
            if(user==null){
                return getModelMap(StateParameter.FAULT, user, "找不到该用户");
            }
            userService.delete(user);
            logger.info("删除成功");
            return getModelMap(StateParameter.SUCCESS, null, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "删除失败");
        }
    }

    @RequestMapping(value="/list")
    public String view(HttpServletRequest request){
        List<User> list = userService.findAll();
        request.setAttribute("list", list);
        logger.info("返回列表页面");
        return "/demoPage/listPage";
    }

}

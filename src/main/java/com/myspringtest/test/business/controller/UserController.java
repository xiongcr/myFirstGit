package com.myspringtest.test.business.controller;
import com.myspringtest.test.business.model.UserTest;
import com.myspringtest.test.business.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * @author xcr
 */
@Api(value="自定义玩玩")
@RestController
@RequestMapping(value = "/users")
public class UserController {


    @ApiOperation(value = "nihao",notes = "dgsagdysua")
    @RequestMapping(value = "/nihao",method = RequestMethod.POST,consumes = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public String test() {
        return "";
    }

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int addUser(UserTest user){
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }

}

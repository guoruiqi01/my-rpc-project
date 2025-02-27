package com.grq.examplespringbootconsumer;

import com.grq.example.common.model.User;
import com.grq.example.common.service.UserService;
import com.grq.myrpc.rpcspringbootstarter.annotation.RpcReference;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl {

    @RpcReference
    private UserService userService;

    public void test() {
        User user = new User();
        user.setName("grq");
        User resultUser = userService.getUser(user);
        System.out.println(resultUser.getName());
    }

}

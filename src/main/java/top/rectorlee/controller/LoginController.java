package top.rectorlee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.rectorlee.request.PersonRequest;
import top.rectorlee.response.AccountResponse;
import top.rectorlee.service.IMaskDataService;

/**
 * @author Lee
 * @description
 * @date 2022-12-06 14:36:26
 */
@RestController
public class LoginController {
    @Autowired
    private IMaskDataService service;

    @RequestMapping("/login")
    public AccountResponse login(@RequestBody PersonRequest personRequest) {
        return service.getAccountInfo(personRequest);
    }

    @RequestMapping("/register")
    public String register(@RequestBody PersonRequest personRequest) {
        return service.addAccount(personRequest);
    }
}

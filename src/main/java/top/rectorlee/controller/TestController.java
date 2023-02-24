package top.rectorlee.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import top.rectorlee.request.PersonRequest;
import top.rectorlee.response.AccountResponse;
import top.rectorlee.service.IMaskDataService;

import javax.annotation.Resource;

/**
 * @author Lee
 * @description
 * @date 2022-12-06 14:36:45
 */
@RestController
public class TestController {

    @Resource
    private IMaskDataService maskDataService;

    @RequestMapping(value = "/mask", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AccountResponse maskHandler(@RequestBody PersonRequest req) {
        return maskDataService.getAccountInfo(req);
    }
}

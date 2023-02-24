package top.rectorlee.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.houbb.sensitive.core.api.SensitiveUtil;
import com.github.houbb.sensitive.core.util.strategy.SensitiveStrategyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.rectorlee.mapper.IMaskDataMapper;
import top.rectorlee.request.PersonRequest;
import top.rectorlee.response.AccountResponse;
import top.rectorlee.service.IMaskDataService;

/**
 * @author Lee
 * @description
 * @date 2022-12-06 14:39:50
 */
@Service
@Slf4j
public class MaskDataServiceImpl implements IMaskDataService {
    @Autowired
    private IMaskDataMapper iMaskDataMapper;

    @Override
    public AccountResponse getAccountInfo(PersonRequest req) {
        Integer id = req.getId();
        AccountResponse response = iMaskDataMapper.getAccountById(id);
        // 打印日志脱敏处理
        AccountResponse sensitiveResp = SensitiveUtil.desCopy(response);
        log.info("query account info:{}", JSON.toJSONString(sensitiveResp));
        return response;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String addAccount(PersonRequest personRequest) {
        PersonRequest request = new PersonRequest();
        request.setEmail(SensitiveStrategyUtil.email(personRequest.getEmail()));
        request.setPhone(SensitiveStrategyUtil.phone(personRequest.getPhone()));
        request.setPassword(personRequest.getPassword());
        request.setName(personRequest.getName());
        request.setAge(personRequest.getAge());

        iMaskDataMapper.addAccount(request);

        return "新增成功";
    }
}

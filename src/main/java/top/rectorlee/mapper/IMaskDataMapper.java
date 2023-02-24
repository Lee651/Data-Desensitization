package top.rectorlee.mapper;

import top.rectorlee.request.PersonRequest;
import top.rectorlee.response.AccountResponse;

/**
 * @author Lee
 * @description
 * @date 2022-12-06 14:37:01
 */
public interface IMaskDataMapper {
    AccountResponse getAccountById(Integer id);

    int addAccount(PersonRequest personRequest);
}

package top.rectorlee.service;

import top.rectorlee.request.PersonRequest;
import top.rectorlee.response.AccountResponse;

/**
 * @author Lee
 * @description
 * @date 2022-12-06 14:40:00
 */
public interface IMaskDataService {
    AccountResponse getAccountInfo(PersonRequest req);

    String addAccount(PersonRequest personRequest);
}

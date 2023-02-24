package top.rectorlee.response;

import com.github.houbb.sensitive.annotation.Sensitive;
import com.github.houbb.sensitive.core.api.strategory.StrategyEmail;
import com.github.houbb.sensitive.core.api.strategory.StrategyPassword;
import com.github.houbb.sensitive.core.api.strategory.StrategyPhone;
import lombok.Data;
import top.rectorlee.mask.annotations.DataMasking;
import top.rectorlee.mask.enums.DataMaskingFunc;

import java.io.Serializable;

/**
 * @author Lee
 * @description
 * @date 2022-12-06 14:39:35
 */
@Data
public class AccountResponse implements Serializable {
    private String name;

    private Integer age;

    @DataMasking(maskFunc = DataMaskingFunc.HALF_MASK)
    @Sensitive(strategy = StrategyEmail.class)
    private String email;

    @DataMasking(maskFunc = DataMaskingFunc.HALF_MASK)
    @Sensitive(strategy = StrategyPassword.class)
    private String password;

    @Sensitive(strategy = StrategyPhone.class)
    @DataMasking(maskFunc = DataMaskingFunc.HALF_MASK)
    private String phone;
}

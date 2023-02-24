package top.rectorlee.request;

import com.github.houbb.sensitive.annotation.Sensitive;
import com.github.houbb.sensitive.core.api.strategory.StrategyEmail;
import com.github.houbb.sensitive.core.api.strategory.StrategyPassword;
import com.github.houbb.sensitive.core.api.strategory.StrategyPhone;
import lombok.Data;
import top.rectorlee.mask.annotations.DataMasking;
import top.rectorlee.mask.enums.DataMaskingFunc;

/**
 * @author Lee
 * @description
 * @date 2022-12-06 14:39:21
 */
@Data
public class PersonRequest {
    private Integer id;

    private String name ;

    @DataMasking(maskFunc = DataMaskingFunc.HALF_MASK)
    @Sensitive(strategy = StrategyEmail.class)
    private String email;

    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    @Sensitive(strategy = StrategyPassword.class)
    private String password;

    @Sensitive(strategy = StrategyPhone.class)
    @DataMasking(maskFunc = DataMaskingFunc.HALF_MASK)
    private String phone;

    private Integer age;
}

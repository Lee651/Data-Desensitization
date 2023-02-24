package top.rectorlee.mask.enums;

import com.github.houbb.sensitive.core.util.strategy.SensitiveStrategyUtil;
import org.springframework.util.StringUtils;
import top.rectorlee.mask.DataMaskingOperation;

/**
 * @author Lee
 * @description
 * @date 2022-12-06 14:38:15
 */
public enum DataMaskingFunc {
    NO_MASK((str, maskChar) -> {
        return str;
    }),

    ALL_MASK((str, maskChar) -> {
        if (StringUtils.hasLength(str)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                sb.append(StringUtils.hasLength(maskChar) ? maskChar : DataMaskingOperation.MASK_CHAR);
            }
            return sb.toString();
        } else {
            return str;
        }
    }),

    HALF_MASK((str, maskChar) -> {
        if (str.indexOf("@") > 0) {
            return SensitiveStrategyUtil.email(str);
        } else {
            return SensitiveStrategyUtil.phone(str);
        }
    });

    private final DataMaskingOperation operation;

    private DataMaskingFunc(DataMaskingOperation operation) {
        this.operation = operation;
    }

    public DataMaskingOperation operation() {
        return this.operation;
    }

}

package top.rectorlee.mask.annotations;

import top.rectorlee.mask.enums.DataMaskingFunc;

import java.lang.annotation.*;

/**
 * @author Lee
 * @description
 * @date 2022-12-06 14:37:55
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DataMasking {
    DataMaskingFunc maskFunc() default DataMaskingFunc.NO_MASK;
}

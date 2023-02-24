package top.rectorlee.mask;

/**
 * @author Lee
 * @description
 * @date 2022-12-06 14:38:53
 */
public interface DataMaskingOperation {
    String MASK_CHAR = "*";

    String mask(String content,String maskChar);
}

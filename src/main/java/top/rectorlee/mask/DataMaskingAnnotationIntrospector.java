package top.rectorlee.mask;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import lombok.extern.slf4j.Slf4j;
import top.rectorlee.mask.annotations.DataMasking;

/**
 * @author Lee
 * @description
 * @date 2022-12-06 14:38:44
 */
@Slf4j
public class DataMaskingAnnotationIntrospector extends NopAnnotationIntrospector {
    @Override
    public Object findSerializer(Annotated am) {
        DataMasking annotation = am.getAnnotation(DataMasking.class);
        if (annotation != null) {
            return new DataMaskingSerializer(annotation.maskFunc().operation());
        }
        return null;
    }
}

package top.rectorlee.mask;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import top.rectorlee.mask.enums.DataMaskingFunc;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author Lee
 * @description
 * @date 2022-12-06 14:39:04
 */
public final class DataMaskingSerializer extends StdScalarSerializer {
    private final  DataMaskingOperation operation;

    public DataMaskingSerializer() {
        super(String.class,false);
        this.operation = null;
    }

    public DataMaskingSerializer(DataMaskingOperation operation) {
        super(String.class, false);
        this.operation = operation;
    }

    @Override
    public void serializeWithType(Object value, JsonGenerator g, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        this.serialize(value, g, provider);
    }

    @Override
    public JsonNode getSchema(SerializerProvider provider, Type typeHint) throws JsonMappingException {
        return this.createSchemaNode("string", true);
    }

    @Override
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException {
        this.visitStringFormat(visitor, typeHint);
    }

    @Override
    public boolean isEmpty(SerializerProvider provider, Object value) {
        String str = (String) value;
        return str.isEmpty();
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
        String content;
        if (Objects.isNull(operation)) {
            content = DataMaskingFunc.ALL_MASK.operation().mask((String) value, null);
        }else{
            content = operation.mask((String) value, null);
        }
        gen.writeString(content);
    }
}

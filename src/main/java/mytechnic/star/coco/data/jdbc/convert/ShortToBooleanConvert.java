package mytechnic.star.coco.data.jdbc.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class ShortToBooleanConvert implements Converter<Short, Boolean> {

    @Override
    public Boolean convert(Short val) {
        return val > 0;
    }
}

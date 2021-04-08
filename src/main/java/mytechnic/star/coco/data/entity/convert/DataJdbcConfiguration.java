package mytechnic.star.coco.data.entity.convert;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.Collections;

@Configuration
public class DataJdbcConfiguration extends AbstractJdbcConfiguration {

    @Override
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(Collections.singletonList(new ShortToBooleanConvert()));
    }

    @ReadingConverter
    public static class ShortToBooleanConvert implements Converter<Short, Boolean> {

        @Override
        public Boolean convert(Short val) {
            return val > 0;
        }
    }
}

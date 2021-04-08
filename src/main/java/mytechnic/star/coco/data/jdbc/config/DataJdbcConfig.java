package mytechnic.star.coco.data.jdbc.config;

import mytechnic.star.coco.data.jdbc.convert.ShortToBooleanConvert;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.Collections;

@Configuration
public class DataJdbcConfig extends AbstractJdbcConfiguration {

    @Override
    public JdbcCustomConversions jdbcCustomConversions() {
        return new JdbcCustomConversions(Collections.singletonList(new ShortToBooleanConvert()));
    }
}

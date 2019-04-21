package gitter.app;
/*Original code created by stackoverflow user: https://stackoverflow.com/users/3438207/jenky
* as an answer to this question: https://stackoverflow.com/questions/34923268/jackson-prettyprint-for-spring-4*/

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class CustomMvcConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        for(HttpMessageConverter<?> converter : converters){
            if(converter instanceof MappingJackson2HttpMessageConverter){
                MappingJackson2HttpMessageConverter jacksonConverter = (MappingJackson2HttpMessageConverter) converter;
                jacksonConverter.setPrettyPrint(true);
            }
        }
    }
}
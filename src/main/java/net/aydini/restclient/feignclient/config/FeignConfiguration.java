package net.aydini.restclient.feignclient.config;

import net.aydini.restclient.feignclient.proxy.CustomerProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 *         Mar 16, 2021
 */

@Import(FeignClientConfiguration.class)
@EnableFeignClients(basePackageClasses = CustomerProxy.class)
@Configuration
public class FeignConfiguration
{

    @Bean
    public Encoder encoder()
    {
        return new JacksonEncoder();
    }

    @Bean
    public Decoder decoder()
    {
        return new JacksonDecoder();
    }

    @Bean
    public Logger.Level feignLegerLevel()
    {
        return Logger.Level.FULL;
    }
    
    @Bean
    public ErrorDecoder errorDecoder()
    {
        return new CustomErrorDecoder();
    }
    
    @Bean
    public RequestInterceptor requestInterceptor()
    {
        return new FeignRequestInterceptor();
    }

}

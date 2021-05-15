package net.aydini.restclient.feignclient.config;

import java.util.Optional;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import net.aydini.restclient.feignclient.exception.FeignClientException;
import net.aydini.restclient.feignclient.model.ResponseMessage;
import net.aydini.restclient.feignclient.util.ResponseUtils;


@Slf4j
public class CustomErrorDecoder implements ErrorDecoder
{
    
    @Override
    public Exception decode(String methodKey, Response response)
    {
        if (response == null) return new FeignClientException(new ResponseMessage("unexpected error",-100), "error in " + methodKey);

        log.error("response {}", response.toString());
        Optional<String> optionalError = ResponseUtils.extractError(response);
        optionalError.ifPresent(error->log.error("message : {}",error));
        return new FeignClientException(new ResponseMessage(response.reason(), response.status()), optionalError.orElse("unexpected error"));
    }

}

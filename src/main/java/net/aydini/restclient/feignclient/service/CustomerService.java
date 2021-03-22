package net.aydini.restclient.feignclient.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.aydini.restclient.feignclient.model.Customer;
import net.aydini.restclient.feignclient.proxy.CustomerProxy;
import net.aydini.restclient.feignclient.util.ExceptionUtils;
import net.aydini.restclient.feignclient.util.RequestHeader;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 23, 2021
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerService
{
    private final CustomerProxy customerProxy;
    
    public Customer findById(Long customerId)
    {
        try
        {
            return customerProxy.findById(customerId, new RequestHeader().setApplicationJsonContentType().getHeaders());
        }
        catch (Exception exception)
        {
            log.error("error in getUserAssignedTasks  : {}", exception.getMessage());
            throw ExceptionUtils.handleException(exception);
        }
    }

}

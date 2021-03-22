package net.aydini.restclient.feignclient.proxy;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import net.aydini.restclient.feignclient.model.Customer;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 23, 2021
 */


@FeignClient(name = "CUSTOMER-PROXY" , url = "${customer.api.v1.url}")
public interface CustomerProxy
{
    @GetMapping(value = "/")
    public Customer findById(@RequestParam Long customerId , @RequestHeader Map<String, String> headers);
}

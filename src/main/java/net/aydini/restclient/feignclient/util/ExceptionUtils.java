package net.aydini.restclient.feignclient.util;

import java.lang.reflect.UndeclaredThrowableException;

import net.aydini.restclient.feignclient.exception.FeignClientException;


/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 23, 2021
 */
public class ExceptionUtils
{
    public static FeignClientException handleException(Exception exception)  
    {
        if (exception instanceof UndeclaredThrowableException) 
            return (FeignClientException)((UndeclaredThrowableException) exception).getUndeclaredThrowable();
        else return new FeignClientException(exception, exception.getMessage());
    }
}

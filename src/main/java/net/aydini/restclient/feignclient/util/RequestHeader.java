package net.aydini.restclient.feignclient.util;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author <a href="mailto:hi@aydini.net">Aydin Nasrollahpour </a>
 *
 * Mar 23, 2021
 */
public class RequestHeader
{

    
    private final static String CONTENT_TYPE = "Content-Type";

    private final static String AUTHORIZATION = "authorization";

    private Map<String, String> headers;

    public RequestHeader()
    {
        headers = new HashMap<>();
    }

    public RequestHeader setApplicationJsonContentType()
    {
        if (headers.get(CONTENT_TYPE) == null) headers.put(CONTENT_TYPE, "application/json");
        return this;
    }

    public RequestHeader setApplicationXmlContentType()
    {
        if (headers.get(CONTENT_TYPE) == null) headers.put(CONTENT_TYPE, "application/json");
        return this;
    }

    public RequestHeader setAuthorizationToken(String token)
    {
        headers.put(AUTHORIZATION, token);
        return this;
    }
    
    public RequestHeader setCustomHeader(String key , String value)
    {
        headers.put(key, value);
        return this;
    }
    
    public RequestHeader setBasicAuthenticationHeader(String username , String password)
    {
        String auth = username + ":" +password;
        headers.put(AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString(auth.getBytes()));
        return this;
    }
    public Map<String, String> getHeaders()
    {
        return new HashMap<>(headers);
    }
}

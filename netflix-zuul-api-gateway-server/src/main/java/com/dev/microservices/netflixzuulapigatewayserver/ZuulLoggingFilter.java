package com.dev.microservices.netflixzuulapigatewayserver;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {



    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }


    @Override
    public Object run() throws ZuulException {

        HttpServletRequest request =  RequestContext.getCurrentContext().getRequest();
        log.info("request -> {} request uri -> {}",request,request.getRequestURI());
        return null;
    }
}

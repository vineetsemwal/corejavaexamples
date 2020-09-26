package com.dxctraining.hotelmgt.zuulservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountFilter extends ZuulFilter {
    @Autowired
    private Counter counter;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        counter.increment();
        System.out.println("request received , count="+counter.getAppRequestsCount());
        return null;
    }
}

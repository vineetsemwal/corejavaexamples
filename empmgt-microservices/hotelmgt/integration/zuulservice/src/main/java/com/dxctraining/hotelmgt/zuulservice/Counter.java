package com.dxctraining.hotelmgt.zuulservice;

import org.springframework.stereotype.Component;

@Component
public class Counter {
    private int appRequestsCount;

    public int increment() {
        return ++appRequestsCount;
    }

    public int getAppRequestsCount() {
        return appRequestsCount;
    }


}

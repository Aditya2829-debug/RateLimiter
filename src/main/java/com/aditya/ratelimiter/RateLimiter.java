package com.aditya.ratelimiter;

import java.util.HashMap;
public class RateLimiter {
    private HashMap<String, ClientData> clients;
    private int requestLimit;
    private long windowSize;
    public RateLimiter(int requestLimit,long windowSize){
        this.requestLimit = requestLimit;
        this.windowSize = windowSize;
        clients=new HashMap<>();
    }

    public boolean isRequestAllowed(String clientId){
        long currentTime = System.currentTimeMillis();
        ClientData data=clients.get(clientId);
        if(data==null){
            data=new ClientData(1,currentTime) ;
            clients.put(clientId,data);
            return true;
        }
        long elapsedTime=currentTime-data.getWindowStartTime();
        if(elapsedTime>=windowSize){
            data.setRequestCount(1);
            data.setWindowStartTime(currentTime);
            return true;
        }
        if(data.getRequestCount()>=requestLimit){
            return false;
        }
        int count=data.getRequestCount();
        data.setRequestCount(count+1);
        return true;
    }
}

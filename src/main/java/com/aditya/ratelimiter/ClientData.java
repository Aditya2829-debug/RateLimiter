package com.aditya.ratelimiter;

public class ClientData {
    private int requestCount;
    private long windowStartTime;

    public ClientData(int requestCount, long windowStartTime) {
        this.requestCount = requestCount;
        this.windowStartTime = windowStartTime;
    }

    public int getRequestCount() {
        return requestCount;
    }
    public long getWindowStartTime() {
        return windowStartTime;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }

    public void setWindowStartTime(long windowStartTime) {
        this.windowStartTime = windowStartTime;
    }
}

package com.aditya.ratelimiter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(3, 10000);

        System.out.println("Request 1: " + rateLimiter.isRequestAllowed("Aditya"));
        System.out.println("Request 2: " + rateLimiter.isRequestAllowed("Rahul"));
        System.out.println("Request 3: " + rateLimiter.isRequestAllowed("Rahul"));
        System.out.println("Request 4: " + rateLimiter.isRequestAllowed("Rahul"));
        System.out.println("Request 5: " + rateLimiter.isRequestAllowed("Rahul"));
        System.out.println("Request 6: " + rateLimiter.isRequestAllowed("Aditya"));
        System.out.println("Request 7: " + rateLimiter.isRequestAllowed("Aditya"));
        System.out.println("Request 8: " + rateLimiter.isRequestAllowed("Aditya"));

        Thread.sleep(10000);

        System.out.println("Request 9: " + rateLimiter.isRequestAllowed("Aditya"));
    }
}

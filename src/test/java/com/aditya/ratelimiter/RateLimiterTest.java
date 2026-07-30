package com.aditya.ratelimiter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RateLimiterTest {
    @Test
    public void shouldAllowFirstRequest() {
        RateLimiter  rateLimiter=new RateLimiter(3,10000);
        boolean result = rateLimiter.isRequestAllowed("Aditya");
        assertTrue(result);
    }
    @Test
    void shouldAllowThreeRequests() {

        // Arrange
        RateLimiter limiter = new RateLimiter(3, 10000);

        // Act
        boolean r1 = limiter.isRequestAllowed("Aditya");
        boolean r2 = limiter.isRequestAllowed("Aditya");
        boolean r3 = limiter.isRequestAllowed("Aditya");

        // Assert
        assertTrue(r1);
        assertTrue(r2);
        assertTrue(r3);
    }
    @Test
    void shouldRejectFourthRequest() {

        // Arrange
        RateLimiter limiter = new RateLimiter(3, 10000);

        // Act
        limiter.isRequestAllowed("Aditya");
        limiter.isRequestAllowed("Aditya");
        limiter.isRequestAllowed("Aditya");

        boolean result = limiter.isRequestAllowed("Aditya");

        // Assert
        assertTrue(result);
    }
    @Test
    void shouldMaintainSeparateLimitsForDifferentClients() {

        // Arrange
        RateLimiter limiter = new RateLimiter(3, 10000);

        // Act
        limiter.isRequestAllowed("Aditya");
        limiter.isRequestAllowed("Aditya");
        limiter.isRequestAllowed("Aditya");

        boolean result = limiter.isRequestAllowed("Rahul");

        // Assert
        assertTrue(result);
    }
    @Test
    void shouldResetWindowAfterExpiry() throws InterruptedException {

        // Arrange
        RateLimiter limiter = new RateLimiter(3, 1000);

        // Act
        limiter.isRequestAllowed("Aditya");
        limiter.isRequestAllowed("Aditya");
        limiter.isRequestAllowed("Aditya");

        assertFalse(limiter.isRequestAllowed("Aditya"));

        Thread.sleep(1100);

        boolean result = limiter.isRequestAllowed("Aditya");

        // Assert
        assertTrue(result);
    }
}

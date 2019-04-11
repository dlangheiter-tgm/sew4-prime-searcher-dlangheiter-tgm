package com.davidlangheiter.prime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Date;

@Component
public class SearchRunner implements ApplicationRunner {

    private Date start;
    private int lastPrime;
    private Date lastFound;
    private boolean running;

    public SearchRunner() {
        this.start = new Date();
        this.running = true;
        this.lastPrime = 2;
        this.lastFound = new Date();
    }

    @PreDestroy
    public void destroy() {
        this.running = false;
    }

    @Override
    public void run(ApplicationArguments args) {
        int currentNum = this.lastPrime;

        while(this.running) {
            currentNum++;
            if (SearchRunner.isPrimeBruteForce(currentNum)) {
                this.lastPrime = currentNum;
                this.lastFound = new Date();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method taken from https://www.baeldung.com/java-generate-prime-numbers
     * @param number The number to check if it is a prime
     * @return True if prime else false
     */
    private static boolean isPrimeBruteForce(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public Date getStart() {
        return start;
    }

    public int getLastPrime() {
        return lastPrime;
    }

    public Date getLastFound() {
        return lastFound;
    }
}

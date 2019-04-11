package com.davidlangheiter.prime;

import javax.annotation.PostConstruct;
import java.util.Date;

public class Searcher {

    private Date start;
    private Integer prime;
    private Date lastFound;
    private Thread thread;

    Searcher() {
        this.start = new Date();
        this.prime = 2;
        this.lastFound = new Date();
        this.thread = new Thread(new PrimeSearch(this));
    }

    @PostConstruct
    public void init() {
        this.thread.start();
    }

    public void updatePrime(Integer prime) {
        this.lastFound = new Date();
        this.prime = prime;
    }

    public Date getStart() {
        return start;
    }

    public Integer getPrime() {
        return prime;
    }

    public Date getLastFound() {
        return lastFound;
    }
}

class PrimeSearch implements Runnable {

    private int currentNum;
    private Searcher searcher;

    PrimeSearch(Searcher searcher) {
        this.searcher = searcher;
        this.currentNum = searcher.getPrime();
    }

    @Override
    public void run() {
        while(true) {
            currentNum++;
            if (PrimeSearch.isPrimeBruteForce(currentNum)) {
                this.searcher.updatePrime(currentNum);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isPrimeBruteForce(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
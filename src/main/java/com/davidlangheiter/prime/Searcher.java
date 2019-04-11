package com.davidlangheiter.prime;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.Date;

public class Searcher {

    private Date start;
    private Integer prime;
    private Date lastFound;

    Searcher() {
        this.start = new Date();
        this.prime = 2;
        this.lastFound = new Date();
    }

    @PostConstruct
    public void init() {

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

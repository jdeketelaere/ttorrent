package com.turn.ttorrent.tracker;

import org.simpleframework.http.Request;
import org.simpleframework.http.RequestWrapper;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jurgen on 6/03/15.
 */
public class TrackerRequest extends RequestWrapper {

    private final static AtomicInteger COUNTER = new AtomicInteger();
    private final Integer id;
    private final String toString;

    public TrackerRequest(Request request) {
        super(request);
        this.id = COUNTER.incrementAndGet();
        this.toString = String.format("=== TrackerRequest [%s::%06d]", getClientAddress(), id);
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return toString;
    }
}

package com.synisys.test.messaging.web.data;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Armen.Mkrtchyan.
 */
public class ProjectCost {

    private final static AtomicLong ID_GENERATOR = new AtomicLong(-1);

    private final BigDecimal amount;
    private final Long id;


    public ProjectCost(BigDecimal amount) {
        this.amount = amount;
        id = ID_GENERATOR.decrementAndGet();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getId() {
        return id;
    }
}

package com.synisys.test.messaging.web.data;

import java.math.BigDecimal;

/**
 * @author Armen.Mkrtchyan.
 */
public class PortfolioProject {

    private final String title;
    private final String description;
    private final BigDecimal totalCost;

    public PortfolioProject(String title, String description, BigDecimal totalCost) {
        this.title = title;
        this.description = description;
        this.totalCost = totalCost;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }
}

package com.synisys.test.messaging.web.bean;

import com.synisys.test.messaging.web.data.PortfolioProject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Armen.Mkrtchyan.
 */
public class PortfolioBean {

    private static final List<PortfolioProject> PORTFOLIO_PROJECTS = new ArrayList<>();
    private static final int PAGE_SIZE = 10;

    static {
        for (int i = 0; i < 100; i++) {
            PORTFOLIO_PROJECTS.add(new PortfolioProject("Project Title" + i, "Project Description " + i, BigDecimal.TEN.add(BigDecimal.valueOf(i))));
        }
    }


    public static List<PortfolioProject> getProjectsForPage(Integer page) {

    }




}

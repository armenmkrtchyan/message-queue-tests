package com.synisys.test.messaging.web;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.bean.BeanInvocation;

/**
 * @author armen mkrtchyan
 * @version 1.0
 */
public class MethodNameProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        BeanInvocation invocation = exchange.getIn().getBody(BeanInvocation.class);
        String methodName = invocation.getMethod().getName();
        exchange.getIn().setHeader("method", methodName);
    }

}

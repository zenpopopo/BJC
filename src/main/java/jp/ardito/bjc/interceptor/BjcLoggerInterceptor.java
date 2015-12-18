/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.interceptor;

import javax.annotation.Priority;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import jp.ardito.bjc.annotation.BjcLogger;
import org.slf4j.Logger;

/**
 *
 * @author zempo
 */
@Interceptor
@Dependent
@BjcLogger
@Priority(Interceptor.Priority.APPLICATION+200)
public class BjcLoggerInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object invoke(InvocationContext ic) {

        logger.info("優先度50");

        try {
            return ic.proceed();
        } catch(Exception ex) {
            return null;
        }
    }
}

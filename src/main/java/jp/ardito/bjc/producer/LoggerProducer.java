/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.producer;

import com.mysql.jdbc.log.Slf4JLogger;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author zempo
 */
@Named
@Dependent
public class LoggerProducer {

    @Produces
    Logger getLogger(InjectionPoint ip) {
        return LoggerFactory.getLogger(Slf4JLogger.class);
    }

}

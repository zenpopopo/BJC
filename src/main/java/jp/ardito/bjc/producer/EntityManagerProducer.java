/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.producer;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zempo
 */
@Named
@Dependent
public class EntityManagerProducer {

    @Produces
    @PersistenceContext(unitName = "jp.ardito_BJC_war_1.0-SNAPSHOTPU")
    private EntityManager em;
}

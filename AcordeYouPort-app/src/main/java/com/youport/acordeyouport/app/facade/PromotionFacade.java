/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youport.acordeyouport.app.facade;

import com.youport.acordeyouport.app.entity.Promotion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Luis Castañeda <luis.castaneda at acorde.com.ve>
 */
@Stateless
public class PromotionFacade extends AbstractFacade<Promotion> {
    @PersistenceContext(unitName = "com.youport_AcordeYouPort-app_war_0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromotionFacade() {
        super(Promotion.class);
    }

}

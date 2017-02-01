/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youport.acordeyouport.app.facade;

import com.youport.acordeyouport.app.entity.Provincias;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ivan Silva <isilva at Acorde>
 */
@Stateless
public class ProvinciasFacade extends AbstractFacade<Provincias> {

    
    
    
    @PersistenceContext(unitName = "com.youport_AcordeYouPort-app_war_0PU")
    private EntityManager em;

    
    private static enum queries {

        GENERIC_SELECT(new StringBuilder("SELECT p FROM Provincias p where 1=1 ").toString()),
        JPA_FIND_BY_PROVINCIA(new StringBuilder(GENERIC_SELECT.getQuery())
                .append(" AND p.provincia = :provincia ")
                .toString());
        

        private final String query;

        private queries(String query) {
            this.query = query;
        }

        public String getQuery() {
            return query;
        }

    };
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvinciasFacade() {
        super(Provincias.class);
    }
    
    
    public Provincias findByName(String provinciaName){        
        HashMap<String, Object> param = new HashMap<>();
        param.put("provincia", provinciaName);
        String sql = queries.JPA_FIND_BY_PROVINCIA.getQuery();
        return this.uniqueCreateQuery(sql, param);
    }
    
}

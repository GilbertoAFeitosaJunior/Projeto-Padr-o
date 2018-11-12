/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.stos.educador.dao.impl;

import mobi.stos.educador.bean.GestorDoTerritorio;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.IGestorDoTerritorioDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DEV-JAVA
 */

@Repository
public class GestorDoTerritorioDao extends AbstractHibernateDao<GestorDoTerritorio> implements  IGestorDoTerritorioDao{
    
    public GestorDoTerritorioDao() {
        super(GestorDoTerritorio.class);
    }
   
    
}

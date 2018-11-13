/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobi.stos.educador.dao.impl;

import mobi.stos.educador.bean.CoordenadorDeProjeto;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.ICoordenadorDeProjetoDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matheus Monteiro
 */

@Repository
public class CoordenadorDeProjetoDao extends AbstractHibernateDao<CoordenadorDeProjeto> implements ICoordenadorDeProjetoDao{

    public CoordenadorDeProjetoDao() {
        super(CoordenadorDeProjeto.class);
    }

}

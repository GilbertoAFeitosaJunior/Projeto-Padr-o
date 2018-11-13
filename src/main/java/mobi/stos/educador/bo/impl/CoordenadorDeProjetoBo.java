/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobi.stos.educador.bo.impl;

import mobi.stos.educador.bean.CoordenadorDeProjeto;
import mobi.stos.educador.bo.ICoordenadorDeProjetoBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.ICoordenadorDeProjetoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matheus Monteiro
 */

@Service
public class CoordenadorDeProjetoBo extends AbstractService<CoordenadorDeProjeto> implements ICoordenadorDeProjetoBo{
    
    @Autowired
    private ICoordenadorDeProjetoDao dao;

    @Override
    protected IOperations<CoordenadorDeProjeto> getDao() {
        return dao;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobi.stos.educador.bo.impl;

import mobi.stos.educador.bean.CoordenadorPedagogico;
import mobi.stos.educador.bo.ICoordenadorPedagogicoBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.ICoordenadorPedagogicoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matheus Monteiro
 */

@Service
public class CoordenadorPedagogicoBo extends AbstractService<CoordenadorPedagogico> implements ICoordenadorPedagogicoBo{
    
    @Autowired
    private ICoordenadorPedagogicoDao dao;
    
    @Override
    protected IOperations<CoordenadorPedagogico> getDao() {
        return dao;
    }


}

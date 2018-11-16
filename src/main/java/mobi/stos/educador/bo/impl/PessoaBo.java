/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mobi.stos.educador.bo.impl;

import mobi.stos.educador.bean.Pessoa;
import mobi.stos.educador.bo.IPessoaBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.IPessoaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matheus Monteiro
 */

@Service
public class PessoaBo extends AbstractService<Pessoa> implements IPessoaBo{

    @Autowired
    private IPessoaDao dao;
    
    @Override
    protected IOperations<Pessoa> getDao() {
        return dao;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.stos.educador.bo.impl;

import mobi.stos.educador.bean.GestorDoTerritorio;
import mobi.stos.educador.bo.IGestorDoTerritorioBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.IGestorDoTerritorioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEV-JAVA
 */
@Service
public class GestorDoTerritorioBo extends AbstractService<GestorDoTerritorio> implements IGestorDoTerritorioBo{
    
    @Autowired
    private IGestorDoTerritorioDao dao;

    @Override
    protected IOperations<GestorDoTerritorio> getDao() {
        return dao;
    }
}

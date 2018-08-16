package mobi.stos.youhub.bo.impl;

import mobi.stos.youhub.bean.Questionario;
import mobi.stos.youhub.bo.IQuestionarioBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IQuestionarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionarioBo extends AbstractService<Questionario> implements IQuestionarioBo {

    @Autowired
    private IQuestionarioDao dao;

    @Override
    protected IOperations<Questionario> getDao() {
        return dao;
    }

}

package mobi.stos.youhub.dao.impl;

import mobi.stos.youhub.bean.Questionario;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IQuestionarioDao;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionarioDao extends AbstractHibernateDao<Questionario> implements IQuestionarioDao {

    public QuestionarioDao() {
        super(Questionario.class);
    }

   
}

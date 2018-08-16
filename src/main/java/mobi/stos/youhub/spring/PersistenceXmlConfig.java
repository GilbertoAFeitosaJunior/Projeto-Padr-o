package mobi.stos.youhub.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"mobi.stos.youhub.dao", "mobi.stos.youhub.bo"})
@ImportResource({"classpath:applicationContext.xml"})
public class PersistenceXmlConfig {

    public PersistenceXmlConfig() {
        super();
    }

}

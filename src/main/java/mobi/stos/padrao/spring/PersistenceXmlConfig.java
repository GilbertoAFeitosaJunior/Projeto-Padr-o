package mobi.stos.padrao.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"mobi.stos.padrao.dao", "mobi.stos.padrao.bo"})
@ImportResource({"classpath:applicationContext.xml"})
public class PersistenceXmlConfig {

    public PersistenceXmlConfig() {
        super();
    }

}

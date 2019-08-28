package myoidc.server.domain.shared;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author Shengzhao Li
 */
@Component
public class Application implements InitializingBean {


    //系统字符编码
    public static final String ENCODING = "UTF-8";

    public static final String PROJECT_HOME = "https://github.com/monkeyk/MyOIDC";
    /**
     * Project Version
     * must same with  <version> </version>  in pom.xml
     */
    public static final String VERSION = "1.1.1";


    private static final Logger LOG = LoggerFactory.getLogger(Application.class);


    //application host
    private static String host;


    /*
    * default
    * */
    public Application() {
    }


    public static String host() {
        return host;
    }


    @Value("${oidc.issuer}")
    public void setHost(String host) {
        Application.host = host;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(host, "host is null");
        LOG.info("System-Host('oidc.issuer'): {}", host);
    }
}
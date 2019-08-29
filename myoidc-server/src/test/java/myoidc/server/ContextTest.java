package myoidc.server;


import myoidc.server.domain.shared.BeanProvider;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;


/**
 * @author Shengzhao Li
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public abstract class ContextTest extends AbstractTransactionalJUnit4SpringContextTests {


    @BeforeTransaction
    public void before() throws Exception {
        BeanProvider.initialize(applicationContext);
//        SecurityUtils securityUtils = new SecurityUtils();
//        securityUtils.setSecurityHolder(new SpringSecurityHolder() {
//            @Override
//            public OIDCUserDetails userDetails() {
//                return null;
//            }
//        });
    }


}
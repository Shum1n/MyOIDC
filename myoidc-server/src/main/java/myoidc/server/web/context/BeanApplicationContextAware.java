package myoidc.server.web.context;

import myoidc.server.domain.shared.BeanProvider;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 2019/8/28
 *
 * @author Shengzhao Li
 * @since 1.1.1
 */
@Component
public class BeanApplicationContextAware implements ApplicationContextAware {


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanProvider.initialize(applicationContext);
    }
}

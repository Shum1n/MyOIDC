package myoidc.server.web;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 2019/8/28
 *
 * @author Shengzhao Li
 */
public class WebUtilsTest {


    @Test
    public void getIp() {

        String ip = WebUtils.getIp();
        assertNull(ip);

    }

}
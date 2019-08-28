package myoidc.server.infrastructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 2019/8/28
 *
 * @author Shengzhao Li
 */
public class RandomUtilsTest {


    @Test
    public void randomText() throws Exception {

        String s = RandomUtils.randomText();

        assertNotNull(s);
        assertTrue(s.length() > 1);
    }

    @Test
    public void randomNumber() throws Exception {

        String s = RandomUtils.randomNumber();
        assertNotNull(s);
        assertTrue(s.length() > 2);
    }

}
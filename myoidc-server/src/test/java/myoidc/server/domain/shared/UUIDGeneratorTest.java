package myoidc.server.domain.shared;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 2019/8/28
 *
 * @author Shengzhao Li
 */
public class UUIDGeneratorTest {


    @Test
    public void generate() throws Exception {

        String generate = UUIDGenerator.generate();
        assertNotNull(generate);
        assertTrue(generate.length() > 20);

    }

}
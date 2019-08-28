package myoidc.server.domain.shared;

import org.apache.commons.lang.RandomStringUtils;


/**
 * @author Shengzhao Li
 * @since 1.0.0
 */
public abstract class UUIDGenerator {


    protected UUIDGenerator() {
    }


    public static String generate() {
        return RandomStringUtils.random(42, true, true);
    }
}
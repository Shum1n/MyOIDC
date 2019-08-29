package myoidc.server.infrastructure;

import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;
import net.minidev.json.JSONObject;
import org.jose4j.jws.JsonWebSignature;
import org.junit.Test;
import org.mitre.jose.keystore.JWKSetKeyStore;
import org.springframework.core.io.ClassPathResource;

import java.security.Key;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * 2019/8/29
 *
 * @author Shengzhao Li
 */
public class IdTokenTest {


    @Test
    public void verify() throws Exception {

        String idToken = "eyJraWQiOiJyc2ExIiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhZG1pbiIsImF6cCI6ImNsaWVudCIsImlzcyI6Imh0dHA6XC9cL2xvY2FsaG9zdDo4MDg3XC9zZXJ2ZXJcLyIsImV4cCI6MTU2NzA1MTk3NiwiaWF0IjoxNTY3MDQ4Mzc2LCJqdGkiOiJkZWE1MGFjZS0yNDQzLTQ3MWItODYyNC00N2NhYWJjYzc5MzIifQ.SkELoL0E1sIpXs7KXmB8-_hwQImruB3jZhzHTe4jG-V-SCD3YYq0NP1Lv2ChYpLw-uRT0zOVWuTCgfv5zga3S9k3_p5sHtqdnGG02JNXQnULRVNMFwty2CWi9aravlEkAsdu5j3JkPe6QRbsWUnxfX6wbGHPWog2FpR4URWNvhZMfTVQjtHPjBGAgDvrkLiPWvRp-KEpxHCDpYMSNExS6b_tVVOilCY776KR9OeuvokvRKme7amLRsM8iUBS4th8tqPxUeK2hJcWRqI9_AETsLD4ZA70NYk7qbiwsRYikk3IPjaJnDs4aCng8WjJRv9hB9QtFVjhmFK3RHJOuLutyg";

        JWKSetKeyStore keyStore = new JWKSetKeyStore();
        keyStore.setLocation(new ClassPathResource("keystore.jwks"));

        List<JWK> keys = keyStore.getKeys();
        assertTrue(keys.size() > 0);


        final JWSObject parseJWS = JWSObject.parse(idToken);
        JWSVerifier verifier = new RSASSAVerifier((RSAKey) keys.get(0));
        final boolean verify = parseJWS.verify(verifier);
        assertTrue(verify);

//        parseJWS.getHeader();
        Payload payload1 = parseJWS.getPayload();
        assertNotNull(payload1);

        JSONObject jsonObject = payload1.toJSONObject();
        assertNotNull(jsonObject);
//        System.out.println(payload1.toString());


    }

}

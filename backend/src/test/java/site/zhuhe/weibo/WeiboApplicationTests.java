package site.zhuhe.weibo;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeiboApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void getEncodePassword() {
        String encodePassword = new Sha256Hash("123", "zhuhe").toHex();
        System.out.println(encodePassword);
    }

}

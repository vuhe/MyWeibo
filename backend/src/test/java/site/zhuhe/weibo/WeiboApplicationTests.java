package site.zhuhe.weibo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class WeiboApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void getEncodePassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encodePassword = encoder.encode("123");
        System.out.println(encodePassword);
    }

}

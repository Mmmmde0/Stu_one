package com.testa.usermanager;
import com.testa.usermanager.service.UserService;
import com.testa.usermanager.vo.QueryParam;
import com.testa.usermanager.vo.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ZestTest {
    @Autowired
    private UserService userService;
    @Test
    public void testFind() {
        QueryParam param = new QueryParam();
        param.setNickname("毛");
        R r = userService.findUserList(1, 10, param);
    }
}

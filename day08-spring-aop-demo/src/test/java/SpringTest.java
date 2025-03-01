import com.alivinfer.config.SpringConfig;
import com.alivinfer.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Fer
 * @version 1.0
 * @description Spring 测试类（适用于  Spring 6.x 及以上）
 * @date 2025/3/1
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserById() {
        System.out.println("-------" + userService.getUserById(1) + "---------");
    }
}

import com.alivinfer.config.SpringConfig;
import com.alivinfer.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author Fer
 * @version 1.0
 * @description 测试类
 * @date 2025/3/4
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransaction() {
        try {
            accountService.transfer("Alice", "Bob", 200);
        } catch (Exception e) {
            System.out.println("事务回滚！");
        }
    }
}

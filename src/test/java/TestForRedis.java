import com.ssmstudy.ssm.service.impl.RedisService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestForRedis {
    @Test
    public void testForRedis(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("Spring.xml");
        RedisService bean = ioc.getBean(RedisService.class);
        boolean b = bean.hasKey("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNeWZISEFKU0QzMzRkIiwiaWQiOjEsInVzZXJuYW1lIjoiYWRtaW4iLCJpYXQiOjE2NzAyMTc1NTgsImV4cCI6MTY3MDIxOTM1OH0.Y9nNaFNA_RzoBMrNz9E-rBfvHEKE_vFnapO16qqXl_w");
        System.out.println(b);
    }
}

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class TestForRedis {
    @Test
    public void testForRedis(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("Spring.xml");
        RedisTemplate bean = ioc.getBean(RedisTemplate.class);
        Object o = bean.opsForValue().get("logintoken:eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNeWZISEFKU0QzMzRkIiwiaWQiOjEsInVzZXJuYW1lIjoiYWRtaW4iLCJpYXQiOjE2NzE4NjcxMzYsImV4cCI6MTY3MTg2ODkzNn0.XbPkbcBeTKwjXw8LecJblpmEJFTBjFJwyZe5G4EyFW0");
        System.out.println((String)o);
    }
}

package beans.orig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import beans.orig.bean.MyBean;
import beans.orig.bean.MyComponent;

// Use main test configuration. It is required to allow bean definition
// overriding. It isn't clear how to avoid this.
@SpringBootTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
@RunWith(SpringRunner.class)
public class Test3 {

  @Autowired
  MyComponent comp;

  @Configuration
  @Import(TestConfig.class)
  public static class Config {
    @Bean
    public MyBean bean2() {
      return new MyBean("bean2 from Test");
    }
  }

  @Test
  public void test() {
    assertNotNull(comp);
    assertEquals("bean1", comp.bean2.bean1.value);
    assertEquals("bean2 from Test", comp.bean2.value);
  }
}

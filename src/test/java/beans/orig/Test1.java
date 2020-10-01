package beans.orig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import beans.orig.bean.MyComponent;

// Use virgin main configuration
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test1 {

  @Autowired
  MyComponent comp;

  // Prevent global @ComponentScan and scan only dedicated packages. It isn't
  // clear how to avoid this, because otherwise bean2 will be used from
  // TestConfig (or even any other configuration from tests).
  @Configuration
  @Import(ApplicationConfig.class)
  @ComponentScan("beans.orig.bean")
  public static class Config {

  }

  @Test
  public void test() {
    assertNotNull(comp);
    assertEquals("bean1", comp.bean2.bean1.value);
    assertEquals("bean2", comp.bean2.value);
  }

}

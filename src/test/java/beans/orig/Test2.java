package beans.orig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import beans.orig.bean.MyComponent;

// Use main test configuration. It is required to allow bean definition
// overriding. It isn't clear how to avoid this.
@SpringBootTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
@RunWith(SpringRunner.class)
public class Test2 {

  @Autowired
  MyComponent comp;

  @Test
  public void test() {
    assertNotNull(comp);
    assertEquals("bean1", comp.bean2.bean1.value);
    assertEquals("bean2 from TestConfig", comp.bean2.value);
  }

}

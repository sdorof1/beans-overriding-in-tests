package beans.orig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import beans.orig.bean.MyBean;

// Main test configuration.
// It uses main config with some overridden beans.
@Configuration
@Import(Application.class) // to allow @ComponentScan and so on...
public class TestConfig {

  // Override bean2
  @Bean
  public MyBean bean2() {
    return new MyBean("bean2 from TestConfig");
  }
}

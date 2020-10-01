package beans.orig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import beans.orig.bean.MyBean;

// Main application configuration.
// It could be inside the Application class, but then @Import(Application.class)
// in tests will trigger @ComponentScan, what to avoid sometimes.
@Configuration
public class ApplicationConfig {

  @Bean
  public MyBean bean1() {
    return new MyBean("bean1");
  }

  @Bean
  public MyBean bean2() {
    return new MyBean("bean2");
  }
}

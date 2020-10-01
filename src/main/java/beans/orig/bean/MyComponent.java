package beans.orig.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// The component will be loaded by @ComponentScan
@Component
public class MyComponent {

  @Autowired
  public MyBean bean2;
}

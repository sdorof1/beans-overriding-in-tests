package beans.orig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import beans.orig.bean.MyBean;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(Application.class, args);
    MyBean bean2 = (MyBean) ctx.getBean("bean2");
    if (!bean2.value.equals("bean2")) {
      throw new RuntimeException();
    }
    System.out.println("OK");
  }
}

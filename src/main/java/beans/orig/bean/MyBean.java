package beans.orig.bean;

import org.springframework.beans.factory.annotation.Autowired;

// The bean should be manually configured
public class MyBean {

  @Autowired
  public MyBean bean1;
  
  public String value;

  public MyBean(String value) {
    this.value = value;
  }
}

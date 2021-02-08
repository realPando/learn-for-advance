package springBeanTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
@ComponentScan({"springBeanTest"})
public class BeanLifeCycle {

    public static void main(String[] args) {
        SpringApplication.run(BeanLifeCycle.class, args);
        System.out.println("现在开始初始化容器");

        ApplicationContext factory = ApplicationContextHelper.getCtx();
        System.out.println("容器初始化成功");
        //得到Preson，并使用
        Person person = factory.getBean("person",Person.class);
        System.out.println(person);

        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}
package test;

import beans.Greeting;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        /*
        Order of execution:
        -------------------
        1. Bean class loading
        2. Bean class instantiating
        3. Initialization through property tag (i.e. through setter methods
        4. Initialization through afterPropertiesSet() method of InitializingBean interface
        5. Initialization through custom init() method and it is configured in bean tag using init-method attribute
        6. destroy() method of DisposableBean
        7. Custom destroy() method
         */
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("resources/applicationContext.xml");

        Greeting g = (Greeting) context.getBean("greeting");

        g.greetUser();

        context.registerShutdownHook();
    }
}

package beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Greeting implements InitializingBean, DisposableBean {
    static {
        System.out.println("Greeting bean class loading...");
    }

    public Greeting() {
        System.out.println("Greeting bean class instantiating...");
    }

    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Initializing 'name' using setName() method...");
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        System.out.println("Initializing 'message' using setMessage() method...");
        this.message = message;
    }

    public void greetUser(){
        System.out.println("Hello " + this.getName() + ". " + this.getMessage());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean::destroy() method called...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean::afterPropertiesSet() method called...");
        System.out.println("Initializing 'name' and 'message' using setMessage() method...");
        this.name = "Abdul";
        this.message = "Good Evening!";
    }

    //Custom init() and destroy() methods
    public void init() {
        System.out.println("Greeting::init() method called...");
        System.out.println("Initializing 'name' and 'message' using setMessage() method...");
        this.name = "Mohideen Abdul Katheer";
        this.message = "Good Night! Sweet Dreams!!";
    }

    public void beforeDestroy() {
        System.out.println("Custom destroy() method called...");
    }
}

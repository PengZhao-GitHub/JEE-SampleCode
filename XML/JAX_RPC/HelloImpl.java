package hello;

public class HelloImpl implements HelloIF {

    public String message = new String("Hello ");

    public String sayHello(String s) {
        return new String(message + s);
    }
}


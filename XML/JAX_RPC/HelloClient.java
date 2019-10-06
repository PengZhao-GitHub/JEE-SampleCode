package hello;

public class HelloClient {
    public static void main(String[] args) {
        try {
            HelloIF_Stub stub =
                (HelloIF_Stub)(new HelloWorld_Impl().getHelloIF());
            stub._setProperty(
                javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY,
                args[0]);
            System.out.println(stub.sayHello("Duke!"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    
}

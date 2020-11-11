package introjunit;

public class Gentleman {
    public String sayHello(String name){
        return "Hello " + (name==null ? "Anonymous" : name) + "!";
    }

}

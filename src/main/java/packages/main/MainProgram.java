package packages.main;


import packages.greetings.Greeter;

public class MainProgram {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        greeter.sayHello();
    }
}

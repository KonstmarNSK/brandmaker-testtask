package beans;

import javax.ejb.Singleton;

@Singleton
public class SomeEjb {
    public String greet(String arg){
        return "Hello, " + arg + "!";
    }
}

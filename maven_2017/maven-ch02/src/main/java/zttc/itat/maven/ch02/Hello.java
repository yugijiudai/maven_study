package zttc.itat.maven.ch02;
import zttc.itat.maven.HelloMaven;
/**
 * @author yugi
 * @apiNote
 * @since 2017-02-13
 */
public class Hello {

    public String say(String name) {
        HelloMaven hello = new HelloMaven();
        return hello.sayHello(name);
    }
}

package zttc.itat.maven;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author yugi
 * @apiNote
 * @since 2017-02-13
 */
public class TestHelloMaven {
    @Test
    public void testSayHello() throws Exception {
        HelloMaven helloMaven = new HelloMaven();
        String str = helloMaven.sayHello("maven");
        System.out.println("呵呵");
        assertEquals(str, "hello:maven");
    }
}

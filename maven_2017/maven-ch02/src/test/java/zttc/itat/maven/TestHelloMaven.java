package zttc.itat.maven;

import org.hibernate.Session;
import org.junit.Test;
import zttc.itat.maven.ch02.Hello;
import zttc.itat.maven.util.HibernateUtil;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author yugi
 * @apiNote
 * @since 2017-02-13
 */

public class TestHelloMaven {

    private String name = "龟爷";


    @Test
    public void testSayHello() throws Exception {
        HelloMaven helloMaven = new HelloMaven();
        String str = helloMaven.sayHello("maven");
        assertEquals(str, "hello:maven");
    }


    @Test
    public void testGetMe2() {
        Session session = HibernateUtil.getSession2();
        System.out.println(session);
        Hello hello = new Hello();
        hello.say("fuck you");
        hello.say("fuck you2");
    }


    @Test
    public void testMap() {
        Map<Long, Map> map = new HashMap<>();
        Map<String, Integer> allNeedReturn = this.getNeedReturn();
        Long borrowId = 1L;
        map.putIfAbsent(borrowId, allNeedReturn);

        Map<String, Integer> app = this.getApp(1);
        calculateAppAmount(map, app, borrowId);
        assertEquals(2, map.get(borrowId).get(name));
        app = this.addMap(app);
        calculateAppAmount(map, app, borrowId);
        assertEquals(0, map.get(borrowId).get(name));
        app = this.addMap(app);
        calculateAppAmount(map, app, borrowId);
        assertEquals(0, map.get(borrowId).get(name));
        assertEquals(0, app.size());

    }

    private void calculateAppAmount(Map<Long, Map> map, Map<String, Integer> app, Long borrowId) {
        Integer appAmount = app.get(name);
        Map<String, Integer> map1 = map.get(borrowId);
        Integer needReturn = map1.get(name);
        int result = Math.subtractExact(needReturn, appAmount);
        if (result >= 0) {
            map1.put(name, result);
        }
        else {
            map1.put(name, 0);
            app.remove(name);
        }
        map.put(borrowId, map1);
    }

    private Map<String, Integer> getNeedReturn() {
        Map<String, Integer> needReturn = new HashMap<>();
        needReturn.put(name, 3);
        return needReturn;
    }

    private Map<String, Integer> getApp(Integer count) {
        Map<String, Integer> app = new HashMap<>();
        app.put(name, count);
        return app;
    }

    private Map<String, Integer> addMap(Map<String, Integer> map) {
        Integer count = map.get(name);
        count++;
        map.put(name, count);
        return map;
    }


}

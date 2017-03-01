package zttc.itat.maven.dao;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import zttc.itat.maven.pojo.User;
import zttc.itat.maven.service.IUserService;
import zttc.itat.maven.testObject.UserObject;
import zttc.itat.maven.util.HibernateUtil;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author yugi
 * @apiNote
 * @since 2017-02-14
 */
@RunWith(EasyMockRunner.class)
public class TestUserDao {

    // @Mock annotation is used to create the mock object to be injected
    // 使用注解注入需要被膜的对象
    @Mock
    private IUserService iUserService;

    // @TestSubject annotation is used to identify class which is going to use the mock object
    // 需要使用膜的对象
    @TestSubject
    private UserObject userObject = new UserObject();
    // private UserObject userObject = new UserObject(iUserService);

    @Before
    public void setUp() throws Exception {
        // iUserService = EasyMock.createMock(IUserService.class);
        // iUserService = EasyMock.createStrictMock(IUserService.class);
        // userDao = new UserDao(iUserService);

    }

    @Test
    public void testSaveUser() {
        HibernateUtil.createDB();
        User user = new User();
        user.setName("龟爷");
        UserDao userDao = new UserDao();
        userDao.saveUser(user);
        assertNotNull(user.getId());
        assertEquals("龟爷", user.getName());
    }




    @Test
    public void testMo() throws Exception {
        //这里设置期待返回的值
        EasyMock.expect(userObject.add("苟利", "岂因")).andReturn("???");
        // EasyMock.expectLastCall();
        EasyMock.expect(userObject.add("什么是", "坠吼的?")).andReturn("闷身发大财");
        //这里是期待返回的值生效
        EasyMock.replay(iUserService);
        assertEquals(userObject.add("苟利", "岂因"), "???");
        assertEquals(userObject.add("什么是", "坠吼的?"), "闷身发大财");
        //验证返回的值
        EasyMock.verify(iUserService);
    }

    @Test
    public void testSa() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "名字");
        map.put("id", 2);
        EasyMock.expect(userObject.ta()).andReturn(map);
        EasyMock.replay(iUserService);
        assertEquals(userObject.ta(), map);
        EasyMock.verify(iUserService);
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestUserDao.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }

    @After
    public void tearDown() throws Exception {
        HibernateUtil.closeSession();
    }
}
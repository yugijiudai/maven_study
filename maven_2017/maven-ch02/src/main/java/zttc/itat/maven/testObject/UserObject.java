package zttc.itat.maven.testObject;

import zttc.itat.maven.service.IUserService;

import java.util.Map;

/**
 * @author yugi
 * @apiNote
 * @since 2017-02-14
 */
public class UserObject {

    private IUserService iUserService;


    // public void setiUserService(IUserService iUserService) {
    //     this.iUserService = iUserService;
    // }

    public String add(String a, String b) {
        String result = iUserService.add(a, b);
        // result += "+";
        return result;
    }

    public Map<String, Object> ta() {
        return iUserService.ta();
    }
}

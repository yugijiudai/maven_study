package zttc.itat.maven.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import zttc.itat.maven.pojo.User;
import zttc.itat.maven.util.HibernateUtil;

/**
 * @author yugi
 * @apiNote
 * @since 2017-02-14
 */
public class UserDao {


    public void saveUser(User user) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
        tx.commit();
        HibernateUtil.closeSession();
    }


}

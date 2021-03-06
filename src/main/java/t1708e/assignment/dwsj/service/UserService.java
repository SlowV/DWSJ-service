package t1708e.assignment.dwsj.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import t1708e.assignment.dwsj.entity.User;
import t1708e.assignment.dwsj.util.HibernateUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class UserService {
    private static Session session = HibernateUtil.getSession();

    @WebMethod
    public User register(User user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println(user.getUsername());
        return user;
    }
    @WebMethod
    public User updateUser(User user) {
        return user;
    }

    @WebMethod
    public List<User> getListUser() {
        List<User> users = new ArrayList<>();
        return users;
    }

    @WebMethod
    public boolean deleteUser() {
        return true;
    }


    public User findByUsername(String username) {
        Criteria criteria = session.createCriteria(User.class)
                .add(Restrictions.eq("username", username));
        Object result = criteria.uniqueResult();
        if (result != null){
            return (User) result;
        }
        return null;
    }
}

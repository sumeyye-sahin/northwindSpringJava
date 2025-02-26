package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.dataAccess.UserDao;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SucccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserManager implements UserService {

    private UserDao userDao;


    @Autowired
    public UserManager(UserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi.") ;
    }

    @Override
    public DataResult<User> findByEmail(String email) {


        return new SucccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı bulundu.");
    }
}

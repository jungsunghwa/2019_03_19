package kr.hs.dgsw.web_01_319;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService{

    private List<User> userList;

    public UserServiceImpl() {
        this.userList = new ArrayList<User>();

        userList.add(new User("user1ID" ,"user1","user111@dgsw.hs.kr"));
        userList.add(new User("user2ID" ,"user2","user222@dgsw.hs.kr"));
        userList.add(new User("user3ID" ,"user3","user333@dgsw.hs.kr"));
    }

    @Override
    public List<User> list() {
        return this.userList;
    }

    @Override
    public User view(String id) {
       return this.userList.stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .orElse(null);

    }

    @Override
    public boolean add(User user) {
        if (view(user.getId()) == null)
            return this.userList.add(user);
        else
            return false;
    }

    @Override
    public User update(User user) {
        User found = view(user.getId());
        if (found!= null){
            found = user;
        }
        return found;
    }

    @Override
    public boolean delete(String id) {
        User found = view(id);
        return userList.remove(found);
    }

    public User find1(String name){
        Iterator<User> userIterator = this.userList.iterator();
        while(userIterator.hasNext()){
            User user = userIterator.next();
            if (user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public User find2(String name){
        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).getName().equals(name)){
                return userList.get(i);
            }
        }
        return null;
    }

    public User find3(String name){
        for(User user : userList){
            if (user.name.equals(name)) return user;
        }
        return null;
    }

}

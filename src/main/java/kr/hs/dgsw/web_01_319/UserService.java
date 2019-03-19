package kr.hs.dgsw.web_01_319;

import java.util.List;

public interface UserService {
    List<User> list();
    User view(String id);
    boolean add(User user);
    User update(User user);
    boolean delete(String name);
}

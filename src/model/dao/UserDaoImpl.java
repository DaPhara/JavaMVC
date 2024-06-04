package model.dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private List<User> userList = new ArrayList<>(
            List.of(new User(1, "KoKo", "koko123@gmail.com"),
                    new User(2, "KaKa", "kaka123@gmail.com"))
    );

    @Override
    public void addNewUser(User user) {
        // Assign a new ID if the user ID is null or duplicate
        if (user.getId() == null) {
            int newId = userList.stream()
                    .map(User::getId)
                    .max(Integer::compare)
                    .orElse(0) + 1;
            user.setId(newId);
        }
        userList.add(user);
    }

    @Override
    public void deleteUser(Integer id) {
        if (id == null) {
            return; // Do nothing if id is null
        }
        userList.removeIf(e -> id.equals(e.getId()));
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public void updateUser(User user) {
        if (user == null || user.getId() == null) {
            return; // Do nothing if user or user ID is null
        }
        for (int i = 0; i < userList.size(); i++) {
            if (user.getId().equals(userList.get(i).getId())) {
                userList.set(i, user);
                break;
            }
        }
    }
}

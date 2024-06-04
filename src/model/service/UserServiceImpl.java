package model.service;

import mapper.Mapper;
import model.User;
import model.dao.UserDao;
import model.dao.UserDaoImpl;
import model.dto.UserDto;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<UserDto> getAllUsers() {
        return userDao.getAllUsers()
                .stream()
                .map(Mapper::mapFromUserToUserDto)
                .toList();
    }

    @Override
    public void addNewUser(UserDto userDto) {
        User user = Mapper.mapFromUserDtoToUser(userDto);
        userDao.addNewUser(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void updateUser(UserDto userDto) {
        User user = Mapper.mapFromUserDtoToUser(userDto);
        userDao.updateUser(user);
    }
}
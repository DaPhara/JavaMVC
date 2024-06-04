package mapper;

import model.User;
import model.dto.UserDto;

public class Mapper {
    public static UserDto mapFromUserToUserDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public static User mapFromUserDtoToUser(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        return new User(userDto.userId(), userDto.userName(), userDto.email());
    }
}

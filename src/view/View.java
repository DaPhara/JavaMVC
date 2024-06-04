package view;

import controller.UserController;
import model.dto.UserDto;

public class View {
    private static final UserController userController = new UserController();

    public static void UI() {
        System.out.println("=============================================================");
        System.out.println("This is view: ");
        userController.getAllUsers()
                .forEach(System.out::println);

        // Example usage of addNewUser
        UserDto newUser = new UserDto(null, "NewUser", "newuser@gmail.com");
        userController.addNewUser(newUser);
        System.out.println();
        System.out.println("=============================================================");
        System.out.println();
        System.out.println("After adding new user: ");
        userController.getAllUsers()
                .forEach(System.out::println);

        // Example usage of updateUser
        UserDto updatedUser = new UserDto(1, "UpdatedKoKo", "updated_koko123@gmail.com");
        userController.updateUser(updatedUser);
        System.out.println();
        System.out.println("=============================================================");
        System.out.println();
        System.out.println("After updating user: ");
        userController.getAllUsers()
                .forEach(System.out::println);

        // Example usage of deleteUser
        userController.deleteUser(1);
        System.out.println();
        System.out.println("=============================================================");
        System.out.println();
        System.out.println("After deleting user: ");
        userController.getAllUsers()
                .forEach(System.out::println);
    }
}
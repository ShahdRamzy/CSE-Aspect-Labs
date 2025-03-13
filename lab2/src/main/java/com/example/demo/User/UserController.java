package com.example.demo.User;

import com.example.demo.User.dto.CreateUserDto;
import com.example.demo.User.dto.UpdateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

        @Autowired()
        private final UserService userService;
        public UserController(UserService userService) {
            this.userService = userService;
        }
        @GetMapping()
        public List<User> getStudents(){
            return userService.getUser();
        }
        @PostMapping()
    public User createUser(@RequestBody CreateUserDto createUserDto){
        return this.userService.createUser(createUserDto);
        }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody UpdateUserDto updateUserDto) {
        return userService.updateUser(id, updateUserDto);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User with ID " + id + " deleted successfully.";
    }
}



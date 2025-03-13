package com.example.demo.User;

import com.example.demo.User.dto.CreateUserDto;
import com.example.demo.User.dto.UpdateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public List<User> getUser(){
        return this.userRepository.findAll();
    }

    public User createUser(CreateUserDto userDto){
        User user = new User(
                userDto.getEmail(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getPhoneNumber()
        );
        return this.userRepository.save(user);
    }
    public User findUserById(int id) {
        return getUser().stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(int id, UpdateUserDto updateUserDto) {
        User user = findUserById(id);
        user.setUsername(updateUserDto.getUsername());
        user.setEmail(updateUserDto.getEmail());
        user.setPassword(updateUserDto.getPassword());
        user.setPhoneNumber(updateUserDto.getPhoneNumber());
        return user;
    }

    public void deleteUser(Long id) {
        getUser().removeIf(user -> user.getId().equals(id));
    }
}

package com.stackroute.springboot.service;

import com.stackroute.springboot.model.User;
import com.stackroute.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user) throws Exception {
        Optional<User> userDB =this.userRepository.findById(user.getId());
        if(userDB.isPresent()) {
            User userUpdate = userDB.get();
            userUpdate.setId(user.getId());
            userUpdate.setFirstname(user.getFirstname());
            userUpdate.setGender(user.getLastname());
            userUpdate.setGender(user.getGender());

            userUpdate.setAge(user.getAge());
            userRepository.save(userUpdate);
            return userUpdate;
        }else{
            throw new Exception("Record not found with given id");
        }

    }
    @Override
    public void deleteUser(int id) throws Exception {
//        userRepository.findById(id).ifPresent(User-> userRepository.delete(User));
        Optional<User> userDB=this.userRepository.findById(id);
        if(userDB.isPresent()){
            this.userRepository.delete(userDB.get());
        }else{
            throw new Exception("user not found");
        }
    }


}

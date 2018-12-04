package com.springbootdemo.springbootneo4j.service;

import com.springbootdemo.springbootneo4j.entity.User;
import com.springbootdemo.springbootneo4j.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Little Rookies
 * @Date: 2018-12-04 16:48
 */
@Service
public class Neo4jService {

    @Autowired
    private UserRepository userRepository;

    public int addUser(User userNode) {
        userRepository.addUserNodeList(userNode.getName(), userNode.getAge());
        return 1;
    }

    public List<User> getUserNodeList() {
        return userRepository.getUserNodeList();
    }
}

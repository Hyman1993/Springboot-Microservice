package com.tokyocoder.user.service;

import com.tokyocoder.user.VO.Department;
import com.tokyocoder.user.VO.ResponseTemplateVO;
import com.tokyocoder.user.entity.User;
import com.tokyocoder.user.repositroy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private UserRepository userRepository;

    private RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository,RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findById(userId).get();

        Department department = restTemplate.getForObject("http://localhost:9011/departments/" + user.getDepartmentId()
                ,Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}

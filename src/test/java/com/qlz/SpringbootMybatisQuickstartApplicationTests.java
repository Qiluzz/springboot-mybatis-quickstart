package com.qlz;

import com.qlz.mapper.EmpMapper;
import com.qlz.mapper.UserMapper;
import com.qlz.pojo.Emp;
import com.qlz.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testListUser() {
        List<User> userList = userMapper.list();
        userList.stream().forEach(user -> {
            System.out.println(user);
            user.getAge();
        });
    }

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete() {
        empMapper.delete(16);
    }

    @Test
    public void testInsert() {
        Emp emp = new Emp();

        emp.setUsername("Tom2");
        emp.setName("汤姆2");
        emp.setImage("2.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);
        System.out.println(emp.getId());


    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(9);
        emp.setUsername("Tom4445666");
//        emp.setName("汤姆44456");
//        emp.setGender((short)1);
//
//        emp.setCreateTime(LocalDateTime.now());
//        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update2(emp);


    }

    @Test
    public void testGetById() {
        Emp emp = empMapper.getById(11);
        System.out.println(emp);
    }

    @Test
    public void testList() {
        List<Emp> empList = empMapper.list(null, null, null, null);
        System.out.println(empList);
    }

    @Test
    public void testDeleteByIds() {
        List<Integer> ids = Arrays.asList(12, 13, 14);
        empMapper.deleteByIds(ids);
    }

}

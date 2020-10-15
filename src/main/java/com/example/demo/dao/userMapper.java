package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface userMapper extends JpaRepository<User, Long> {

    //自定义查询
    @Query(value = "select t from User t")
    List<User> myQuery();

    //根据id删除user
    void deleteById(long id);

    //根据id查找user
    User findById(long id);

}

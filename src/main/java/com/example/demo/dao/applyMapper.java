package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.*;

/**
 * Created by 星 on 2020/8/25
 */
@Repository
public interface applyMapper extends JpaRepository<Apply,Long> {
}

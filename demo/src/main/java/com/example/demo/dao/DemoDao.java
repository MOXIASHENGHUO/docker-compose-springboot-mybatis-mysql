package com.example.demo.dao;

import com.example.demo.pojo.Demo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * dao数据
 */
public interface DemoDao {

    @Select("select *  from  demo")
    List<Demo> getAll();

    @Select("select * from demo where id=#{id}")
    Demo getDemoById(int id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("INSERT INTO demo (name, info) VALUES (#{name}, #{info})")
    int insertDemo(Demo demo);

    @Update("UPDATE demo set name=#{name}, info=#{info} WHERE id=#{id}")
    int updateDemo(Demo demo);

    @Delete("DELETE FROM demo WHERE id=#{id}")
    int deleteDemoById(int id);
}

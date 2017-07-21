package com.github.emacsist.mapper;


import com.github.emacsist.pojo.Person;

public interface PersonMapper {
    Person selectOne(Integer id);
}

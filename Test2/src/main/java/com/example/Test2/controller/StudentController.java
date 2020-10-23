package com.example.Test2.controller;


import com.example.Test2.repository.StudentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentInfoRepository studentInfoRepository;
    private final DataSource dataSource;

    @Autowired
    public StudentController(StudentInfoRepository studentInfoRepository, DataSource dataSource) {
        this.studentInfoRepository = studentInfoRepository;
        this.dataSource = dataSource;
    }


    @GetMapping("/{table}/{id}")
    public Object getStudentsInfoById(@PathVariable("table") String tableName,
                                      @PathVariable("id") Integer id) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        Map<String, Integer> values = new HashMap<>();
        values.put("id", id);
        Map<String, Object> objectMap = namedParameterJdbcTemplate.queryForMap("select * from " + tableName +" where id=:id", values);
        return objectMap;
    }

    @GetMapping("/{table}")
    public List<Map<String, Object>> getAllStudentsInfo(@PathVariable ("table") String tableName) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        String SQL = "Select * from " + tableName;
        return template.queryForList(SQL);
    }

}

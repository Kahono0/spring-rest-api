package com.lab.lab1.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegistrationHandler {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean create(RegistrationRequestModel model) {

        try {
            String sql = "INSERT INTO lab1.users (name, email, Dob, phone, address) VALUES (?, ?, ?, ?, ?)";
            Object params[] = new Object[]{
                    model.getName(),
                    model.getEmail(),
                    model.getDob(),
                    model.getPhone(),
                    model.getAddress()
            };

            jdbcTemplate.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public List<ResponseModel> fetch(){
        try{
            String sql = "SELECT name, address, email, Dob, phone FROM lab1.users";

            List <ResponseModel> response = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ResponseModel.class));
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
            List <ResponseModel> response = new ArrayList<>();
            return response;
        }
    }

    public boolean update(){

    }
}
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
            Object[] params = new Object[]{
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

    public ResponseModel fetchOne(String id){
        ResponseModel response;
        try{
            String sql = "SELECT id, name, address, email, Dob, phone FROM lab1.users WHERE id = ?";
            Object[] params = new Object[]{id};

            response = jdbcTemplate.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(ResponseModel.class));
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
            response = new ResponseModel();
            return response;
        }
    }

    public List<ResponseModel> fetch(){
        List<ResponseModel> response;
        try{
            String sql = "SELECT id, name, address, email, Dob, phone FROM lab1.users";

            response = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ResponseModel.class));
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
            response = new ArrayList<>();
            return response;
        }
    }

    public boolean update(RegistrationRequestModel model, String id){
        try{
            String sql = "UPDATE lab1.users SET name = ?, email = ?, Dob = ?, phone = ?, address = ? WHERE id = ?";
            Object[] params = new Object[]{
                    model.getName(),
                    model.getEmail(),
                    model.getDob(),
                    model.getPhone(),
                    model.getAddress(),
                    id
            };

            jdbcTemplate.update(sql, params);

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
       return true;
    }

    public boolean delete(String id){
        try{
            String sql = "DELETE FROM lab1.users WHERE id = ?";
            Object[] params = new Object[]{
                    id
            };

            jdbcTemplate.update(sql, params);

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
       return true;
    }


}
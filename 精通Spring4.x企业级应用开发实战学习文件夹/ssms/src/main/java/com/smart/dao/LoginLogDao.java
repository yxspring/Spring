package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao {
    private JdbcTemplate jdbcTemplatep;
    private final static String insert_login_log_sql=" INSERT INTO t_login_log ( user_id, ip, login_datetime ) VALUES ( ?,?,? ) ";

    public void insertLoginLog(LoginLog loginLog){
        Object[]args={loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()};
        jdbcTemplatep.update(insert_login_log_sql,args);
    }
    @Autowired
    public void setJdbcTemplatep(JdbcTemplate jdbcTemplatep){
        this.jdbcTemplatep=jdbcTemplatep;
    }
}

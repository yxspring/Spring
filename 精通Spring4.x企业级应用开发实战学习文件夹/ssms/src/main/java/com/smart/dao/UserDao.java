package com.smart.dao;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public int getMatchCount(String userName,String password){
        String sqlStr=" select count(*) from t_user where user_name=? and password=? ";
        return jdbcTemplate.queryForObject(sqlStr,new Object[]{userName,password},Integer.class);
    }
    public User findUserByUSerName(final String userName){
        final User user=new User();
        String query_by_userName=" select user_id,user_name,credits from t_user where user_name=? ";
        jdbcTemplate.query(
                query_by_userName, new Object[]{userName}, new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        user.setUserId(rs.getInt("user_id"));
                        user.setUserName(userName);
                        user.setCredits(rs.getInt("credits"));
                    }
                }
        );
        return user;
    }
    public void updateLoginInfo(User user){
        String update_login_info_log="update t_user set last_visit=?,last_ip=?,credits=? where user_id=? ";
        jdbcTemplate.update(update_login_info_log,new Object[]{
               user.getLastVisit(), user.getLastIp(),user.getCredits(),user.getUserId()
        });
    }
}

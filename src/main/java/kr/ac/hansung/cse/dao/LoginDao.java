package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class LoginDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 사용자 이름과 비밀번호로 로그인을 시도하고, 유효한 사용자인지 확인
    public boolean validateUser(String username, String password) {
        String sqlStatement = "select count(*) from user where username=? and password=?";
        Integer count = jdbcTemplate.queryForObject(sqlStatement, new Object[]{username, password}, Integer.class);
        return count != null && count == 1;
    }

    // 사용자 정보 가져오기
    public User getUser(String username) {
        String sqlStatement = "select * from users where username=?";
        return jdbcTemplate.queryForObject(sqlStatement, new Object[]{username}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
    }
}
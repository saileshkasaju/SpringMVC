/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.saileshkasaju.webapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import np.com.saileshkasaju.webapp.dao.CourseDAO;
import np.com.saileshkasaju.webapp.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Edge
 */
@Repository(value = "courseDAO")
public class CourseDAOImpl implements CourseDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int insert(Course c) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbl_courses(course_name,course_code,fees,status) VALUES(?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{c.getName(), c.getCode(), c.getFees(), c.isStatus()});
    }

    @Override
    public List<Course> getAll() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_courses";
        return jdbcTemplate.query(sql,new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int i) throws SQLException {
                Course c = new Course();
                c.setId(rs.getInt("course_id"));
                c.setName(rs.getString("course_name"));
                c.setCode(rs.getString("course_code"));
                c.setFees(rs.getInt("fees"));
                c.setStatus(rs.getBoolean("status"));
                return c;
            }
        });
    }

    @Override
    public Course getById(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM tbl_courses WHERE course_id=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int i) throws SQLException {
                Course c = new Course();
                c.setId(rs.getInt("course_id"));
                c.setName(rs.getString("course_name"));
                c.setCode(rs.getString("course_code"));
                c.setFees(rs.getInt("fees"));
                c.setStatus(rs.getBoolean("status"));
                return c;
            }
        });
    }

    
    
}

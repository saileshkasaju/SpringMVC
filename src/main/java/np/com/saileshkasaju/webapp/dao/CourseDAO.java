/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.saileshkasaju.webapp.dao;

import java.sql.SQLException;
import java.util.List;
import np.com.saileshkasaju.webapp.entity.Course;

/**
 *
 * @author Edge
 */
public interface CourseDAO {
    // todo implement update and delete
    int insert(Course c) throws ClassNotFoundException, SQLException;
    List<Course> getAll() throws ClassNotFoundException, SQLException;
    Course getById(int id) throws ClassNotFoundException, SQLException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.saileshkasaju.webapp.controller;

import np.com.saileshkasaju.webapp.dao.CourseDAO;
import np.com.saileshkasaju.webapp.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Edge
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {
    @Autowired
    private CourseDAO courseDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("name", "Maven Spring");
        try{            
            model.addAttribute("courses",courseDAO.getAll());            
        } catch(Exception ioe) {
        }
        return "index";
    }
    
    @RequestMapping(value = "/details/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String detail(@PathVariable("id")int id) {
        Course c = new Course();
        try{
            c = courseDAO.getById(id);
        } catch(Exception ioe) {
        }
        return c.getName() + " " + c.getCode() + " " + c.getFees();    
    }
    
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        int result = 0;
        try{
            result = courseDAO.insert(new Course(0, "Kasaju", "SK", 25000, true));
            
        } catch(Exception ioe) {
        }
        return result + "";    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces.controllers;

import faces.entities.tags;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author c0687631
 */
@Named
@ApplicationScoped
public class tagController {
    
    private List<tags> tag;
    
    public tagController()
    {
       
    }

   
    
    
}

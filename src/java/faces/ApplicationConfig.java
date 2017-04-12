/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import java.util.Set;
import javax.ws.rs.core.Application;


/**
 *
 * @author c0687631
 */
@javax.ws.rs.ApplicationPath("r")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(faces.UsersRest.class);
        resources.add(faces.itemRest.class);
        resources.add(faces.ordersRest.class);
        resources.add(faces.paymentREST.class);
        resources.add(faces.tagRest.class);
    }
    
}

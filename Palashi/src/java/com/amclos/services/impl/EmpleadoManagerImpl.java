/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.amclos.services.impl;


import com.amclos.dao.Dao;
import com.amclos.model.Empleado;
import com.amclos.services.EmpleadoManager;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author 85154220
 */
@Service("EmpleadoManager")
public class EmpleadoManagerImpl implements EmpleadoManager{
    @Autowired
    @Qualifier ("DaoHibernate")
    private Dao dao ;

    @Override
    public List<Empleado> getEmpleados() {
        String hql ="Select p from Empleado p order by p.nombre";
        return dao.find(hql);
    }

    @Override
    public boolean save(Long cedula, String nombre, String apellido, String sexo, Date fechanacimiento) {
        Empleado empleado = new Empleado(cedula,nombre,apellido,sexo,fechanacimiento);
        
        try{
        dao.persist(empleado);
        return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*@Override
    public void edit(String idEmpleado, String nombre, String valor) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Empleado p = (Empleado) session.get(Empleado.class, 1);
    }*/

    @Override
     public boolean delete(Long cedula) { 
        String hql="SELECT p FROM Empleado p WHERE p.cedula ="+cedula;
        Empleado empleado = dao.findObject(hql);
        try{
        dao.delete(empleado);
        return true; 
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


    
}
    

 
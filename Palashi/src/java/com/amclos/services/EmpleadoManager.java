/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amclos.services;

import com.amclos.model.Empleado;
import java.util.Date;
import java.util.List;

/**
 *
 * @author BCurieldim
 */
public interface EmpleadoManager{

public boolean save(Long cedula, String nombre, String apellido, String sexo, Date fechanacimiento);

public List<Empleado> getEmpleados();

public boolean delete(Long cedula);
    
}

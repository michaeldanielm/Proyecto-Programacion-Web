/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.model.webservice;

import co.model.pojos.Usuario;
import co.model.usuario.EliminarDAO;
import co.model.usuario.ModificarDAO;
import co.model.usuario.RegistrarDAO;
import co.model.usuario.UsuariosDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author User
 */
@WebService(serviceName = "WebServiceUsuario")
public class WebServiceUsuario {

    /**
     * Web service operation
     * @param nombreUsuario
     * @param clave
     * @return 
     */
    @WebMethod(operationName = "validar")
    public String validar(@WebParam(name = "nombreUsuario") String nombreUsuario,
            @WebParam(name = "clave") String clave) {
        Usuario u = new Usuario(nombreUsuario, clave);
        UsuariosDAO usuD = new UsuariosDAO();
        usuD.validarUsuario(u);
        return "Existe";
    }

    /**
     *
     * @param nombre
     * @param apellido
     * @param email
     * @param nombreUsuario
     * @param clave
     * @return
     */
    @WebMethod(operationName = "registrar")
    public String registrar(@WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido") String apellido,
            @WebParam(name = "email") String email,
            @WebParam(name = "nombreUsuario") String nombreUsuario,
            @WebParam(name = "clave") String clave) {
        Usuario u = new Usuario(nombre, apellido, email, nombreUsuario, clave);
        RegistrarDAO regD = new RegistrarDAO();
        regD.registrarUsuario(u);
        return "Usuario Ingresado";
    }

    /**
     *
     * @param idUsuario
     * @return
     */
    @WebMethod(operationName = "eliminar")
    public String eliminar(@WebParam(name = "idUsuario") Integer idUsuario) {
        Usuario u = new Usuario(idUsuario);
        EliminarDAO eliD = new EliminarDAO();
        eliD.eliminarUsuario(u);
        return "Usuario Eliminado";
    }

    /**
     *
     * @param idUsuario
     * @param nombre
     * @param apellido
     * @param email
     * @param nombreUsuario
     * @param clave
     * @return
     */
    @WebMethod(operationName = "Modificar")
    public String modificar(@WebParam(name = "idUsuario") Integer idUsuario,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido") String apellido,
            @WebParam(name = "email") String email,
            @WebParam(name = "nombreUsuario") String nombreUsuario,
            @WebParam(name = "clave") String clave) {
        Usuario u = new Usuario( idUsuario, nombre, apellido, email,nombreUsuario, clave);
        ModificarDAO modD = new ModificarDAO();
        modD.modificarUsuario(u);
        return "Usuario Modificado";
    }
}

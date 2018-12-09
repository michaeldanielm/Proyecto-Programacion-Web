/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.model.webservice;

import co.model.comentario.EliminarComentarioDAO;
import co.model.comentario.ModificarComentarioDAO;
import co.model.comentario.NuevoComentarioDAO;
import co.model.noticia.ModificarNoticiaDAO;
import co.model.pojos.Comentario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author User
 */
@WebService(serviceName = "WebServiceComentario")
public class WebServiceComentario {

    /**
     * This is a sample web service operation
     * @param TituloComentario
     * @param ContenidoComentario
     * @param nombreUsuario
     * @return 
     */
    @WebMethod(operationName = "IngresarComentario")
    public String ingresarcomentario(@WebParam(name = "TituloComentario") String TituloComentario,
            @WebParam(name = "ContenidoComentario") String ContenidoComentario,
            @WebParam(name = "nombreUsuario") String nombreUsuario){
            
        Comentario c = new Comentario(TituloComentario, ContenidoComentario, nombreUsuario);
        NuevoComentarioDAO regD = new NuevoComentarioDAO();
        regD.ingresarComentario(c);
        return "Comentario Ingresado";
    }
    
    
    @WebMethod(operationName = "Eliminarcomentario")
    public String eliminarcomentario(@WebParam(name = "TituloComentario") Integer idComentario) {
        Comentario c = new Comentario(idComentario);
        EliminarComentarioDAO eliD = new EliminarComentarioDAO();
        eliD.eliminarComentario(c);
        return "Comentario Eliminado";
    }
    
    @WebMethod(operationName = "ModificarComentario")
    public String modificarComentario(@WebParam(name = "idComentario") Integer idComentario,
            @WebParam(name = "tituloComentario") String tituloComentario,
            @WebParam(name = "ContenidoComentario") String contenidoComentario,
            @WebParam(name = "nombreUsuario") String nombreUsuario) {
        Comentario n = new Comentario(idComentario, tituloComentario, contenidoComentario, nombreUsuario);
        ModificarComentarioDAO modD = new ModificarComentarioDAO();
        modD.modificarComentario(n);
        return "Noticia Modificada";
    }
}

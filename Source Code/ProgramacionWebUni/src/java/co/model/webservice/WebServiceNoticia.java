
package co.model.webservice;

import co.model.pojos.Noticia;
import co.model.noticia.EliminarNoticiaDAO;
import co.model.noticia.IngresarNoticiaDAO;
import co.model.noticia.ModificarNoticiaDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WebServeceNoticias")
public class WebServiceNoticia {

    @WebMethod(operationName = "IngresarNoticia")
    public String ingresarnoticia(@WebParam(name = "tituloNoticia") String tituloNoticia,
            @WebParam(name = "contenido") String contenido,
            @WebParam(name = "url") String url,
            @WebParam(name = "fechaNoticia") String fechaNoticia,
            @WebParam(name = "nombreUsuario") String nombreUsuario) {
        Noticia n = new Noticia( tituloNoticia, contenido, url, fechaNoticia, nombreUsuario);
        IngresarNoticiaDAO regD = new IngresarNoticiaDAO();
        regD.ingresarNoticia(n);
        return "Noticia Ingresada";
    }
    
    @WebMethod(operationName = "eliminarnoticia")
    public String eliminarnoticia(@WebParam(name = "idNoticia") Integer idNoticia) {
        Noticia n = new Noticia(idNoticia);
       EliminarNoticiaDAO eliD = new EliminarNoticiaDAO();
        eliD.eliminarNoticia(n);
        return "Noticia Eliminada";
    }
    
    @WebMethod(operationName = "modificarNoticia")
    public String modificarNoticia(@WebParam(name = "idNoticia") Integer idNoticia,
            @WebParam(name = "tituloNoticia") String tituloNoticia,
            @WebParam(name = "Contenido") String contenido,
            @WebParam(name = "url") String url,
            @WebParam(name = "fechaNoticia") String fechaNoticia,
            @WebParam(name = "nombreUsuario") String nombreUsuario) {
        Noticia n = new Noticia(idNoticia, tituloNoticia, contenido, url,nombreUsuario);
        ModificarNoticiaDAO modD = new ModificarNoticiaDAO();
        modD.modificarNoticia(n);
        return "Noticia Modificada";
    }
}

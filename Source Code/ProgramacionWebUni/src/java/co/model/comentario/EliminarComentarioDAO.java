
package co.model.comentario;

import co.model.dao.HibernateUtil;
import co.model.pojos.Comentario;
import org.hibernate.*;

public class EliminarComentarioDAO {
    
    public void eliminarComentario(Comentario c){
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.delete(c);
            tx.commit();
            session.close();
        }catch(Exception ex){
            tx.rollback();
            throw new RuntimeException("No se pudo Eliminar");
        }
    }
}

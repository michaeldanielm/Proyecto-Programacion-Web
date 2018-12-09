
package co.model.comentario;

import co.model.dao.HibernateUtil;
import co.model.pojos.Comentario;
import org.hibernate.*;

public class NuevoComentarioDAO {
   
    public void ingresarComentario(Comentario c){
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(c);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo Guardar");
        }
    }
}

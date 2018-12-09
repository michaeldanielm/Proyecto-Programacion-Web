package co.model.noticia;

import co.model.dao.HibernateUtil;
import co.model.pojos.Noticia;
import org.hibernate.*;

public class IngresarNoticiaDAO {

    public void ingresarNoticia(Noticia n) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(n);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            tx.rollback();
            throw new RuntimeException("No se pudo Guardar");
        }
    }
}

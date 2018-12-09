
package co.model.usuario;

import co.model.dao.HibernateUtil;
import co.model.pojos.Usuario;
import org.hibernate.*;

public class RegistrarDAO {
     
    public void registrarUsuario(Usuario u){
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(u);
            tx.commit();
            session.close();
        }catch(Exception ex){
            tx.rollback();
            throw new RuntimeException("No se pudo Guardar");
        }
    }
    

}


package co.model.usuario;

import co.model.dao.HibernateUtil;
import co.model.pojos.Usuario;
import org.hibernate.*;

public class UsuariosDAO {
    public void validarUsuario(Usuario u){
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.delete(u);
            tx.commit();
            session.close();
        }catch(Exception ex){
            tx.rollback();
            throw new RuntimeException("No Exite");
        }
    }
}

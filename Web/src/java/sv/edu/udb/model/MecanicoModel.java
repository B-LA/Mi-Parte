/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction; 
import sv.edu.udb.entity.Mecanico;

/**
 *
 * @author neon
 */
public class MecanicoModel {
    
    SessionFactory factory = HibernateUtil.getSessionFactory();

    public int insertarMecanico(Mecanico mec) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(mec);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public List<Mecanico> listarMecanicos() {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT m FROM Mecanico m");
            List<Mecanico> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }

    public Mecanico obtenerMecanico(int id) {
        Session ses = factory.openSession();
        try {
            Mecanico mecen = (Mecanico) ses.get(Mecanico.class, id);
            ses.close();
            return mecen;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
    
    public int modificarMecanico(Mecanico mecent){
        Session ses = factory.openSession();
        try{
            Transaction tran = ses.beginTransaction();
            ses.update(mecent);
            tran.commit();
            ses.close();
            return 1;
        }catch(Exception e){
            ses.close();
            return 0;
        }
    }
    
    public int eliminarMecanico(String id){
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try{
            Mecanico mec = (Mecanico) ses.get(Mecanico.class, id);
            if(mec !=null){
                Transaction tran = ses.beginTransaction();
                ses.delete(mec);
                tran.commit();
                filasAfectadas  = 1;
            }
            ses.close();
            return filasAfectadas;
        }catch(Exception e){
            ses.close();
            return 0;
        }
    }
    
}

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
import sv.edu.udb.entity.Caso;

/**
 *
 * @author neon
 */
public class CasosModel {
    
    SessionFactory factory = HibernateUtil.getSessionFactory();

    public int insertarCaso(Caso cas) {
        Session ses = factory.openSession();
        
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(cas);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            System.out.println("la esepcion" + e.getMessage());
            ses.close();
            return 0;
        }
    }

    public List<Caso> listarCasos() {
        Session ses = factory.openSession();
        try {
            System.out.println("Se ejecuta");
            Query consulta = ses.createQuery("SELECT c FROM Caso c");
            List<Caso> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            System.out.println("la esepcion" + e.getMessage());
            ses.close();
            return null;
        }
    }

    public Caso obtenerCaso(int id) {
        Session ses = factory.openSession();
        try {
            Caso cas = (Caso) ses.get(Caso.class, id);
            ses.close();
            return cas;
        } catch (Exception e) {
            System.out.println("la esepcion" + e.getMessage());
            ses.close();
            return null;
        }
    }
    
    public int modificarCaso(Caso cas){
        Session ses = factory.openSession();
        try{
            Transaction tran = ses.beginTransaction();
            ses.update(cas);
            tran.commit();
            ses.close();
            return 1;
        }catch(Exception e){
             System.out.println("la esepcion" + e.getMessage());
            ses.close();
            return 0;
        }
    }
    
    public int eliminarCaso(int id){
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try{
            Caso cas = (Caso) ses.get(Caso.class, id);
            if(cas !=null){
                Transaction tran = ses.beginTransaction();
                ses.delete(cas);
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

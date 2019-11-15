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
import sv.edu.udb.entity.Gerente;

/**
 *
 * @author neon
 */
public class GerenteModel {
    
    SessionFactory factory = HibernateUtil.getSessionFactory();

    public int insertarGerente(Gerente gen) {
        Session ses = factory.openSession();
        
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(gen);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            System.out.println("la esepcion" + e.getMessage());
            ses.close();
            return 0;
        }
    }

    public List<Gerente> listarGerentes() {
        Session ses = factory.openSession();
        try {
            System.out.println("Se ejecuta");
            Query consulta = ses.createQuery("SELECT c FROM Gerente c");
            List<Gerente> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            System.out.println("la esepcion" + e.getMessage());
            ses.close();
            return null;
        }
    }

    public Gerente obtenerGerente(int id) {
        Session ses = factory.openSession();
        try {
            Gerente gen = (Gerente) ses.get(Gerente.class, id);
            ses.close();
            return gen;
        } catch (Exception e) {
            System.out.println("la esepcion" + e.getMessage());
            ses.close();
            return null;
        }
    }
    
    public int modificarGerente(Gerente gen){
        Session ses = factory.openSession();
        try{
            Transaction tran = ses.beginTransaction();
            ses.update(gen);
            tran.commit();
            ses.close();
            return 1;
        }catch(Exception e){
             System.out.println("la esepcion" + e.getMessage());
            ses.close();
            return 0;
        }
    }
    
    public int eliminarGerente(int id){
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try{
            Gerente gen = (Gerente) ses.get(Gerente.class, id);
            if(gen !=null){
                Transaction tran = ses.beginTransaction();
                ses.delete(gen);
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

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
import sv.edu.udb.entity.Vehiculo;

/**
 *
 * @author neon
 */
public class VehiculoModel {
    
    SessionFactory factory = HibernateUtil.getSessionFactory();

    public int insertarVehiculo(Vehiculo veh) {
        Session ses = factory.openSession();
        
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(veh);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            System.out.println("la esepcion" + e.getMessage());
            ses.close();
            return 0;
        }
    }

    public List<Vehiculo> listarVehiculos() {
        Session ses = factory.openSession();
        try {
            System.out.println("Se ejecuta");
            Query consulta = ses.createQuery("SELECT v FROM Vehiculo v");
            List<Vehiculo> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            System.out.println("la esepcion" + e.getMessage());
            ses.close();
            return null;
        }
    }

    public Vehiculo obtenerVehiculo(int id) {
        Session ses = factory.openSession();
        try {
            Vehiculo vehen = (Vehiculo) ses.get(Vehiculo.class, id);
            ses.close();
            return vehen;
        } catch (Exception e) {
            System.out.println("la esepcion" + e.getMessage());
            ses.close();
            return null;
        }
    }
    
    public int modificarVehiculo(Vehiculo veh){
        Session ses = factory.openSession();
        try{
            Transaction tran = ses.beginTransaction();
            ses.update(veh);
            tran.commit();
            ses.close();
            return 1;
        }catch(Exception e){
             System.out.println("la esepcion" + e.getMessage());
            ses.close();
            return 0;
        }
    }
    
    public int eliminarVehiculo(int id){
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try{
            Vehiculo veh = (Vehiculo) ses.get(Vehiculo.class, id);
            if(veh !=null){
                Transaction tran = ses.beginTransaction();
                ses.delete(veh);
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

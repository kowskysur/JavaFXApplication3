/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kappia.dao;

import java.util.List;
import kappia.entidades.Cliente;
import kappia.entidades.Plan;
import kappia.utilidades.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario pc
 */
public class PlanDAO {
    
    /**
     * Almacena un plan en base de datos
     * @param plan 
     */
    public void savePlan(Plan plan) {
        
        Transaction transaction = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the plan object
            session.save(plan);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    
    /**
     * Obtiene todos los planes en base de datos
     * @return 
     */
    public List <Plan> getPlanes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Plan", Plan.class).list();
        }
    }
    
}

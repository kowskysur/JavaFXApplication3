/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kappia.dao;

import java.util.List;
import kappia.entidades.Cliente;
import kappia.utilidades.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kowskysur
 */

public class ClienteDAO {
    
    /**
     * Almacena un cliente en base de datos
     * @param cliente 
     */
    public void saveCliente(Cliente cliente) {
        Transaction transaction = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the cliente object
            session.save(cliente);
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
     * Obtiene todos los clientes en base de datos
     * @return 
     */
    public List <Cliente> getClientes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Cliente", Cliente.class).list();
        }
    }
}
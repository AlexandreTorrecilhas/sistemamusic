package org.example.fabrica;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;

public class JPAUtil {
    static private String persistenceName = "projetomusica";
    static private EntityManagerFactory fabrica;
    static private EntityManager em;

    public static EntityManager getConexao(){
        if(fabrica == null || !fabrica.isOpen()){
            fabrica = Persistence.createEntityManagerFactory(persistenceName);
        }

        if(em == null || !em.isOpen()){
            em = fabrica.createEntityManager();
        }
        return em;
    }

    public static void fecharFabrica(){
        fabrica.close();
    }
}

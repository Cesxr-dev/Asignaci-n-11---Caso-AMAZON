/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemaamazon;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author demib
 */
public class SistemaAmazon {

    public static void main(String[] args) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaAmazonPU");
        EntityManager em = emf.createEntityManager();
    }
}

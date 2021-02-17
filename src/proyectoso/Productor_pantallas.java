/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoso;

import java.util.concurrent.Semaphore;
/**
 *
 * @author leonp
 */
public class Productor_pantallas extends Thread {
    Semaphore mutex;
    private int almacen_pantallas = 40;
    private int productores_pantallas = 1;

    public Productor_pantallas(Semaphore mutex) {
    this.mutex = mutex; 
    }
    
    
    
    public void run_pantallas(){
        
        try {
            
            this.mutex.acquire();
            
            this.mutex.release();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Getters & Setters

    public int getAlmacen_pantallas() {
        return almacen_pantallas;
    }

    public void setAlmacen_pantallas(int almacen_pantallas) {
        this.almacen_pantallas = almacen_pantallas;
    }

    public int getProductores_pantallas() {
        return productores_pantallas;
    }

    public void setProductores_pantallas(int productores_pantallas) {
        this.productores_pantallas = productores_pantallas;
    }
    
    
    
    
}

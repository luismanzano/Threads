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
public class Productor_SD extends Thread {
    Semaphore mutex;
    private int almacen_SD = 15;
    private int productores_SD = 1;

    public Productor_SD(Semaphore mutex) {
    this.mutex = mutex;
    }
    
    
    
    public void run(){
        
        try {
            
            this.mutex.acquire();
            
            this.mutex.release();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Getters & Setters 

    public int getAlmacen_SD() {
        return almacen_SD;
    }

    public void setAlmacen_SD(int almacen_SD) {
        this.almacen_SD = almacen_SD;
    }

    public int getProductores_SD() {
        return productores_SD;
    }

    public void setProductores_SD(int productores_SD) {
        this.productores_SD = productores_SD;
    }
    
    

}

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
public class Productor_joysticks extends Thread{
    Semaphore mutex;
    private int almacen_joysticks = 20;
    private int productores_joystickis = 1;

    public Productor_joysticks(Semaphore mutex) {
    this.mutex = mutex;
    }
    
    
    
    public void run_joysticks(){
        
        try {
            
            this.mutex.acquire();
            
            this.mutex.release();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Getters & Setters 

    public int getAlmacen_joysticks() {
        return almacen_joysticks;
    }

    public void setAlmacen_joysticks(int almacen_joysticks) {
        this.almacen_joysticks = almacen_joysticks;
    }

    public int getProductores_joystickis() {
        return productores_joystickis;
    }

    public void setProductores_joystickis(int productores_joystickis) {
        this.productores_joystickis = productores_joystickis;
    }
    
    

}

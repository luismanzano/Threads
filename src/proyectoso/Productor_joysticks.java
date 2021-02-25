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
    Semaphore mutex, semJoysticks, semEnsambladorJoysticks;
    public static volatile int almacen_joysticks = 20;
    public static volatile int productores_joysticks = 2;
    public static volatile int joysticks = 0;
    private final int max_productores_joysticks = 4;

    public Productor_joysticks(Semaphore mutex, Semaphore semJoysticks, Semaphore semEnsambladorJoysticks) {
    this.mutex = mutex;
    this.semJoysticks = semJoysticks;
    this.semEnsambladorJoysticks = semEnsambladorJoysticks;
    }

    public Productor_joysticks() {
    }
    
    
    
    public void run(){
        while(true){
            try {
                if(almacen_joysticks > 0){
                this.semJoysticks.acquire();
                this.mutex.acquire();
                almacen_joysticks --;
                joysticks ++;
                    System.out.println("JOYSTICK");
                PanelControl.setEstadisticasJoysticks(Integer.toString(joysticks), Integer.toString(almacen_joysticks));
                this.semEnsambladorJoysticks.release();
                this.mutex.release();
                }
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static boolean consumir() {
        almacen_joysticks += 2;
        joysticks -= 2;
        
        PanelControl.setEstadisticasJoysticks(Integer.toString(joysticks), Integer.toString(almacen_joysticks));
        
        return true;
    }
    
//     Getters & Setters 
//
//    public int getAlmacen_joysticks() {
//        return almacen_joysticks;
//    }
//
//    public void setAlmacen_joysticks(int almacen_joysticks) {
//        this.almacen_joysticks = almacen_joysticks;
//    }
//
//    public int getProductores_joystickis() {
//        return productores_joystickis;
//    }
//
//    public void setProductores_joystickis(int productores_joystickis) {
//        this.productores_joystickis = productores_joystickis;
//    }
//
//    public int getJoysticks() {
//        return joysticks;
//    }
//
//    public void setJoysticks(int joysticks) {
//        this.joysticks = joysticks;
//    }
//    

    public int getMax_productores_joysticks() {
        return max_productores_joysticks;
    }
    

}

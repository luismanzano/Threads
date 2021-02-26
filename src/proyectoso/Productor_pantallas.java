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
    Semaphore mutex, semPantalla, semEnsambladorPantallaNormal, semEnsambladorPantallaTactil;
    public static volatile int almacen_pantallas = 40;
    public static volatile int pantallas_normales = 0;
    public static volatile int pantallas_tactiles = 0; 
    public static volatile int productores_pantallas = 3;
    public static int max_productores_pantallas = 5;

    public Productor_pantallas(Semaphore mutex, Semaphore semPantalla, Semaphore semEnsambladorPantallaNormal, Semaphore semEnsambladorPantallaTactil) {
    this.mutex = mutex; 
    this.semPantalla = semPantalla;
    this.semEnsambladorPantallaNormal = semEnsambladorPantallaNormal;
    this.semEnsambladorPantallaTactil = semEnsambladorPantallaTactil;
    }

    public Productor_pantallas() {
    }
    
    
    
    public void run(){
        while(true){
            try {
                //Pantalla normal
                if(almacen_pantallas > 0){
                this.semPantalla.acquire();
                Thread.sleep(1000);
                this.mutex.acquire();
                almacen_pantallas --;
                pantallas_normales ++;
                PanelControl.setEstadisticaPantallaNormal(Integer.toString(pantallas_normales), Integer.toString(almacen_pantallas));
                this.mutex.release();
                this.semEnsambladorPantallaNormal.release();
                }
                //Pantalla tactil
                if(almacen_pantallas > 0){
                this.semPantalla.acquire();
                Thread.sleep(2000);
                this.mutex.acquire();
                almacen_pantallas --;
                pantallas_tactiles ++;
                PanelControl.setEstadisticaPantallaTactil(Integer.toString(pantallas_tactiles), Integer.toString(almacen_pantallas));
                this.mutex.release();
                this.semEnsambladorPantallaTactil.release();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }    
    }
    
    public static boolean consumirPantallaTactil(){
        almacen_pantallas += 1;
        pantallas_tactiles -= 1;
        
        PanelControl.setEstadisticaPantallaTactil(Integer.toString(pantallas_tactiles), Integer.toString(almacen_pantallas));
        
        return true;
    }
    
    public static boolean consumirPantallaNormal(){
        almacen_pantallas += 1;
        pantallas_normales -= 1;
        
        PanelControl.setEstadisticaPantallaNormal(Integer.toString(pantallas_normales), Integer.toString(almacen_pantallas));
        
        return true;
    }
    
//     Getters & Setters
//
//    public int getAlmacen_pantallas() {
//        return almacen_pantallas;
//    }
//
//    public void setAlmacen_pantallas(int almacen_pantallas) {
//        this.almacen_pantallas = almacen_pantallas;
//    }
//
//    public int getProductores_pantallas() {
//        return productores_pantallas;
//    }
//
//    public void setProductores_pantallas(int productores_pantallas) {
//        this.productores_pantallas = productores_pantallas;
//    }
//
//    public int getPantallas_normales() {
//        return pantallas_normales;
//    }
//
//    public void setPantallas_normales(int pantallas_normales) {
//        this.pantallas_normales = pantallas_normales;
//    }
//
//    public int getPantallas_tactiles() {
//        return pantallas_tactiles;
//    }
//
//    public void setPantallas_tactiles(int pantallas_tactiles) {
//        this.pantallas_tactiles = pantallas_tactiles;
//    }

    public int getMax_productores_pantallas() {
        return max_productores_pantallas;
    }
    
}

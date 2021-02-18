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
    Semaphore mutex, semSD, semEnsambladorSD;
    public static volatile int almacen_SD = 15;
    public static volatile int productores_SD = 1;
    public static volatile int SD = 0;
    
    public Productor_SD(Semaphore mutex, Semaphore semSD, Semaphore semEnsambladorSD ) {
    this.mutex = mutex;
    this.semSD = semSD;
    this.semEnsambladorSD = semEnsambladorSD;
    }

    public Productor_SD() {
    }
    
    
    public void run(){
        while(true){
            
            try {
                if(almacen_SD > 0){
                    this.semSD.acquire();
                    this.mutex.acquire();
                    SD ++;
                    almacen_SD --;
                    PanelControl.setEstadisticasSD(Integer.toString(SD), Integer.toString(almacen_SD));
                    this.semEnsambladorSD.release();
                    this.mutex.release();
                    Thread.sleep(3000);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
//     Getters & Setters 
//
//    public int getAlmacen_SD() {
//        return almacen_SD;
//    }
//
//    public void setAlmacen_SD(int almacen_SD) {
//        this.almacen_SD = almacen_SD;
//    }
//
//    public int getProductores_SD() {
//        return productores_SD;
//    }
//
//    public void setProductores_SD(int productores_SD) {
//        this.productores_SD = productores_SD;
//    }
//
//    public int getSD() {
//        return SD;
//    }
//
//    public void setSD(int SD) {
//        this.SD = SD;
//    }
}

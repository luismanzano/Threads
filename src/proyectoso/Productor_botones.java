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
public class Productor_botones extends Thread {
    Semaphore mutex, semBoton, semEnsamblarBoton;
    public static volatile int almacen_botones = 45; // Capacidad máx de almacenamiento
    public static volatile int botones = 0;
    public static volatile int productores_botones = 2; // Valor inicial, se debe poder indicar de manera dinamica
    private final int max_productores_botones  = 3;
    
    public Productor_botones(Semaphore mutex, Semaphore semBoton, Semaphore semEnsamblador){ // Constructor
        this.mutex = mutex;
        this.semBoton = semBoton;
        this.semEnsamblarBoton = semEnsamblador;
    }

    public Productor_botones() {
    }
    
    
    
    public void run(){ // Método para correr hilos 
        
        while(true){
            try {
                if(almacen_botones > 0){ // Si hay espacio en el almacen
                    
                    if(almacen_botones > 1){ // Si hay mas de 1 espacio en el almacen
                        this.semBoton.acquire(2);
                        Thread.sleep(1000); // Tiempo que debe esperar el hilo antes de poder volver a ejecutarse 
                        this.mutex.acquire(); // Disminuye el valor del semáforo, el es quien puede ejecutarse ahora 
                        almacen_botones -=2; // Reduzco espacio del almacen
                        botones+=2; // Creo boton
                        PanelControl.setEstadisticaBotones(Integer.toString(botones),Integer.toString(almacen_botones));
                        this.mutex.release(); // Aumenta el valor del semáforo, suelta su prioridad para ejecutarse
                        this.semEnsamblarBoton.release(2);
                    }else if (almacen_botones > 0){
                        this.semBoton.acquire();
                        Thread.sleep(1000);
                        this.mutex.acquire();
                        almacen_botones --;
                        botones++;
                        PanelControl.setEstadisticaBotones(Integer.toString(botones),Integer.toString(almacen_botones));
                        this.mutex.release();
                        this.semEnsamblarBoton.release();
                    }
                    
                }
            Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        
        
           
    }
    
    public static boolean consumir(){
            botones -= 5;
            almacen_botones += 5;
            
            PanelControl.setEstadisticaBotones(Integer.toString(botones),Integer.toString(almacen_botones));
            
            return true;
    }
    
//    Getters & Setters
//
//    public int getAlmacen_botones() {
//        return almacen_botones;
//    }
//
//    public void setAlmacen_botones(int almacen_botones) {
//        this.almacen_botones = almacen_botones;
//    }
//    
//    public int getProductores_botones(){
//        return productores_botones;
//    }
//    
//    public void setProductores_botones(int productores_botones){
//        this.productores_botones = productores_botones;
//    }
//
//    public int getBotones() {
//        return botones;
//    }
//
//    public void setBotones(int botones) {
//        this.botones = botones;
//    }

    public int getMax_productores_botones() {
        return max_productores_botones;
    }
}

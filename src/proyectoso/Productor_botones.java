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
    Semaphore mutex;
    private int almacen_botones = 45; // Capacidad máx de almacenamiento
    private int productores_botones = 1; // Valor inicial, se debe poder indicar de manera dinamica
    
    public Productor_botones(Semaphore mutex){ // Constructor
        this.mutex = mutex;
    }
    
    public void run(){ // Método para correr hilos 
        
        while(true){
            try {
            
            this.mutex.acquire(); // Disminuye el valor del semáforo, el es quien puede ejecutarse ahora 
                System.out.println("Estoy funcionando 2");
            /* Aquí va nuestro código */
                PanelControl.cantidad_botones++;
                System.out.println(PanelControl.cantidad_botones);
            
           

            this.mutex.release(); // Aumenta el valor del semáforo, suelta su prioridad para ejecutarse
            Thread.sleep(500); // Tiempo que debe esperar el hilo antes de poder volver a ejecutarse 
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        }
        
        
           
    }
    
    // Getters & Setters

    public int getAlmacen_botones() {
        return almacen_botones;
    }

    public void setAlmacen_botones(int almacen_botones) {
        this.almacen_botones = almacen_botones;
    }
    
    public int getProductores_botones(){
        return productores_botones;
    }
    
    public void setProductores_botones(int productores_botones){
        this.productores_botones = productores_botones;
    }
}

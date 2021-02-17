/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoso;

import java.util.concurrent.Semaphore;
import javax.swing.JLabel;

/**
 *
 * @author luismanzano
 */

/*EL TRHEAD QUE SE ENCARGA DE ACTUALIZAR LOS LABELS (AUN NO ESTA FUNCIONANDO NO SE POR QUE)*/
public class Refresher extends Thread{
    Semaphore mutex;
    
    public Refresher(Semaphore mutex){ // Constructor
        this.mutex = mutex;
    }
    
    public void run(){ // Método para correr hilos 
        
        while(true) {
            try {
            
            this.mutex.acquire(); // Disminuye el valor del semáforo, el es quien puede ejecutarse ahora 
            System.out.println("Estoy funcionando 111");
            /* Aquí va nuestro código */
            String cantidadBotones;
            
            cantidadBotones = String.valueOf(PanelControl.cantidad_botones);
            //PanelControl.setCantBotonesText(String.valueOf(PanelControl.cantidad_botones));
                System.out.println(PanelControl.cantidad_botones);
                
            this.mutex.release(); // Aumenta el valor del semáforo, suelta su prioridad para ejecutarse
            Thread.sleep(100);// Tiempo que debe esperar el hilo antes de poder volver a ejecutarse 

             
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        }
        
           
    }
    
    public void refresh(int cantidadBotones){
        String cb = String.valueOf(cantidadBotones);
        PanelControl.setCantBotonesText(cb);
    }
}
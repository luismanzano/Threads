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
public class Gerente extends Thread{
    Semaphore mutex2;
    private int dia;
    
    Gerente(Semaphore mutex2, int dia) {
        this.mutex2 = mutex2;
        this.dia = dia;
    }
    
    
        public void run(){ // Método para correr hilos 
        
        while(true){
            try {
                // Duerme 1/4 de lo que dura el dia para que la unidad valga 6 horas
                PanelControl.setStatusJefe("Dormido");
                PanelControl.setStatusGerente("Despierto");
                System.out.println("Cambio status gerente");
                this.mutex2.acquire();
                
                Controlador.contador_global --;
                if (Controlador.dias_restantes == 0) {
                    Controlador.dias_restantes = Controlador.ciclo_dias;
                } else {
                    
                }
                //PanelControl.setStatusGerente("Dormido");
                System.out.println("Cambio status gerente");
                this.mutex2.release();
                Thread.sleep(this.dia/12);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        
        
           
    }
    
}

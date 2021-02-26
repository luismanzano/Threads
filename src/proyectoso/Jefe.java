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
public class Jefe extends Thread{
    Semaphore mutex, mutex2;
    private int dia;
    private int corridas = 4; //Uy si que sabroso, muchas corridas

    public Jefe(Semaphore mutex, Semaphore mutex2, int dia) {
        this.mutex = mutex;
        this.mutex2 = mutex2;
        this.dia = dia;
    }
    
    
        public void run(){ // Método para correr hilos 
        
        while(true){
            try {
                // Duerme 1/4 de lo que dura el dia para que la unidad valga 6 horas
                this.mutex2.acquire();
                Controlador.contador_global --;
                if (this.corridas==0) {
                    this.corridas = 4;
                    Controlador.dias_restantes--;
                    System.out.println("Ya paso un dias!!!!" + " " + Controlador.dias_restantes);
                    PanelControl.setEstadisticaDiasRestantes(String.valueOf(Controlador.dias_restantes));
                } else {
                    this.corridas--;
                    System.out.println("Las corridas que quedan " + this.corridas);
                }
                this.mutex2.release();
                Thread.sleep((this.dia)/4);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        
        
           
    }
    
}

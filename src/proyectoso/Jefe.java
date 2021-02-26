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
    Semaphore mutex2;
    
    
    public void run(){
        while (true){
            try {
                Thread.sleep(LeerTxt.getMsDias()/4); // Duerme 1/4 de lo que dura el dia para que la unidad valga 6 horas
                this.mutex2.acquire();
                Controlador.contador_global --;
                this.mutex2.release();
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
}

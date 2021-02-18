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
public class Ensamblador extends Thread {
    Semaphore mutex;
    private int consolas_listas = 0;
    private int ensambladores = 1;

    public Ensamblador(Semaphore mutex) {
    this.mutex = mutex;
    }
    
    
    
    public void run(){
        
        try {
            
            this.mutex.acquire();
            
            this.mutex.release();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Getters & Setters

    public int getConsolas_listas() {
        return consolas_listas;
    }

    public void setConsolas_listas(int consolas_listas) {
        this.consolas_listas = consolas_listas;
    }

    public int getEnsambladores() {
        return ensambladores;
    }

    public void setEnsambladores(int ensambladores) {
        this.ensambladores = ensambladores;
    }
    
    
    
}

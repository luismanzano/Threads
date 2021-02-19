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
    //COLOCAMOS TODOS LOS SEMAFOROS
    Semaphore mutex, semEnsambladorBoton, semEnsambladorPantallaNormal, semEnsambladorPantallaTactil, semEnsambladorJoysticks, semEnsambladorSD;
    
    
    public static volatile int consolas_listas = 0;
    public static volatile int ensambladores = 1;
    
    //COLOCAMOS LOS PRODUCTORES PARA PODER ACCESAR A ELLOS
    
    Productor_botones productor_botones;
    public static boolean tengo_botones;
    
    Productor_pantallas productor_pantallas;
    public static boolean tengo_pantalla_tactil;
    public static boolean tengo_pantalla_normal;
    
    Productor_SD productor_SD;
    public static boolean tengo_SD;
    
    Productor_joysticks productor_joystick;
    public static boolean tengo_joysticks;
    
    
    

    public Ensamblador(Semaphore mutex, Semaphore semEnsambladorBoton, Semaphore semEnsambladorPantallaNormal, Semaphore semEnsambladorPantallaTactil, Semaphore semEnsambladorJoysticks, Semaphore semEnsambladorSD) {
    this.mutex = mutex;
    this.semEnsambladorBoton = semEnsambladorBoton;
    this.semEnsambladorPantallaNormal = semEnsambladorPantallaNormal;
    this.semEnsambladorPantallaTactil = semEnsambladorPantallaTactil;
    this.semEnsambladorJoysticks = semEnsambladorJoysticks;
    this.semEnsambladorSD = semEnsambladorSD;
    }
    
    
    
    public void run(){
        
        try {
            
            while(true){
                
                //colocamos todos los semaforos
                this.mutex.acquire();
               
                //
                 this.semEnsambladorBoton.acquire();
                if(Productor_botones.botones <= 5){ //AGARRAR BOTONES
                //wait(); 
                    System.out.println("esperando por que hayan mas de 5 botones");
                    
                    } else {
                    System.out.println("ya tengo los botones");
                   consumirBotones();
                   //consumi botones
                   //this.semEnsambladorBoton.release();
                    }
     
                //AHORA LAS PANTALLAS Normal
                this.semEnsambladorPantallaNormal.acquire();
                if(Productor_pantallas.pantallas_normales < 1){ //AGARRAR PANTALLAS
                //wait();
                    System.out.println("Esperando por las pantallas normales");
                    
                    } else {
                    System.out.println("ya tengo las pantallas normales");
                   consumirPantallaNormal();
                   //this.semEnsambladorPantallaNormal.release();
                    }
                
                //AHORA LAS PANTALLAS TACTILES
                this.semEnsambladorPantallaTactil.acquire();
                if(Productor_pantallas.pantallas_tactiles < 1){ //AGARRAR PANTALLAS
                    System.out.println("esperando por la pantalla tactil");
                //wait();
                    } else {
                   consumirPantallaTactil();
                    System.out.println("Ya tengo la pantalla tactil");
                   //this.semEnsambladorPantallaTactil.release();
                    }
                
                 //AHORA LAS LECTOR SD
                 this.semEnsambladorSD.acquire();
                if(Productor_SD.SD < 1){ //AGARRAR SD
                //wait();
                    System.out.println("Esperando por SD");
                    } else {
                    System.out.println("Ya tengo SD");
                   consumirSD();
                   //this.semEnsambladorSD.release();
                    }
                
                //AHORA JOYSTICKS
                this.semEnsambladorJoysticks.acquire();
                if(Productor_joysticks.joysticks < 2){ //AGARRAR JOYSTICKS
               // wait();
                    } else {
                   consumirJoysticks();
                   //this.semEnsambladorJoysticks.release();
                    }
            
            
            
            
            //CON ESTE CODIGO VERIFICAMOS SI TENEMOS TODOS LOS COMPONENTES PARA PRODUCIR UNA CONSOLA
            if(this.tengo_botones && this.tengo_pantalla_tactil && this.tengo_pantalla_normal && this.tengo_SD && this.tengo_joysticks){
                this.consolas_listas += 1;
                PanelControl.setEstadisticaConsolas(Integer.toString(consolas_listas));
                this.mutex.release();
                Thread.sleep(1000);
            } else {
                //this.mutex.release();
            }
            }
            
            
        } catch (Exception e) {
            System.out.println("Ocurrio un problema ensamblando");
            System.out.println(e);
        }
    }
    
    public static void consumirBotones(){ //El metodo que se encarga de sacar del almacen y hacer la vaina 
       tengo_botones = Productor_botones.consumir();
    }
    
    public void consumirPantallaNormal(){
        tengo_pantalla_normal = Productor_pantallas.consumirPantallaNormal();
    }
    
    public void consumirPantallaTactil(){
         tengo_pantalla_tactil = Productor_pantallas.consumirPantallaTactil();
    }
    
    public void consumirSD(){
        tengo_SD = Productor_SD.consumir();
    }
    
    public void consumirJoysticks(){
        tengo_joysticks = Productor_joysticks.consumir();
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

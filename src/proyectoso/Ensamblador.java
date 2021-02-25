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
    Semaphore semBoton, semPantallas, semJoysticks, semSD;
    
    
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
    
    
    

    public Ensamblador(Semaphore mutex, Semaphore semEnsambladorBoton, Semaphore semEnsambladorPantallaNormal, Semaphore semEnsambladorPantallaTactil, Semaphore semEnsambladorJoysticks, Semaphore semEnsambladorSD,
                       Semaphore semBoton, Semaphore semPantallas, Semaphore semJoysticks, Semaphore semSD) {
    this.mutex = mutex;
    this.semEnsambladorBoton = semEnsambladorBoton;
    this.semEnsambladorPantallaNormal = semEnsambladorPantallaNormal;
    this.semEnsambladorPantallaTactil = semEnsambladorPantallaTactil;
    this.semEnsambladorJoysticks = semEnsambladorJoysticks;
    this.semEnsambladorSD = semEnsambladorSD;
    this.semBoton = semBoton;
    this.semPantallas = semPantallas;
    this.semJoysticks = semJoysticks;
    this.semSD = semSD;
    }
    
    
    
    public void run(){
        
        try {
            
            while(true){
                
                //colocamos todos los semaforos
   
                System.out.println("ENSAMBLADOR ACTIVEICHON");
                
                //EL BIG IF DE LEO
                if(Productor_botones.botones >= 5 /*&& Productor_pantallas.pantallas_normales >= 1 && Productor_pantallas.pantallas_tactiles >=1 && Productor_SD.SD >= 1 && Productor_SD.SD < 1*/){
                    System.out.println("EL BIG IF DE LEO");
                     this.semEnsambladorBoton.acquire();
                     this.semEnsambladorBoton.acquire();
                     this.semEnsambladorBoton.acquire();
                     this.semEnsambladorBoton.acquire();
                     this.semEnsambladorBoton.acquire();
                if(Productor_botones.botones <= 5){ //AGARRAR BOTONES
                //wait(); 
                    System.out.println("esperando por que hayan mas de 5 botones");
                    
                    } else {
                    mutex.acquire();
                    System.out.println("ya tengo los botones");
                   consumirBotones();
                   
                   try{
                       semBoton.release();
                   } catch(Exception e){
                       System.out.println("Problema haciendo el acquire");
                       System.out.println(e);
                   }
                   
                    System.out.println("Se hizo el release de semboton");
                   semBoton.release();
                   semBoton.release();
                   semBoton.release();
                   semBoton.release();
                   mutex.release();
                   //consumi botones
                   //this.semEnsambladorBoton.release();
                    }
     
                //AHORA LAS PANTALLAS Normal
                this.semEnsambladorPantallaNormal.acquire();
                if(Productor_pantallas.pantallas_normales < 1){ //AGARRAR PANTALLAS
                //wait();
                    System.out.println("Esperando por las pantallas normales");
                    
                    } else {
                    this.mutex.acquire();
                    System.out.println("ya tengo las pantallas normales");
                    consumirPantallaNormal();
                    semPantallas.release();
                    this.mutex.release();
                   //this.semEnsambladorPantallaNormal.release();
                    }
                
                //AHORA LAS PANTALLAS TACTILES
                this.semEnsambladorPantallaTactil.acquire();  //POR ALGUNA RAZON SE DESTRABA SI QUITO EL ACQUIRE
                if(Productor_pantallas.pantallas_tactiles <1){ //AGARRAR PANTALLAS
                    System.out.println("esperando por la pantalla tactil");
                //wait();
                    } else {
                    this.mutex.acquire();
                    System.out.println("Ya tengo la pantalla tactil");
                    consumirPantallaTactil();
                    semPantallas.release();
                    this.mutex.release();
                   //this.semEnsambladorPantallaTactil.release();
                    }
                
                 //AHORA LAS LECTOR SD
                 this.semEnsambladorSD.acquire();
                if(Productor_SD.SD < 1){ //AGARRAR SD
                //wait();
                    System.out.println("Esperando por SD");
                    } else {
                    this.mutex.acquire();
                    System.out.println("Ya tengo SD");
                   consumirSD();
                   semSD.release();
                   this.mutex.release();
                   //this.semEnsambladorSD.release();
                    }
                
                //AHORA JOYSTICKS
                this.semEnsambladorJoysticks.acquire();
                if(Productor_joysticks.joysticks < 2){ //AGARRAR JOYSTICKS
                    System.out.println("Esperando por los Joysticks");
               // wait();
                    } else {
                    this.mutex.acquire();
                   System.out.println("Ya tengo los joysticks");
                    consumirJoysticks();
                    this.semJoysticks.release();
                    this.mutex.release();
                   //this.semEnsambladorJoysticks.release();
                    }
            
            
            
            
            //CON ESTE CODIGO VERIFICAMOS SI TENEMOS TODOS LOS COMPONENTES PARA PRODUCIR UNA CONSOLA
                    System.out.println("afuera de las consolas");
            if(this.tengo_botones && this.tengo_pantalla_tactil && this.tengo_pantalla_normal && this.tengo_SD && this.tengo_joysticks){
                System.out.println("ensamblando las consolas");
                this.consolas_listas += 1;
                PanelControl.setEstadisticaConsolas(Integer.toString(this.consolas_listas));
                System.out.println("Actualizado");
                Thread.sleep(1000);
            } else {
//                this.mutex.release();
//                Thread.sleep(200);
            }
            }
                }
               
                //FIN BIG IF DE LEO 
                
            
            
        } catch (Exception e) {
            System.out.println("Ocurrio un problema ensamblando");
            System.out.println(e);
        }
    }
    
    public static void consumirBotones(){ //El metodo que se encarga de sacar del almacen y hacer la vaina 
       tengo_botones = Productor_botones.consumir();
        System.out.println("efectivamente estan los botones");
    }
    
    public void consumirPantallaNormal(){
        tengo_pantalla_normal = Productor_pantallas.consumirPantallaNormal();
        System.out.println("efectivamente tengo las pantallas");
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

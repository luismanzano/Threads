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
    int duracion_dia;
    
    
    public static volatile int consolas_listas = 0;
    public static volatile int ensambladores = 1;
    private final int max_ensambladores = 5;
    
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
                       Semaphore semBoton, Semaphore semPantallas, Semaphore semJoysticks, Semaphore semSD, int duracion_dia) {
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
    this.duracion_dia = duracion_dia;
    }

    public Ensamblador() {
    }
    
    
    
    public void run(){
        
        try {
            
            while(true){
                
                System.out.println("Entrendado al ENSAMBLADOR ");
                
                
                this.semEnsambladorBoton.acquire(5);
                if(Productor_botones.botones <= 5){ //AGARRAR BOTONES
                     System.out.println("esperando por que hayan mas de 5 botones");
                    
                    } else {
                    mutex.acquire();
                   System.out.println("ya tengo los botones " + Productor_botones.botones);
                   consumirBotones();
                   mutex.release();
                   semBoton.release(5);
                   }
     
                //AHORA LAS PANTALLAS Normal
                this.semEnsambladorPantallaNormal.acquire();
                if(Productor_pantallas.pantallas_normales <= 1){ //AGARRAR PANTALLAS
                    System.out.println("Esperando por las pantallas normales");
                    
                    } else {
                    this.mutex.acquire();
                    System.out.println("ya tengo las pantallas normales " + Productor_pantallas.pantallas_normales);
                    consumirPantallaNormal();
                    this.mutex.release();
                    semPantallas.release();
                   }
                
                //AHORA LAS PANTALLAS TACTILES
                this.semEnsambladorPantallaTactil.acquire();  //POR ALGUNA RAZON SE DESTRABA SI QUITO EL ACQUIRE
                if(Productor_pantallas.pantallas_tactiles <1){ //AGARRAR PANTALLAS
                    System.out.println("esperando por la pantalla tactil");
                } else {
                    this.mutex.acquire();
                    System.out.println("Ya tengo la pantalla tactil " + Productor_pantallas.pantallas_tactiles);
                    consumirPantallaTactil();
                    this.mutex.release();
                    semPantallas.release();
                   //this.semEnsambladorPantallaTactil.release();
                    }
                
                 //AHORA LAS LECTOR SD
                 this.semEnsambladorSD.acquire();
                if(Productor_SD.SD < 1){ //AGARRAR SD
                    System.out.println("Esperando por SD");
                } else {
                    this.mutex.acquire();
                    System.out.println("Ya tengo SD " + Productor_SD.SD);
                   consumirSD();
                   this.mutex.release();
                   semSD.release();
               }
                
                //AHORA JOYSTICKS
                this.semEnsambladorJoysticks.acquire(2);
                if(Productor_joysticks.joysticks < 2){ //AGARRAR JOYSTICKS
                    System.out.println("Esperando por los Joysticks");
                } else {
                    this.mutex.acquire();
                   System.out.println("Ya tengo los joysticks " + Productor_joysticks.joysticks);
                    consumirJoysticks();
                    this.mutex.release();
                    this.semJoysticks.release(2);
               }
            
            
            
            
            //CON ESTE CODIGO VERIFICAMOS SI TENEMOS TODOS LOS COMPONENTES PARA PRODUCIR UNA CONSOLA
                    System.out.println("afuera de las consolas");
            if(this.tengo_botones && this.tengo_pantalla_tactil && this.tengo_pantalla_normal && this.tengo_SD && this.tengo_joysticks){
                System.out.println("ensamblando las consolas");
                this.consolas_listas += 1;
                PanelControl.setEstadisticaConsolas(Integer.toString(this.consolas_listas));
                System.out.println("Actualizado");
                Thread.sleep(this.duracion_dia);
            } else {
            
            }
                Thread.sleep(this.duracion_dia);
                }
               
               
            
            
        } catch (Exception e) {
            System.out.println("Ocurrio un problema ensamblando" + e);
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

    public int getMax_ensambladores() {
        return max_ensambladores;
    }
    
    
    
}

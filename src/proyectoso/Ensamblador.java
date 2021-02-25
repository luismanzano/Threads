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
                System.out.println("Ensamblador" +
                        "\n Botones disponibles " + Productor_botones.botones +
                        "\n Pantallas normales disponibles " + Productor_pantallas.pantallas_normales + 
                        "\n Pantallas tactiles disponibles " + Productor_pantallas.pantallas_tactiles + 
                        "\n Joystick disponibles " + Productor_joysticks.joysticks + 
                        "\n Tarjetas SD dispobibles " + Productor_SD.SD);
                if(Productor_botones.botones > 4 && Productor_pantallas.pantallas_normales > 0 && Productor_pantallas.pantallas_tactiles > 0 && Productor_joysticks.joysticks > 1 && Productor_SD.SD > 0){
                    System.out.println("Tengo todos los materiales necesarios para ensamblar la consola");
                    this.semEnsambladorBoton.acquire(5);
                    this.semEnsambladorPantallaNormal.acquire();
                    this.semEnsambladorPantallaTactil.acquire();
                    this.semEnsambladorJoysticks.acquire(2);
                    this.semEnsambladorSD.acquire();
                    this.mutex.acquire();
                    consumirBotones();
                    consumirJoysticks();
                    consumirPantallaNormal();
                    consumirPantallaTactil();
                    consumirSD();
                    consolas_listas ++;
                    PanelControl.setEstadisticaConsolas(Integer.toHexString(consolas_listas));
                    this.mutex.release();
                    this.semBoton.release(5);
                    this.semPantallas.release(2);
                    this.semJoysticks.release(2);
                    this.semSD.release();
                    

                }
                
                System.out.println("No hay materiales suficientes");
            }
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

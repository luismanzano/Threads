/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoso;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Leonardo Gonzalez 
 * @author  Luis Manzano
 */
public class Controlador {
    
    public static volatile int contador_global;
   
    Productor_botones b = new Productor_botones();
    int max_botones = b.getMax_productores_botones();
    Productor_botones boton [] = new Productor_botones[max_botones];
    
    Productor_pantallas p = new Productor_pantallas();
    int max_pantallas = p.getMax_productores_pantallas();
    Productor_pantallas pantalla [] = new Productor_pantallas[max_pantallas];
    
    Productor_joysticks j = new Productor_joysticks();
    int max_joysticks = j.getMax_productores_joysticks();
    Productor_joysticks joysticks [] = new Productor_joysticks[max_joysticks];
    
    Productor_SD s = new Productor_SD();
    int max_SD = s.getMax_productores_SD();
    Productor_SD SD [] = new Productor_SD[max_SD];
    
    Ensamblador e = new Ensamblador();
    int max_ensamblador = e.getMax_ensambladores();
    Ensamblador ens [] = new Ensamblador[max_ensamblador];
    
    public Controlador() {
    }
    
        
    public void controlInicio(){
        Semaphore mutex = new Semaphore(1); // 1 - 1 = 0 
        Semaphore semBoton = new Semaphore(45); // 45 - 2 = 43
        Semaphore semEnsambladorBoton = new Semaphore(0); // 0 + 2 = 2
        Semaphore semPantallas = new Semaphore(40);
        Semaphore semEnsambladorPantallaNormal = new Semaphore(0);
        Semaphore semEnsambladorPantallaTactil = new Semaphore(0);
        Semaphore semJoysticks = new Semaphore(20);
        Semaphore semEnsambladorJoysticks = new Semaphore(0);
        Semaphore semSD = new Semaphore(15);
        Semaphore semEnsambladorSD = new Semaphore(0);
//        Productor_pantallas pantalla = new Productor_pantallas(mutex, semPantallas, semEnsambladorPantallaNormal, semEnsambladorPantallaTactil);
//        Productor_joysticks joystick = new Productor_joysticks(mutex, semJoysticks, semEnsambladorJoysticks);
//        Productor_SD sd = new Productor_SD(mutex, semSD, semEnsambladorSD);
//        pantalla.start();
//        joystick.start();
//        sd.start();
        
        LeerTxt lectorVariables = new LeerTxt();
        
        try{
            lectorVariables.leer_variables();
        } catch(Exception e) {
            System.out.println(e);
            System.out.println("No existe el archivo o el mismo esta corroupto");
        }
                 
         
        for (int i = 0; i < Productor_botones.productores_botones; i++) {
            
            boton[i] = new Productor_botones(mutex, semBoton, semEnsambladorBoton);
            boton[i].start();
            System.out.println("THREAD BOTON" + (i+1));    
        }
        
                 
         
        for (int i = 0; i < Productor_pantallas.productores_pantallas; i++) {
            
            pantalla[i] = new Productor_pantallas(mutex, semPantallas, semEnsambladorPantallaNormal, semEnsambladorPantallaTactil);
            pantalla[i].start();
                
        }
        


        for (int i = 0; i < Productor_joysticks.productores_joysticks; i++) {

            joysticks[i] = new Productor_joysticks(mutex, semJoysticks, semEnsambladorJoysticks);
            joysticks[i].start();

        }
        
                 
         
        for (int i = 0; i < Productor_SD.productores_SD; i++) {
            
            SD[i] = new Productor_SD(mutex, semSD, semEnsambladorSD);
            SD[i].start();
                
        }
        
        
        for (int i = 0; i < Ensamblador.ensambladores; i++) {
            
            ens[i]= new Ensamblador(mutex, semEnsambladorBoton, semEnsambladorPantallaNormal, semEnsambladorPantallaTactil, semEnsambladorJoysticks, semEnsambladorSD, semBoton, semPantallas, semJoysticks, semSD); 
            ens[i].start();
        }
        
    }
    
    public void controlDetener() {
        
          for (int i = 0; i < Productor_botones.productores_botones; i++) {
            
            boton[i].stop();
            System.out.println("THREAD BOTON" + (i+1));    
        }
        
                 
         
        for (int i = 0; i < Productor_pantallas.productores_pantallas; i++) {
            
            pantalla[i].stop();
                
        }
        


        for (int i = 0; i < Productor_joysticks.productores_joysticks; i++) {

            joysticks[i].stop();

        }
        
                 
         
        for (int i = 0; i < Productor_SD.productores_SD; i++) {
            
            SD[i].stop();
                
        }
        
        
        for (int i = 0; i < Ensamblador.ensambladores; i++) {
            
            ens[i].stop();
        }
        
    }
}

/*
    Requerimientos básicos para esamblar una nueva consola 
5 botones, 2 pantallas(1 normal y 1 táctil), 2 joystick y 1 lector de tarjetas SD

    Los productores
Deben revisar si hay espacio en el almacén para la creación de un producto (Semáforo)

    Productores de botones 
Un productor puede hacer 2 botones por día
Almacenamiento máx 45
Máx productores 3 

    Productores de pantalla
1 día para una pantalla normal 
2 días para una pantalla táctil 
Se debe hacer una pantalla normal y una táctil consecutivamente
Almecenamiento máx 40 
Máx produtores 5 

    Productores de joystick
2 días para 1 joystick
Almacenamiento máx 20
Máx productores 4

    Productores de tarjeta SD
3 días para una tarjeta
Almacenamiento máx 15 
Máx produtores 4 

    Ensambladores 
1 día para producir una consola 
Al terminar aumenta el contador de consolas 
No hay un máx de almacenamiento para las consolas
Máx ensambladores 5 

    Jefe
Registra el paso de los días con un contador 
Una unidad en el contador equivale a 6 horas 
El jefe no puede leer el contador si hay alguien leyendo el contador
El jefe esta durmiendo el resto del tiempo (sleep)

    Gerente 
Se dirige al contador, para verificar los días restantes al lanzamiento de un lote
Si el jefe esta modificando el contador debe esperar a que este termnie
Cuando el contador de días llegue a 0 el gerente inicia el desplieque de la consola
y reinicializa el contador para el siguiente lote

    Valores inicales 
1 productor de botones 
1 productor de pantallas
1 productor de joysticks
1 productor de lectores SD
1 ensamblador 

    Requerimientos generales

    Interfaz gráfica para el control de la simulación, se debe mostrar
Cantidad de productores de cada tipo
Cantidad de botones, pantallas (de cada tipo), joystiks y lectores SD disponibles en almacén
Cantidad de ensambladores
Cantidad de consolas listas 
Cantidad de días restantes para despliegue global
Estado del jefe
Estado del gerente 
Cualquier otro dato que se considere relevante
    Permitir en timepo de ejecución 
Contratar o despedir un produtor de cualquier tipo
Contratar o despedir un ensamblador 
    A través de un (json, csv, objeto o texto), se le debe poder indicar al programa 
    los siguiente parámetros
Tiempo, en segundos, que dura un día en el programa
Cantidad de días entre despachos 
Las capacidades máximas de almacenamiento de cada tipo
Cantidad inical de productores de cada tipo
Cantidad máx de productores de cada tipo
Cantidad inicial de ensambladores
Cantidad máxima de ensambladores
*/
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
   
    public Controlador() {
    }
    
        
    public void controlInicio(){
        Semaphore mutex = new Semaphore(1);
        Semaphore semBoton = new Semaphore(45);
        Semaphore semEnsambladorBoton = new Semaphore(0);
        Semaphore semPantallas = new Semaphore(40);
        Semaphore semEnsambladorPantallaNormal = new Semaphore(0);
        Semaphore semEnsambladorPantallaTactil = new Semaphore(0);
        Semaphore semJoysticks = new Semaphore(20);
        Semaphore semEnsambladorJoysticks = new Semaphore(0);
        Semaphore semSD = new Semaphore(15);
        Semaphore semEnsambladorSD = new Semaphore(0);
        Productor_botones boton_1 = new Productor_botones(mutex, semBoton, semEnsambladorBoton);
        Productor_botones boton_2 = new Productor_botones(mutex, semBoton, semEnsambladorBoton);
        Productor_pantallas pantalla = new Productor_pantallas(mutex, semPantallas, semEnsambladorPantallaNormal, semEnsambladorPantallaTactil);
        Productor_joysticks joystick = new Productor_joysticks(mutex, semJoysticks, semEnsambladorJoysticks);
        Productor_SD sd = new Productor_SD(mutex, semSD, semEnsambladorSD);
        boton_1.start();
        boton_2.start();
        pantalla.start();
        joystick.start();
        sd.start();
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
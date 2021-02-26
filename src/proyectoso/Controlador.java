/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoso;

import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo Gonzalez 
 * @author  Luis Manzano
 */
public class Controlador {
    
    public static volatile int contador_global;
    public static volatile int dias_restantes;
    public static volatile int duracion_dias;
   
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
    
    //Variables de minimos y maximos 
    
        int inicial_pantallas;
        int maximo_pantallas;

        int inicial_joysticks;
        int maximo_joysticks;

        int inicial_botones;
        int maximo_botones;

        int inicial_SD;
        int maximo_SD;
        
        int almacen_pantallas;
        int almacen_joysticks;
        int almacen_botones;
        int almacen_SD;
        
        int cantidad_dias;
    
    public Controlador() {
    }
    
        
    public void controlInicio(){
        LeerTxt lectorVariables = new LeerTxt();
        //COMO PUEDE HABER UNA EXCEPCION DE FILE NOT FOUND , PRIMERO HACES UN TRY 
        try{
            lectorVariables.leer_variables();
            //SI LOGRAMOS ENCONTRAR EL ARCHIVO, AHORA NOS TRAEMOS LAS VARIABLES A UN ENTORNO LOCAL
            inicial_pantallas = lectorVariables.getInicial_pantallas();
            Productor_pantallas.productores_pantallas = inicial_pantallas;
            
            maximo_pantallas = lectorVariables.getInicial_pantallas();
            Productor_pantallas.max_productores_pantallas = maximo_pantallas;
            
            inicial_joysticks = lectorVariables.getInicial_pantallas();
            Productor_joysticks.productores_joysticks = inicial_joysticks;
            maximo_joysticks = lectorVariables.getInicial_pantallas();
            Productor_joysticks.max_productores_joysticks = maximo_joysticks;
            
            inicial_botones = lectorVariables.getInicial_pantallas();
            Productor_botones.productores_botones = inicial_botones;
            maximo_botones = lectorVariables.getInicial_pantallas();
            Productor_botones.max_productores_botones = maximo_botones;
            
            inicial_SD = lectorVariables.getInicial_pantallas();
            Productor_SD.productores_SD = inicial_SD;
            maximo_SD = lectorVariables.getInicial_pantallas();
            Productor_SD.max_productores_SD = maximo_SD;
            
            cantidad_dias = lectorVariables.getCantidad_dias();
            duracion_dias = lectorVariables.getDuracion_dias();
            
            almacen_pantallas = lectorVariables.getAlmacen_pantallas();
            almacen_joysticks = lectorVariables.getAlmacen_joysticks();
            almacen_botones = lectorVariables.getAlmacen_botones();
            almacen_SD = lectorVariables.getAlmacen_SD();
            
            //coloco el tamano de los almacenes segun el sd
            Productor_pantallas.almacen_pantallas = almacen_pantallas;
            System.out.println("Almacen pantallas " + Productor_pantallas.almacen_pantallas);
            
            Productor_joysticks.almacen_joysticks = almacen_pantallas;
            System.out.println("Almacen  Joysticks " + Productor_joysticks.almacen_joysticks);
            
            Productor_botones.almacen_botones = almacen_pantallas;
            System.out.println("Almacen botones " + Productor_botones.almacen_botones);
            
            Productor_SD.almacen_SD = almacen_pantallas;
            System.out.println("Almacen pantallas SD " + Productor_SD.almacen_SD);
            
            //aqui estan las variables para que funcionen jefe y gerente
            contador_global = cantidad_dias*4;
            dias_restantes = cantidad_dias;
            
            
        } catch(Exception e) {
            System.out.println(e);
            System.out.println("No existe el archivo o el mismo esta corrupto");
        }
        
        PanelControl.setEstadisticasProductorBotones(String.valueOf(Productor_botones.productores_botones));
        PanelControl.setEstadisticasProductorJoysticks(String.valueOf(Productor_joysticks.productores_joysticks));
        PanelControl.setEstadisticasProductorPantallas(String.valueOf(Productor_pantallas.productores_pantallas));
        PanelControl.setEstadisticasProductorSD(String.valueOf(Productor_SD.productores_SD));
        
        Semaphore mutex = new Semaphore(1); // 1 - 1 = 0 
        Semaphore mutex2 = new Semaphore(1);
        Semaphore semBoton = new Semaphore(almacen_botones); // 45 - 2 = 43
        Semaphore semEnsambladorBoton = new Semaphore(0); // 0 + 2 = 2
        Semaphore semPantallas = new Semaphore(almacen_pantallas);
        Semaphore semEnsambladorPantallaNormal = new Semaphore(0);
        Semaphore semEnsambladorPantallaTactil = new Semaphore(0);
        Semaphore semJoysticks = new Semaphore(almacen_joysticks);
        Semaphore semEnsambladorJoysticks = new Semaphore(0);
        Semaphore semSD = new Semaphore(almacen_SD);
        Semaphore semEnsambladorSD = new Semaphore(0);
        
        //colocando las varibales de las otras clases segun el txt
        
        
        inicializadorThreads(mutex, mutex2, semBoton, semEnsambladorBoton, semPantallas,semEnsambladorPantallaNormal, semEnsambladorPantallaTactil, semJoysticks, semEnsambladorJoysticks, semSD, semEnsambladorSD);
        
    }
    
    public void reanudar(){
        
        Semaphore mutex = new Semaphore(1);
        Semaphore mutex2 = new Semaphore(1);
        Semaphore semBoton = new Semaphore(Productor_botones.almacen_botones);
        Semaphore semEnsambladorBoton = new Semaphore(Productor_botones.botones);
        Semaphore semPantallas = new Semaphore(Productor_pantallas.almacen_pantallas);
        Semaphore semEnsambladorPantallaNormal = new Semaphore(Productor_pantallas.pantallas_normales);
        Semaphore semEnsambladorPantallaTactil = new Semaphore(Productor_pantallas.pantallas_tactiles);
        Semaphore semJoysticks = new Semaphore(Productor_joysticks.almacen_joysticks);
        Semaphore semEnsambladorJoysticks = new Semaphore(Productor_joysticks.joysticks);
        Semaphore semSD = new Semaphore(Productor_SD.almacen_SD);
        Semaphore semEnsambladorSD = new Semaphore(Productor_SD.SD);
        
        inicializadorThreads(mutex, mutex2, semBoton, semEnsambladorBoton, semPantallas,semEnsambladorPantallaNormal, semEnsambladorPantallaTactil, semJoysticks, semEnsambladorJoysticks, semSD, semEnsambladorSD);

        
        
        
                 
    }
        
     private void inicializadorThreads(Semaphore mutex, Semaphore mutex2, Semaphore semBoton, Semaphore semEnsambladorBoton, Semaphore semPantallas, Semaphore semEnsambladorPantallaNormal, Semaphore semEnsambladorPantallaTactil, Semaphore semJoysticks, Semaphore semEnsambladorJoysticks, Semaphore semSD, Semaphore semEnsambladorSD){            

         
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
        //coloco el jefe
        Jefe jefe = new Jefe(mutex, mutex2, duracion_dias);
        jefe.run();
    }
     
     /* Metodo para detener la simulacion */
    
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
    
    /* Metodos para contratar y despedir*/
    
    public void contratarP_botones(){
        if(Productor_botones.productores_botones >= b.getMax_productores_botones()){
            JOptionPane.showMessageDialog(null, "Cantidad máxima de producotres de botones alcanzada", "Alerta", JOptionPane.WARNING_MESSAGE);
        }else{
            Productor_botones.productores_botones ++;
        }
    }
    
    public void despedirP_botones(){
        if(Productor_botones.productores_botones < 1){
            JOptionPane.showMessageDialog(null, "Cantidad mínima  de producotres de botones alcanzada", "Alerta", JOptionPane.WARNING_MESSAGE);
        }else{
            Productor_botones.productores_botones --;
        }
    }
    
    public void contratarP_pantallas(){
        if(Productor_pantallas.productores_pantallas >= p.getMax_productores_pantallas()){
            JOptionPane.showMessageDialog(null, "Cantidad máxima de producotres de pantallas alcanzada", "Alerta", JOptionPane.WARNING_MESSAGE);
        }else{
            Productor_pantallas.productores_pantallas ++;
        }
    }
    
    public void despedirP_pantallas(){
        if(Productor_pantallas.productores_pantallas < 1){
            JOptionPane.showMessageDialog(null, "Cantidad mínima  de producotres de pantallas alcanzada", "Alerta", JOptionPane.WARNING_MESSAGE);
        }else{
            Productor_pantallas.productores_pantallas --;
        }
    }
    
    public void contratarP_joysticks(){
        if(Productor_joysticks.productores_joysticks >= j.getMax_productores_joysticks()){
            JOptionPane.showMessageDialog(null, "Cantidad máxima de producotres de joysticks alcanzada", "Alerta", JOptionPane.WARNING_MESSAGE);
        }else{
            Productor_joysticks.productores_joysticks ++;
        }
    }
    
    public void despedirP_joysticks(){
        if(Productor_joysticks.productores_joysticks < 1){
            JOptionPane.showMessageDialog(null, "Cantidad mínima  de producotres de joysticks alcanzada", "Alerta", JOptionPane.WARNING_MESSAGE);
        }else{
            Productor_joysticks.productores_joysticks --;
        }
    }
    
    public void contratarP_SD(){
        if(Productor_SD.productores_SD >= s.getMax_productores_SD()){
            JOptionPane.showMessageDialog(null, "Cantidad máxima de producotres de tarjetas SD alcanzada", "Alerta", JOptionPane.WARNING_MESSAGE);
        }else{
            Productor_SD.productores_SD ++;
        }
    }
    
    public void despedirP_SD(){
        if(Productor_SD.productores_SD < 1){
            JOptionPane.showMessageDialog(null, "Cantidad mínima  de producotres de tarjetas SD alcanzada", "Alerta", JOptionPane.WARNING_MESSAGE);
        }else{
            Productor_SD.productores_SD --;
        }
    }
    
    public void contratarEnsamblador(){
        if(Ensamblador.ensambladores >= e.getMax_ensambladores()){
            JOptionPane.showMessageDialog(null, "Cantidad máxima de ensambladores alcanzada", "Alerta", JOptionPane.WARNING_MESSAGE);
        }else{
            Ensamblador.ensambladores ++;
        }
    }
    
    public void despedirEnsamblador(){
        if(Ensamblador.ensambladores < 1){
            JOptionPane.showMessageDialog(null, "Cantidad mínima  de ensambladores alcanzada", "Alerta", JOptionPane.WARNING_MESSAGE);
        }else{
            Ensamblador.ensambladores --;
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoso;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author luismanzano
 */
public class LeerTxt {
    private int inicial_pantallas;
    private int maximo_pantallas;
    
    private int inicial_joysticks;
    private int maximo_joysticks;
    
    private int inicial_botones;
    private int maximo_botones;
    
    private int inicial_SD;
    private int maximo_SD;
    
    private int cantidad_dias;
    private int duracion_dias;
    
    private int almacen_pantallas;
    private int almacen_joysticks;
    private int almacen_botones;
    private int almacen_SD;
    
    
    public void leer_variables() throws FileNotFoundException{
        File file = new File("variables.txt");
       // System.out.println(new File("test.txt").getAbsolutePath());
        if (file.exists()) {
            System.out.println("Encontre el archivo y lo estoy leyendo");
            Scanner sc = new Scanner(file); 
            
           ArrayList<String> valores = new ArrayList<String>();
           
           while(sc.hasNext()){
               valores.add(sc.nextLine());
           }
            
            for (int i = 0; i <=13; i++) {
                System.out.println("Linea "+i+ " valor del arreglo " + valores.get(i));
                switch(i){
                    //Colocando las variables del productor de pantlalas 
                    case 0: this.setInicial_pantallas(Integer.parseInt(valores.get(i)));
                    case 1: this.setMaximo_pantallas(Integer.parseInt(valores.get(i)));
                    
                    //Colocando las variables del productor de pantlalas 
                    case 2: this.setInicial_joysticks(Integer.parseInt(valores.get(i)));
                    case 3: this.setMaximo_joysticks(Integer.parseInt(valores.get(i)));
                    
                    //Colocando las variables del productor de pantlalas 
                    case 4: this.setInicial_botones(Integer.parseInt(valores.get(i)));
                    case 5: this.setMaximo_botones(Integer.parseInt(valores.get(i)));
                    
                     //Colocando las variable de duarcion de dia y cantidad de dias
                    case 6: this.setInicial_SD(Integer.parseInt(valores.get(i)));
                    case 7: this.setMaximo_SD(Integer.parseInt(valores.get(i)));
                    
                    //Colocando las variables del productor de pantlalas 
                    case 8: this.setCantidad_dias(Integer.parseInt(valores.get(i)));
                    case 9: this.setDuracion_dias(Integer.parseInt(valores.get(i))*1000);
                    
                    
                     //Variables de los almacenes
                    case 10: this.setAlmacen_pantallas(Integer.parseInt(valores.get(i)));
                    case 11: this.setAlmacen_joysticks(Integer.parseInt(valores.get(i)));
                    case 12: this.setAlmacen_botones(Integer.parseInt(valores.get(i)));
                    case 13: this.setAlmacen_SD(Integer.parseInt(valores.get(i)));
                }
            }
  
    while (sc.hasNextLine()) 
      System.out.println(sc.nextLine()); 
        } else {
          System.out.println("The file does not exist.");
        }
        }

   
    
    
    
    
    
   //GETTERS Y SETTERS 
    
    public int getInicial_pantallas() {
        return inicial_pantallas;
    }

    public void setInicial_pantallas(int inicial_pantallas) {
        this.inicial_pantallas = inicial_pantallas;
    }

    public int getMaximo_pantallas() {
        return maximo_pantallas;
    }

    public void setMaximo_pantallas(int maximo_pantallas) {
        this.maximo_pantallas = maximo_pantallas;
    }

    public int getInicial_joysticks() {
        return inicial_joysticks;
    }

    public void setInicial_joysticks(int inicial_joysticks) {
        this.inicial_joysticks = inicial_joysticks;
    }

    public int getMaximo_joysticks() {
        return maximo_joysticks;
    }

    public void setMaximo_joysticks(int maximo_joysticks) {
        this.maximo_joysticks = maximo_joysticks;
    }

    public int getInicial_botones() {
        return inicial_botones;
    }

    public void setInicial_botones(int inicial_botones) {
        this.inicial_botones = inicial_botones;
    }

    public int getMaximo_botones() {
        return maximo_botones;
    }

    public void setMaximo_botones(int maximo_botones) {
        this.maximo_botones = maximo_botones;
    }

    public int getInicial_SD() {
        return inicial_SD;
    }

    public void setInicial_SD(int inicial_SD) {
        this.inicial_SD = inicial_SD;
    }

    public int getMaximo_SD() {
        return maximo_SD;
    }

    public void setMaximo_SD(int maximo_SD) {
        this.maximo_SD = maximo_SD;
    }

    public int getCantidad_dias() {
        return cantidad_dias;
    }

    public void setCantidad_dias(int cantidad_dias) {
        this.cantidad_dias = cantidad_dias;
    }

    public int getDuracion_dias() {
        return duracion_dias;
    }

    public void setDuracion_dias(int duracion_dias) {
        this.duracion_dias = duracion_dias;
    }

    public int getAlmacen_pantallas() {
        return almacen_pantallas;
    }

    public void setAlmacen_pantallas(int almacen_pantallas) {
        this.almacen_pantallas = almacen_pantallas;
    }

    public int getAlmacen_joysticks() {
        return almacen_joysticks;
    }

    public void setAlmacen_joysticks(int almacen_joysticks) {
        this.almacen_joysticks = almacen_joysticks;
    }

    public int getAlmacen_botones() {
        return almacen_botones;
    }

    public void setAlmacen_botones(int almacen_botones) {
        this.almacen_botones = almacen_botones;
    }

    public int getAlmacen_SD() {
        return almacen_SD;
    }

    public void setAlmacen_SD(int almacen_SD) {
        this.almacen_SD = almacen_SD;
    }
    
    
    
    
    
}

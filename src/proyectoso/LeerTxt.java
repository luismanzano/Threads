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
import javax.swing.JOptionPane;

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
                    case 0: try{
                        this.setInicial_pantallas(Integer.parseInt(valores.get(i)));
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 1 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
                        this.setInicial_pantallas(1);
                    }
                        
                        if (this.getInicial_pantallas() < 0) {
                            JOptionPane.showMessageDialog(null, "El minimo de pantallas no puede ser negativo, se colocara '1' como default", "Alerta", JOptionPane.ERROR_MESSAGE);
                            this.setInicial_pantallas(1);
                        }
                        
                        
                        
                    
                        System.out.println("inicial pantallas"+getInicial_pantallas());
                        
                        
                        break;
                    case 1: try{
                        this.setMaximo_pantallas(Integer.parseInt(valores.get(i)));
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 1 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
                        this.setMaximo_pantallas(1);
                    }
                        
                        if (this.getMaximo_pantallas() < 0) {
                            JOptionPane.showMessageDialog(null, "El maximo de pantallas no puede ser negativo, se colocara '1' como default", "Alerta", JOptionPane.ERROR_MESSAGE);
                            this.setMaximo_pantallas(1);
                        }
                        
                        if(getMaximo_pantallas() < getInicial_pantallas()){
                             JOptionPane.showMessageDialog(null, "El maximo no puede ser menor al inicial, colocando el inicial como maximo", "Alerta", JOptionPane.ERROR_MESSAGE);
                           this.setMaximo_pantallas((this.getInicial_pantallas()));
                        }
   
                    
                    
                        System.out.println("maximo pantallas"+getMaximo_pantallas());
                        break;
                        
                        
                        
                    //Colocando las variables del productor de pantlalas 
                    case 2: try{
                        this.setInicial_joysticks(Integer.parseInt(valores.get(i)));
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 1 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
                        this.setInicial_joysticks(1);
                    }
                        
                        if (this.getInicial_joysticks() < 0) {
                            JOptionPane.showMessageDialog(null, "El minimo de joysticks no puede ser negativo, se colocara '1' como default", "Alerta", JOptionPane.ERROR_MESSAGE);
                            this.setInicial_joysticks(1);
                        }
                    
                    
                    
                    System.out.println("inicial joysticks"+getInicial_joysticks());
                        break;
                        
                        
                        
                    case 3: try{
                        this.setMaximo_joysticks(Integer.parseInt(valores.get(i)));
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 1 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
                        this.setMaximo_joysticks(1);
                    }
                        
                        if (this.getMaximo_joysticks() < 0) {
                            JOptionPane.showMessageDialog(null, "El maximo de pantallas no puede ser negativo, se colocara '1' como default", "Alerta", JOptionPane.ERROR_MESSAGE);
                            this.setMaximo_joysticks(1);
                        }
                        
                        if(getMaximo_joysticks() < getInicial_joysticks()){
                             JOptionPane.showMessageDialog(null, "El maximo no puede ser menor al inicial, colocando el inicial como maximo", "Alerta", JOptionPane.ERROR_MESSAGE);
                           this.setMaximo_joysticks((this.getInicial_joysticks()));
                        }
                    
                    
                    System.out.println("maximo joysticks"+getMaximo_joysticks());
                        break;
                    
                    //Colocando las variables del productor de pantlalas 
                    case 4: try{
                        this.setInicial_botones(Integer.parseInt(valores.get(i)));
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 1 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
                        this.setInicial_botones(1);
                    }
                        
                        if (this.getInicial_botones() < 0) {
                            JOptionPane.showMessageDialog(null, "El minimo de botones no puede ser negativo, se colocara '1' como default", "Alerta", JOptionPane.ERROR_MESSAGE);
                            this.setInicial_botones(1);
                        }
                    
                    
                    
                    System.out.println("inicial botones"+getInicial_botones());
                        break;
                    case 5:try{
                        this.setMaximo_botones(Integer.parseInt(valores.get(i)));
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 1 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
                        this.setMaximo_botones(1);
                    }
                        
                        if (this.getMaximo_botones() < 0) {
                            JOptionPane.showMessageDialog(null, "El maximo de botones no puede ser negativo, se colocara '1' como default", "Alerta", JOptionPane.ERROR_MESSAGE);
                            this.setMaximo_botones(1);
                        }
                            if(getMaximo_botones() < getInicial_botones()){
                             JOptionPane.showMessageDialog(null, "El maximo no puede ser menor al inicial, colocando el inicial como maximo", "Alerta", JOptionPane.ERROR_MESSAGE);
                           this.setMaximo_botones((this.getInicial_botones()));
                        }
                    
                        System.out.println("maximo botones"+getMaximo_botones());
                        break;
                        
                        
                     //Colocando las variable de duarcion de dia y cantidad de dias
                    case 6:try{
                        this.setInicial_SD(Integer.parseInt(valores.get(i)));
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 1 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
                        this.setInicial_SD(1);
                    }
                        
                        if (this.getInicial_SD() < 0) {
                            JOptionPane.showMessageDialog(null, "El maximo de botones no puede ser negativo, se colocara '1' como default", "Alerta", JOptionPane.ERROR_MESSAGE);
                            this.setInicial_SD(1);
                        }
                        
                        
                        System.out.println("Inicial SD"+getInicial_SD());
                        break;
                        
                        
                    case 7: try{
                        this.setMaximo_SD(Integer.parseInt(valores.get(i)));
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 1 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
                        this.setMaximo_SD(1);
                    }
                        
                        if (this.getMaximo_SD() < 0) {
                            JOptionPane.showMessageDialog(null, "El maximo de botones no puede ser negativo, se colocara '1' como default", "Alerta", JOptionPane.ERROR_MESSAGE);
                            this.setMaximo_SD(1);
                        }
                        
                        if(getMaximo_SD() < getInicial_SD()){
                             JOptionPane.showMessageDialog(null, "El maximo no puede ser menor al inicial, colocando el inicial como maximo", "Alerta", JOptionPane.ERROR_MESSAGE);
                           this.setMaximo_SD((this.getInicial_SD()));
                        }
                        System.out.println("maximo SD"+getMaximo_SD());
                        break;
                    
                    //Colocando las variables del productor de pantlalas 
                    case 8: this.setCantidad_dias(Integer.parseInt(valores.get(i)));
                        
//                        try{
//                        this.setCantidad_dias(Integer.parseInt(valores.get(i)));
//                    } catch (Exception e){
//                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 1 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
//                        this.setMaximo_SD(1);
//                    }
//                        
//                        if (this.getCantidad_dias() < 0) {
//                            JOptionPane.showMessageDialog(null, "los dias no pueden ser ngeativos", "Alerta", JOptionPane.ERROR_MESSAGE);
//                            this.setCantidad_dias(1);
//                        }
                    
                    
                        System.out.println("Cantidad dias dias"+getCantidad_dias());
                        break;
                    case 9: try{
                        this.setDuracion_dias(Integer.parseInt(valores.get(i))*1000);
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 1 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
                        this.setDuracion_dias(1000);
                    }
                        
                        if (this.getDuracion_dias() < 0) {
                            JOptionPane.showMessageDialog(null, "El maximo de botones no puede ser negativo, se colocara '1' como default", "Alerta", JOptionPane.ERROR_MESSAGE);
                            this.setDuracion_dias(1000);
                        }
                    break;
                    
                    
                     //Variables de los almacenes
                    case 10:try{
                        this.setAlmacen_pantallas(Integer.parseInt(valores.get(i)));
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 1 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
                        this.setAlmacen_pantallas(1);
                    }
                        
                        if (this.getDuracion_dias() < 0) {
                            JOptionPane.showMessageDialog(null, "El maximo de botones no puede ser negativo, se colocara '1' como default", "Alerta", JOptionPane.ERROR_MESSAGE);
                            this.setAlmacen_pantallas(1);
                        }
                    
                    break;
                    
                    
                    
                    
                    case 11: try{
                        this.setAlmacen_joysticks(Integer.parseInt(valores.get(i)));
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 40 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
                        this.setAlmacen_joysticks(40);
                    }
                        
                        if (this.getAlmacen_joysticks() < 0) {
                            JOptionPane.showMessageDialog(null, "El almacen no puede ser negativo, colocando 40 como default", "Alerta", JOptionPane.ERROR_MESSAGE);
                            this.setAlmacen_joysticks(40);
                        }
                    case 12:try{
                        this.setAlmacen_botones(Integer.parseInt(valores.get(i)));
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 40 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
                        this.setAlmacen_botones(40);
                    }
                        
                        if (this.getAlmacen_botones() < 0) {
                            JOptionPane.showMessageDialog(null, "El almacen no puede ser negativo, colocando 40 como default", "Alerta", JOptionPane.ERROR_MESSAGE);
                            this.setAlmacen_botones(40);
                        }
                    case 13:try{
                        this.setAlmacen_SD(Integer.parseInt(valores.get(i)));
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, "No se puede ingresar una letra, colocando 40 como predeterminado", "Alerta", JOptionPane.ERROR_MESSAGE);
                        this.setAlmacen_SD(40);
                    }
                        
                        if (this.getAlmacen_SD() < 0) {
                            JOptionPane.showMessageDialog(null, "El almacen no puede ser negativo, colocando 40 como default", "Alerta", JOptionPane.ERROR_MESSAGE);
                            this.setAlmacen_SD(40);
                        }
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

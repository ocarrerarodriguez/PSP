/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer8;

import java.util.ArrayList;
//import java.util.List;

/**
 *
 * @author lacuatoris
 */
public class Carrera {
    //List<Integer> contenido = new ArrayList<Integer>();
    ArrayList<Integer> contenido = new ArrayList<Integer>();
    ArrayList<Boolean> candados = new ArrayList<Boolean>();
   // private int[] contenido ;
    private boolean candadovuelta=false;
    
    //Método para colocar mas contenido en el contenedor
    private boolean carrera=true;
    
    public boolean get_carrera()
    {
        return this.carrera;
    }
    public synchronized int añadir_carrera(int valor)
    {
        contenido.add(valor);
        this.candados.add(false);
        return (contenido.size()-1);
    }
    public synchronized boolean abanza(int value,int participante,int vuelta) {
        boolean resultado=true;
        int valor=contenido.get(participante);
        contenido.set(participante,(valor+value));
        this.candados.set(participante,true);
        //System.out.println("candado = true"+participante);
        if((valor+value)>69)
        {
            this.carrera=false;
            return false;
            
        }
        for (boolean item : candados) 
        {
            if(item==false)
            {
             resultado=false; 
             break;
            } 
        }
        
        if (resultado==true){
            for (int i=this.candados.size()-1; i>=0; i--) 
            {
                this.candados.set(i,false);
                //System.out.println("candado = false"+i);
            }
        }
     return true;  
    }
    public synchronized boolean retrocede(int value,int participante,int vuelta) {
        boolean resultado=true;
        int valor=contenido.get(participante);
        if((valor-value)>0)
        {
        contenido.set(participante,(valor-value));
        this.candados.set(participante,true);
        //System.out.println("candado = true"+participante);
        }
        else
        {
            contenido.set(participante,0);
            this.candados.set(participante,true);
            //System.out.println("candado = true"+participante);
        }
        for (boolean item : candados) 
        {
            if(item==false)
            {
             resultado=false; 
             break;
            }
        }
        
        if (resultado==true){
            for (int i=this.candados.size()-1; i>=0; i--) 
            {
                this.candados.set(i,false);
                //System.out.println("candado = false"+i);
            }
        }
        
        return true;
    }     
    
}

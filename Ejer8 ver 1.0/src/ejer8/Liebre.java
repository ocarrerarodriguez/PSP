/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer8;

import java.util.Random;

/**
 *
 * @author lacuatoris
 */
public class Liebre implements Runnable {
    
    private final Carrera carrera;
    private final int participante;
    private final String nombre;
    private int vuelta;
    private boolean resultado;
    private  Random aleatorio;
    public Liebre(Carrera carrera,int participante,String nombre) 
    {
        this.carrera = carrera;
        this.participante = participante;
        this.nombre = nombre;
        int vuelta=0;
        this.aleatorio = new Random();
        
    }
    @Override
    public void run() {
        while(this.carrera.get_carrera())
        {
            if(this.carrera.candados.get(this.participante)==false)
           {
                int porcentaje=aleatorio.nextInt(100);
                if( porcentaje <20)
                {
                    resultado=true;
                    System.out.println(this.vuelta+" la liebre: " +this.nombre + " con el dorsal numero: "+this.participante + " tiene el valor:" + carrera.contenido.get(this.participante));
                }
                if(porcentaje<40&&porcentaje>20)
                {
                     resultado=carrera.abanza(9, this.participante, this.vuelta);
                     System.out.println(this.vuelta+" la liebre: " +this.nombre + " con el dorsal numero: "+this.participante + " tiene el valor:" + carrera.contenido.get(this.participante));
                }
                if(porcentaje<50&&porcentaje>40)
                {
                     resultado=carrera.retrocede(12, this.participante, this.vuelta);
                     System.out.println(this.vuelta+" la liebre: " +this.nombre + " con el dorsal numero: "+this.participante + " tiene el valor:" + carrera.contenido.get(this.participante));
                }
                if(porcentaje<80&&porcentaje>50)
                {
                     resultado=carrera.abanza(1, this.participante, this.vuelta);
                     System.out.println(this.vuelta+" la liebre: " +this.nombre + " con el dorsal numero: "+this.participante + " tiene el valor:" + carrera.contenido.get(this.participante));
                }
                if(porcentaje<=100&&porcentaje>80)
                {
                     resultado=carrera.retrocede(2, this.participante, this.vuelta);
                     System.out.println(this.vuelta+" la liebre: " +this.nombre + " con el dorsal numero: "+this.participante + " tiene el valor:" + carrera.contenido.get(this.participante));
                }
                if(resultado==false)
                {
                    System.out.println("*****************GANADOR "+this.vuelta+"********************");
                     System.out.println("la liebre: " +this.nombre + " con el dorsal numero: "+this.participante + " gano la carrera con el valor:" + carrera.contenido.get(this.participante));
                     System.out.println("*****************//********************");
                }
                 System.out.println(porcentaje);
                 this.vuelta++;
           }
            try
            {
            	//pausa entre producciones  
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("liebre " +  this.participante + ": Error en run -> " + e.getMessage());
            }
        }
    }
    
}
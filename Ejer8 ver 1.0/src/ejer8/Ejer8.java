/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer8;

/**
 *
 * @author lacuatoris
 */
public class Ejer8 {

    private static Carrera carrera;
    private static Tortuga tortuga1;
    private static Tortuga tortuga2;
    private static Liebre liebre1;
    private static Liebre liebre2;
    
    public static void main(String[] args) {
        carrera = new Carrera();
        
        tortuga1 = new Tortuga(carrera,carrera.añadir_carrera(0),"paco");
        //tortuga2 = new Tortuga(carrera,carrera.añadir_carrera(0),"lola");
        liebre1 = new Liebre(carrera,carrera.añadir_carrera(0),"mariano");
        //liebre2 = new Liebre(carrera,carrera.añadir_carrera(0),"francisca");
        System.out.println("Tortuga paco " + 1 + " activado");
        //System.out.println("Tortuga lola " + 2 + " activado");
        System.out.println("Liebre mariano " + 1 + " activado");
	//System.out.println("Liebre francisca " + 2 + " activado");
        new Thread(tortuga1).start();
        //new Thread(tortuga2).start();
        new Thread(liebre1).start();
        //new Thread(liebre2).start();
        
        
        
    }
    
}

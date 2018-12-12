/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer6;

import java.util.Random;

/**
 *
 * @author lacuatoris
 */
public class proveedor implements Runnable {
    private final Conta contenedor;
    private final int idconsumidor;
    private  Random aleatorio;
    private int i;
    public proveedor(Conta contenedor, int idconsumidor) 
    {
        this.contenedor = contenedor;
        this.idconsumidor = idconsumidor;
        aleatorio = new Random();
        this.i =0;
    }
    @Override
    public void run() {
        for(i=0;i<5;i++)
        {
            int coger = aleatorio.nextInt(100);
            this.contenedor.retirar(coger,this.idconsumidor,i);
            //System.out.println("El consumidor " + this.idconsumidor + " consume: " + );
            try {
                Thread.sleep(500);
            } 
            catch (Exception e) {
                    e.printStackTrace();
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer7;



/**
 *
 * @author lacuatoris
 */
public class Proveedor implements Runnable {
    private final Buzon buzon;
    private final int idconsumidor;
     private String mensaje;
   
    public Proveedor(Buzon buzon, int idconsumidor) 
    {
        this.buzon = buzon;
        this.idconsumidor = idconsumidor;
        this.mensaje = "";
        
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++)
        {
            
            mensaje=this.buzon.retirar(this.idconsumidor,i);
            
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

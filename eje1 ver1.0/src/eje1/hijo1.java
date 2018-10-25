/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje1;

/**
 *
 * @author lacuatoris
 */
public class hijo1 extends Thread
{ 
    String nombre;
    int parametro1;
    int parametro2;
    int parametro3;
    int parametro;
    hijo1(String nome,int parametro)
    {   
        super(nome);
        this.nombre=nome;
        this.parametro1=1;
        this.parametro2=1;
        this.parametro3=1;
        this.parametro=parametro;
        System.out.println("Creado fío:"+nome);
          
    }
    int fibonachi(int x,int y)
    {
        return x+y;
    }
    public void run()   
    {
        int parametro3;
        for(int i=1;i<this.parametro;i++)
        {
            parametro3=this.fibonachi(this.parametro1,this.parametro2);
            this.parametro2=this.parametro1;
            this.parametro1= parametro3;
            
            System.out.println(i+" "+this.nombre+" fibonachi "+this.parametro1);
        }
        System.out.println("termina el thread "+this.nombre);
     }
} 
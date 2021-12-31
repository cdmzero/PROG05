/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog05;

import java.util.InputMismatchException;
import java.util.Scanner;
import static prog05.LanzadorTienda.VerifyLength;

/**
 *
 * @author jfunez
 */
public class PROG05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InputMismatchLength {
   
          Articulo articuloDeportivo    = new Articulo();
          Articulo articuloDptivo       = new Articulo(10,20,30, "Bicicleta");
                    
          

        Scanner sc = new Scanner(System.in);

        int codArticuloDeportivo = 0;

        boolean enabledWelcomeMenu = true;
        boolean verification = true;
          
       while(enabledWelcomeMenu){
       
        
                    while(verification){
                        
                        
                        
                         try{
                             

                                    System.out.println("Pon un codigo de articulo:\n Por ejemplo: 11220000006-18");    


                                    codArticuloDeportivo = sc.nextInt();
                                    verification = VerifyLength(codArticuloDeportivo);

                                    }


                                   catch(InputMismatchException err)
                                   {
                                       System.out.println("FORMATs");
                                       break;                                       


                                   }
                                   

                    }
                    
                                     if (verification == false)
                                     {
                                           enabledWelcomeMenu = false;
                                     }
                 }    
          
          
          
          
          
          
          
        
    }
    
}

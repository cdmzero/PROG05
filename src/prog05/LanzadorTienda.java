/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog05;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author zero
 */




public class LanzadorTienda {
    
    
    
      public static void main(String[] args) {
        
          ArticuloDeportivo obj = new ArticuloDeportivo();
          
          
          
          try{
              System.out.println("Bienvenidos a la tienda de caramelos:");    
              System.out.println("\n");    
              System.out.println("Selecciona una opcion:");    
              System.out.println("          Opcion 1 Ver el código completo del	artículo:");
              System.out.println("          Opcion 2 Ver la descripción	del artículo:");
              System.out.println("          Opcion 3 Ver el codigo de la ciudad:");
              System.out.println("          Opcion 4 Ver el codigo de la tienda:");
              System.out.println("          Opcion 5 Ver el codigo del articulo:");
              System.out.println("          Opcion 6 Ver el codigo de control:\n");
              System.out.println("          Opcion 7 Aumentar unidades.");
              System.out.println("          Opcion 8 Decrementar unidades.");
              System.out.println("          Opcion 9 Consultar unidades.");
              System.out.println("          Opcion 10 Salir.");
        
              Scanner sc  = new Scanner( System.in);
              
              int temp = 1;
           
              while( temp > 0 && temp < 10) {
              
              System.out.println("Introduzca su opcion:");
              temp   = sc.nextInt();
            
         
            switch(temp){

            case 1: int codArtCompleto =  obj.consultacodArtCompleto();
                    System.out.println("Codigo completo del articulo: "+ codArtCompleto);
                    break;
                  
            case 2: 
                    
            case 3: int codCiudad =  obj.consultacodCiudad();
                    System.out.println("Codigo de ciudad: "+codCiudad);
                    break;

            case 4: int codTienda =  obj.consultacodTienda();
                    System.out.println("Codigo de tienda: "+codTienda);
                    break;
            
            case 5: int codArticulo =  obj.consultacodArticulo();
                    System.out.println("Codigo de articulo: "+codArticulo);
                    break;
            
            case 6: int codControl =  obj.consultacodControl();
                    System.out.println("Codigo de control: "+codControl);
                    break;
            
            case 7: System.out.println("Esqui");
            
            case 8: System.out.println("Esqui");
            
            case 9: System.out.println("Esqui");
            
          
            default: System.out.println("Adios"); break;
               
        }
            }
        }catch(InputMismatchException err) {
            
           System.out.println("Tipo de dato invalido introducido");
        }
    }
          

}

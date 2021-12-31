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
        
        long codArticuloDeportivo = 0;
        String descripcion = "";

        boolean verificacionArticulo = true;
        boolean verificacionDescripcion = true;
    
            
                    while(verificacionArticulo)
                    {
                         Scanner sc = new Scanner(System.in);
                        
                       System.out.println("Pon un codigo de articulo:\nPor ejemplo: XXXX XXXXX-YY");
                       
                        try
                        {
                            codArticuloDeportivo = sc.nextLong();
                            verificacionArticulo = VerificarLength(codArticuloDeportivo);
                        }
                        catch(InputMismatchException err)
                        {
                            System.err.println("Error de tipo");
                        }
                        catch(InputMismatchLength err)
                        {
                            System.err.println("Error de longitud");
                        }                       
                    }
                    
                    while(verificacionDescripcion)
                    {
                         Scanner scx = new Scanner(System.in);
                        
                       System.out.println("Pon una descripcion: \nPor ejemplo: La bicicleta más rápida del mercado en 2022");
                       
                        try
                        {
                            descripcion = scx.nextLine();
                            verificacionDescripcion = VerificarLengthDescription(descripcion);
                        }
                        catch(InputMismatchException err)
                        {
                            System.err.println("Error de tipo");
                        }
                        catch(InputMismatchLength err)
                        {
                            System.err.println(err.getMessage());
                        }                       
                    }
                  
//  Disecionamos el codigo

        Articulo ArtiDeportivo = ObtenerDatosArticulo(codArticuloDeportivo, descripcion);
        
        
// Meter dentro de un metodo*
                    
        System.out.println("Bienvenidos a la tienda de caramelos:");
        System.out.println("\n");
        System.out.println("Selecciona una opcion:");
        System.out.println("          Opcion 1 Ver el código completo del artículo:");
        System.out.println("          Opcion 2 Ver la descripción del artículo:");
        System.out.println("          Opcion 3 Ver el Codigo de la ciudad:");
        System.out.println("          Opcion 4 Ver el Codigo de la tienda:");
        System.out.println("          Opcion 5 Ver el Codigo del articulo:");
        System.out.println("          Opcion 6 Ver el Codigo de control:\n");
        System.out.println("          Opcion 7 Aumentar unidades.");
        System.out.println("          Opcion 8 Decrementar unidades.");
        System.out.println("          Opcion 9 Consultar unidades.");
        System.out.println("          Opcion 10 Salir.");

        boolean enabledMenu = true;
        try {

            while (enabledMenu == true) {
                Scanner sca = new Scanner(System.in);

                System.out.println("Introduzca su opcion:");

                int opt;
                opt = sca.nextInt();

                switch (opt) {

                    case 1:
                        
                        System.out.println(ArtiDeportivo.CodigoCompleto());
                        break;

                    case 2:
                        
                        System.out.println(ArtiDeportivo.getDescripcion_articulo());
                        break;

                    case 3:
                        
                        System.out.println(ArtiDeportivo.getCod_ciudad());
                        break;

                    case 4:
                        
                        System.out.println(ArtiDeportivo.getCod_tienda());
                        break;

                    case 5:
                        
                         System.out.println(ArtiDeportivo.getCod_articulo());
                        break;

                    case 6:
                        
                        System.out.println(ArtiDeportivo.getCod_control());
                        break;
                        

                    case 7:
                        System.out.println("            Introduzca las unidades a aumentar:");
                        
                        int unidades = sca.nextInt();
                        
                        String resultado = ArtiDeportivo.AumentarDecrementarConsultarUnidades(ArtiDeportivo, unidades,"suma");
                        System.out.println("Total unidades: "+ resultado);
                        break;

                    case 8:
                        System.out.println("            Introduzca las unidades a decrementar:");
                        
                        unidades = sca.nextInt();
                        
                        resultado = ArtiDeportivo.AumentarDecrementarConsultarUnidades(ArtiDeportivo, unidades,"resta");
                        System.out.println("Total unidades: "+ resultado);
                        break;

                    case 9:
                    
                        
                        resultado = ArtiDeportivo.AumentarDecrementarConsultarUnidades(ArtiDeportivo, 0,"consultar");
                        System.out.println("Total unidades: "+ resultado);
                        
                        break;
                     

                    default:
                        System.out.println("Adios");
                        enabledMenu = false;
                        break;

                }
            }

        } catch (InputMismatchException err) {
            System.err.println("Dato invalido");
        }

   //Meter dentro de un metodo*
    
  }
    
    
    
    
    
    
        private static boolean VerificarLength(long codArticuloDeportivo ) throws InputMismatchLength {
        
    
            
                int length = String.valueOf(codArticuloDeportivo).length();


                    if ( length == 10 )
                    {

                        return false;

                    }
                    else
                    {
                        throw new InputMismatchLength ("Error de Logitud");
                        
                    }
        }
                    
        private static boolean VerificarLengthDescription(String descripcion ) throws InputMismatchLength {
        
    
            
                int lengthDescription = String.valueOf(descripcion).length();


                    if ( lengthDescription > 40 || lengthDescription <= 0 )
                    {

                       throw new InputMismatchLength ("Error de Logitud");

                    }
                    else
                    {
                        Articulo articuloDeportivo = new Articulo();
                        
                        articuloDeportivo.setDescripcion_articulo(descripcion);
                        return false;
                        
                    }
        
         
}

    public static Articulo ObtenerDatosArticulo(long codArticuloDeportivo, String descripcion) {
        
     int codArticuloDepo = (int)codArticuloDeportivo;
     
     int cod_ciudad     = codArticuloDepo   /  100000000;       //11-XXXXXXXXYY
     int cod_tienda     = (codArticuloDepo /   1000000) % 100;  //11-22-XXXXXXYY
     int cod_articulo   = codArticuloDepo  %   1000000;         //11-22-333333YY  
  
     int cod_control   = (cod_ciudad + cod_tienda + cod_articulo) % 99; //11-22-333333-44
      
     Articulo articuloDep = new Articulo();
        
      articuloDep.setCod_ciudad(cod_ciudad);
      articuloDep.setCod_articulo(cod_articulo);
      articuloDep.setCod_tienda(cod_tienda);
      articuloDep.setCod_control(cod_control);
      articuloDep.setDescripcion_articulo(descripcion);
        
        
        System.out.println("articuloDeportivo");
        
        return articuloDep;        
      
        
       
    }
    
    
   
   
       
    
    
    }
    



                
     
   

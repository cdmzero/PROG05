/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog05;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jose Funez
 */
class LanzadorTienda {

    public static void main(String[] args) {

        System.out.println("Diferentes costructores");

        Articulo arti = new Articulo();

        System.out.println("Sin parametros" + arti.toString());

        Articulo artis = new Articulo(12, 34, 567890, 32, "descripcion");

        System.out.println("Con parametros" + artis.toString());

        Articulo artis2 = new Articulo(artis);

        System.out.println("Desde otro objeto" + artis2.toString());

        System.out.println("");
        System.out.println("");

        long codArticuloDeportivo = 0;
        String descripcion = "";

        boolean verificacionCod = true;
        boolean verificacionDescripcion = true;

        System.out.println("Bienvenido a la tienda de deportes MercaDeporte");

        while (verificacionCod) {
            Scanner sc = leerTeclado();

            System.out.print("Pon un codigo de articulo.\nPor ejemplo: XXXX XXXXX-YY: ");

            try {
                codArticuloDeportivo = sc.nextLong();
                verificacionCod = validarCodigoArticulo(codArticuloDeportivo);
            } catch (InputMismatchException err) {
                System.err.println("Error de tipo");
            } catch (ExcepcionTiendaDeportes err) {
                System.err.println(err.getMessage());
            }
        }

        while (verificacionDescripcion) {
            Scanner scx = leerTeclado();

            System.out.print("Pon una descripcion. \nPor ejemplo: La bici más rápida del mercado en 2022: ");

            try {
                descripcion = scx.nextLine();
                verificacionDescripcion = validarDescripcion(descripcion);
            } catch (InputMismatchException err) {
                System.err.println("Error de tipo");
            } catch (ExcepcionTiendaDeportes err) {
                System.err.println(err.getMessage());
            }
        }

//  Disecionamos el codigo del articulo
        Articulo ArtiDeportivo = ObtenerDatosArticulo(codArticuloDeportivo, descripcion);
//  Mostramos menu      
        mostrarMenu(ArtiDeportivo);

    }

//Creamos un metodo para el teclado    
    private static Scanner leerTeclado() {

        Scanner sc = new Scanner(System.in);

        return sc;
    }

    //Creamos un metodo privado estatico para invocar el menu al cual requiere de un objeto
    private static void mostrarMenu(Articulo ArtiDeportivo) {

        System.out.println("Menu de MercaDeporte:");
        System.out.println("\n");
        System.out.println("Selecciona una opcion.");
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

        boolean enabledmostrarMenu = true;
        boolean enabledmostrarMenu2 = true;

        do {
            try {

                while (enabledmostrarMenu == true) {

                    Scanner sca = leerTeclado();

                    System.out.print("Introduzca su opcion[1-9][10 Salir]: ");

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
                            System.out.print("            Introduzca las unidades a aumentar: ");

                            int unidades = sca.nextInt();

                            String resultado = ArtiDeportivo.AumentarDecrementarConsultarUnidades(ArtiDeportivo, unidades, "suma");
                            System.out.println("          Total unidades: " + resultado);
                            break;

                        case 8:

                            System.out.print("            Introduzca las unidades a decrementar: ");

                            int resta = 0;

                            unidades = sca.nextInt();

                            resultado = ArtiDeportivo.AumentarDecrementarConsultarUnidades(ArtiDeportivo, unidades, "resta");
                            System.out.println("          Total unidades: " + resultado);

                            break;

                        case 9:

                            resultado = ArtiDeportivo.AumentarDecrementarConsultarUnidades(ArtiDeportivo, 0, "consultar");
                            System.out.println("          Total unidades: " + resultado);

                            break;

                        case 10:
                            System.out.println("Adios");
                            enabledmostrarMenu = false;
                            enabledmostrarMenu2 = false;
                            break;

                        default:
                            System.err.println("Opcion invalida");

                    }
                }

            } catch (InputMismatchException err) {
                System.err.println("Dato invalido");
            } catch (Exception err) {
                System.err.println(err.getMessage());
            }
        } while (enabledmostrarMenu2);

    }

    // Validamos longitud de codigo de artiulo y arrojamos excepcion si no se cumple
    private static boolean validarCodigoArticulo(long codArticuloDeportivo) throws ExcepcionTiendaDeportes {

        int length = String.valueOf(codArticuloDeportivo).length();

        if (length == 10) {

            return false;

        } else {
            throw new ExcepcionTiendaDeportes("Error de Logitud");

        }
    }

    //Validamos longitud de descripcion y arrojamos excepcion si no se cumple
    private static boolean validarDescripcion(String descripcion) throws ExcepcionTiendaDeportes {

        int lengthDescription = String.valueOf(descripcion).length();

        if (lengthDescription > 40 || lengthDescription <= 0) {

            throw new ExcepcionTiendaDeportes("Error de Logitud");

        } else {
            Articulo articuloDeportivo = new Articulo();

            articuloDeportivo.setDescripcion_articulo(descripcion);
            return false;

        }

    }

    //Diseccionamos el codigo y setteamos los valores 
    public static Articulo ObtenerDatosArticulo(long codArticuloDeportivo, String descripcion) {

        int codArticuloDepo = (int) codArticuloDeportivo;

        int cod_ciudad = codArticuloDepo / 100000000;       //11-XXXXXXXXYY
        int cod_tienda = (codArticuloDepo / 1000000) % 100;  //11-22-XXXXXXYY
        int cod_articulo = codArticuloDepo % 1000000;         //11-22-333333YY  

        Articulo articuloDep = new Articulo();

        articuloDep.setCod_ciudad(cod_ciudad);
        articuloDep.setCod_articulo(cod_articulo);
        articuloDep.setCod_tienda(cod_tienda);
        //llamos a un metodo publico del objeto para calcular el digito
        articuloDep.calcularDigitoControl();
        articuloDep.setDescripcion_articulo(descripcion);

        return articuloDep;

    }

}

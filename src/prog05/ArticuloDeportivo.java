/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog05;

/**
 *
 * @author zero
 */
public class ArticuloDeportivo {

    int codCiudad, codTienda, codArticulo, codControl, numArticulos;
    
    //Constructores 
    
    //Constructor con valores por defecto
   public ArticuloDeportivo(){
      
      codCiudad = codTienda = codArticulo = codControl = 10;
        
      numArticulos++;
   }
   
   //Contructor con valores dados por el usuario
   public ArticuloDeportivo(int codCiu, int codTie, int codArt){
  
      this.codCiudad     = codCiu;
      this.codTienda     = codTie;       
      this.codArticulo   = codArt;
      this.codControl    = 0;
      
      numArticulos++;
   }
   
    //Contructor con copia
   public ArticuloDeportivo(ArticuloDeportivo artiDep){
     
       ArticuloDeportivo copiaArtiDep = artiDep;
       numArticulos++;
   }
   
      //# Metodos para consultar el valor de los atributos  
    public int consultacodCiudad() {
        return this.codCiudad;
    }

    public int consultacodTienda() {
        return this.codTienda;
    }

    public int consultacodArticulo() {
        return this.codArticulo;
    }

    public int consultacodControl() {
        return this.codControl;
    }
    
    public int consultacodArtCompleto() {
        int codArtCompleto;
        codArtCompleto = Integer.valueOf(String.valueOf(this.codCiudad) + String.valueOf(this.codTienda) + String.valueOf(this.codArticulo)+ String.valueOf(this.codControl));
        return codArtCompleto;
    }

    //# Metodos para cambiar el valor de los atributos del objeto   
    void cambiacodCiudad(int codCiudad) {
        this.codCiudad = codCiudad;
    }

    void cambiacodTienda(int codTienda) {
        this.codTienda = codTienda;
    }

    void cambiacodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }
    
     void cambiacodControl(int codControl) {
        this.codControl = codControl;
    }

 //# Metodo para sacar por pantalla todos los datos del objeto  
    public String toString(ArticuloDeportivo ob) {

        String str = "Tienda:" + codCiudad + "; Ciudad: " + codTienda + "; Articulo: " + codArticulo + " Codigo de Control: " + codControl + "\n Codigo completo: " + codCiudad +codTienda + codArticulo + codControl+ "\n";

        return str;
    }
    

}

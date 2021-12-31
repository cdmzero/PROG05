/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog05;



/**
 *
 * @author jfunez
 */
public final class Articulo {
    private int cod_ciudad;
    private int cod_tienda;
    private int cod_articulo;
    private int cod_control;
    private int unidades;
    private String Descripcion_articulo;
    
    
    
     public Articulo() {
        this.cod_ciudad = 0;
        this.cod_tienda = 0;
        this.cod_articulo = 0;
        this.cod_control = 0;
        this.unidades = 0;
        this.Descripcion_articulo = "Null";
        
        
        }


    public Articulo(int cod_ciudad, int cod_tienda, int cod_articulo, int unidades, String Descripcion_articulo) {
        this.cod_ciudad = cod_ciudad;
        this.cod_tienda = cod_tienda;
        this.cod_articulo = cod_articulo;
        this.cod_control = 0;
        this.unidades = unidades;
        this.Descripcion_articulo = Descripcion_articulo;
        
        calcularDigitoControl();
    }

    public Articulo(Articulo articulo) {
        this.cod_ciudad = articulo.cod_ciudad;
        this.cod_tienda = articulo.cod_tienda;
        this.cod_articulo = articulo.cod_articulo;
        this.cod_control = articulo.cod_control;
        this.unidades = articulo.unidades;
        this.Descripcion_articulo = articulo.Descripcion_articulo;
        
    }

 
    
   //# Variable estatica 

    
    
    @Override
    public String toString() {
        return "Articulo{" + "cod_ciudad=" + cod_ciudad + ", cod_tienda=" + cod_tienda + ", cod_articulo=" + cod_articulo +", cod_control=" + cod_control + ", Descripcion del articulo=" + Descripcion_articulo + ", Unidades="+ unidades + '}';
    
    }
    
    public String CodigoCompleto() {
        return "Codigo completo"+ cod_ciudad + cod_tienda  + cod_articulo + cod_control + "";
    
    }
    
    public String AumentarDecrementarConsultarUnidades(Articulo arti, int cantidad, String operacion) throws Exception {
        
        int stock = arti.getUnidades();
        int totalUnidades = 0;
        String resultado = "";
        
        switch(operacion){
        
            case "suma":
                totalUnidades = stock + cantidad;
                resultado = String.valueOf(totalUnidades);
                arti.setUnidades(totalUnidades);
                
                break;
                
            case "resta":
                
                if (stock < cantidad){
                throw new Exception("       Error el stock es inferior a la cantidad a decrementar");
               
                }
                else{
                totalUnidades = stock - cantidad;
                resultado = String.valueOf(totalUnidades);
                arti.setUnidades(totalUnidades);}
                
                break;
                
            default:
                resultado = String.valueOf(stock);
        }
        
   
            return resultado;
    }
    
    

    
 
  //GETTERS

    public int getCod_ciudad() {
        return cod_ciudad;
    }

    public int getCod_tienda() {
        return cod_tienda;
    }

    public int getCod_articulo() {
        return cod_articulo;
    }
    
    public int getCod_control() {
        return cod_control;
    }

    public String getDescripcion_articulo() {
        return Descripcion_articulo;
    }
    
    public  int getUnidades() {
        return unidades;
    }
   
    
    //Metodo publico para establecer el codigo de control
    
    public void calcularDigitoControl(){
        
        int cod_control   = (this.cod_ciudad + this.cod_tienda + this.cod_articulo) % 99; 
     
        setCod_control(cod_control);
        
    } 
  
   
    
    
    //SETTERS
    

    public void setCod_ciudad(int cod_ciudad) {
        this.cod_ciudad = cod_ciudad;
    }

    public void setCod_tienda(int cod_tienda) {
        this.cod_tienda = cod_tienda;
    }

    public void setCod_articulo(int cod_articulo) {
        this.cod_articulo = cod_articulo;
    }
    private void setCod_control(int cod_control) {
        this.cod_control = cod_control;
    }
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setDescripcion_articulo(String Descripcion_articulo) {
        this.Descripcion_articulo = Descripcion_articulo;
    }
    
    
    
}

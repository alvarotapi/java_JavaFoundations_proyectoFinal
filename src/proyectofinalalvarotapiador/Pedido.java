/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalalvarotapiador;

/**
 *
 * @author FOC
 */
public class Pedido {
    //Atributos
    private String codigoPedido;
    private String refrescos;
    private String cervezas;
    private String raciones;
    private String platoDelDia;
    
    static int contadorCodigo = 1000;
    
    private static int precioRefresco = 2;
    private static int precioCerveza = 3;
    private static int precioRacion = 10;
    private static int precioPlato = 7;
    
    //Constructor
    public Pedido() {
        int contador = contadorCodigo++;
        this.codigoPedido = ""+contador;
    }

    public Pedido(String refrescos, String cervezas, String raciones, String platoDelDia) {
        this.refrescos = refrescos;
        this.cervezas = cervezas;
        this.raciones = raciones;
        this.platoDelDia = platoDelDia;
        
        int contador = contadorCodigo++;
        this.codigoPedido = ""+contador;
    }
    
    //Getter and Setter
    public String getRefrescos() {
        return refrescos;
    }

    public void setRefrescos(String refrescos) {
        this.refrescos = refrescos;
    }

    public String getCervezas() {
        return cervezas;
    }

    public void setCervezas(String cervezas) {
        this.cervezas = cervezas;
    }

    public String getRaciones() {
        return raciones;
    }

    public void setRaciones(String raciones) {
        this.raciones = raciones;
    }

    public String getPlatoDelDia() {
        return platoDelDia;
    }

    public void setPlatoDelDia(String platoDelDia) {
        this.platoDelDia = platoDelDia;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }
    
    //Métodos
    public static String cuenta(String numRefrescos, String numCervezas, String numRaciones, String numPlato){
        String cuentaTotal;
        int numRefr = Integer.parseInt(numRefrescos);
        int numCer = Integer.parseInt(numCervezas);
        int numRac = Integer.parseInt(numRaciones);
        int numPla = Integer.parseInt(numPlato);
        
        int cuentaTot = (numRefr*precioRefresco)+(numCer*precioCerveza)+
                (numRac*precioRacion)+(numPla*precioPlato);
        
        cuentaTotal = cuentaTot+"";
        
        return cuentaTotal;
    }
    
    public static String listaPrecios(){
        String listaPrecios = "El precio de cada refresco es: " + precioRefresco + " euros." + "\n" +
                "El precio de cada cerveza es: " + precioCerveza + " euros." + "\n" +
                "El precio de cada ración es: " + precioRacion + " euros." + "\n" +
                "El precio del plato del día es: " + precioRefresco + " euros." + "\n";
        
        return listaPrecios;
    }
}

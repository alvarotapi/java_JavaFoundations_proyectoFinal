/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalalvarotapiador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author FOC
 */
public class Mesa {
    private static String fichero = "pedidos.dat";
    private ArrayList<Pedido> arrayPedidos = new ArrayList<Pedido>();
    
    //Constructor
    public Mesa() {
        try{
            File fichMesa = new File(fichero);
            if(!fichMesa.exists()){
                fichMesa.createNewFile();
            }
            
            FileInputStream fich = new FileInputStream(fichMesa);
            DataInputStream dis = new DataInputStream(fich);
            
            Pedido pedido = new Pedido();
            
            pedido.setCodigoPedido(dis.readUTF());
            
            while (pedido.getCodigoPedido()!=null){
                
                pedido.setCervezas(dis.readUTF());
                pedido.setRefrescos(dis.readUTF());
                pedido.setRaciones(dis.readUTF());
                pedido.setPlatoDelDia(dis.readUTF());
                
                arrayPedidos.add(pedido);
                pedido = new Pedido();
                
                pedido.setCodigoPedido(dis.readUTF());
            }
            
            dis.close();
        }
        catch(IOException ex){
        }
    }
    
    //Metodos
    public String listarPedidos(){
        String salida = "";
        
        for(int i=0; i < arrayPedidos.size(); i++){
            salida = salida + "Código pedido número: " + arrayPedidos.get(i).getCodigoPedido() + System.lineSeparator();
            salida = salida + "Cantidad de refrescos: " + arrayPedidos.get(i).getRefrescos() + System.lineSeparator();
            salida = salida + "Cantidad de cervezas: " + arrayPedidos.get(i).getCervezas() + System.lineSeparator();
            salida = salida + "Cantidad de raciones: " + arrayPedidos.get(i).getRaciones() + System.lineSeparator();
            salida = salida + "Cantidad de platos del día: " + arrayPedidos.get(i).getPlatoDelDia() + System.lineSeparator();
            salida = salida + System.lineSeparator();
        }
        
        return salida;
    }
    
    public void mandarBarra (String refrescos, String cervezas, String raciones, String platoDelDia){
        Pedido pedido = new Pedido(refrescos, cervezas, raciones, platoDelDia);
        arrayPedidos.add(pedido);
        
        guardarPedido();
    }
    
    private void guardarPedido(){
        DataOutputStream dos = null;
        
        try{
            File fichDatos = new File(fichero);
            FileOutputStream fich = new FileOutputStream(fichDatos);
            dos = new DataOutputStream(fich);
            
            for(int i=0;i< arrayPedidos.size(); i++){
                dos.writeUTF(arrayPedidos.get(i).getCodigoPedido());
                dos.writeUTF(arrayPedidos.get(i).getRefrescos());
                dos.writeUTF(arrayPedidos.get(i).getCervezas());
                dos.writeUTF(arrayPedidos.get(i).getRaciones());
                dos.writeUTF(arrayPedidos.get(i).getPlatoDelDia());
            }
            
            dos.close();
        }
        catch (IOException ex){
        }
    }
    
    public Pedido buscar (String codigoPedido){
        Pedido elementoEncontrado = null;
        
        for (int i = 0; i<arrayPedidos.size(); i++){
            
            if(arrayPedidos.get(i).getCodigoPedido().equals(codigoPedido)){
                elementoEncontrado =(Pedido)arrayPedidos.get(i);
                break;
            }
        }
        
        return elementoEncontrado;
    }
    
    
    
}

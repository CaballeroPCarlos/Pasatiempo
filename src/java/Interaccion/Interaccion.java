
package Interaccion;

import Conectar.Conneccion;
import Datos.Aleatorio;
import java.sql.*;
import java.util.ArrayList;

public class Interaccion {
    Connection cnx=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    ArrayList<Aleatorio> listaAleatorio=null;
    Aleatorio objAleatorio=null;
    int a, c;
    String b;
    
    public void ReiniciarJugadores(){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL ReiniciarJugadores ()");
            
            pst.executeUpdate();
            pst.close();
            cnx.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void InsertarJugadores(Aleatorio ex){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL InsertarJugadores (?)");
            
            pst.setInt(1,ex.getJugador());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void IngresarEleccion(Aleatorio ex){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL IngresarEleccion (?, ?)");
            
            pst.setInt(1,ex.getEleccion());
            pst.setInt(2,ex.getJugador());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public Aleatorio ListarEleccion(Aleatorio ex){
        Aleatorio obj=null;
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL ListarEleccion(?)");
            pst.setInt(1,ex.getEleccion());
            rs=pst.executeQuery();
            
            while(rs.next()){
                obj=new Aleatorio();
                obj.setJugador(rs.getInt("Jugador"));
                obj.setEleccion(rs.getInt("Eleccion"));
                obj.setAciertos(rs.getInt("Aciertos") + 1);
            }
            pst.close();
            rs.close();
            cnx.close();
        } catch (Exception e) {
        }
        return obj;
    }
    
    public void ActualizarAciertos(Aleatorio ex){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL ActualizarAciertos (?, ?)");
            
            pst.setInt(1,ex.getAciertos());
            pst.setInt(2,ex.getEleccion());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public int VerficarMaximo(){
        a = 0;
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL VerficarMaximo()");
            rs=pst.executeQuery();
            
            while(rs.next()){
                a = rs.getInt(1);
            }
            pst.close();
            rs.close();
            cnx.close();
        } catch (Exception e) {
        }
        return a;
    }
    
    public int VerficarRepeticion(int a){
        c = 1;
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL VerficarRepeticion(?)");
            pst.setInt(1, a);
            rs=pst.executeQuery();
            
            while(rs.next()){
                c = rs.getInt(1);
            }
            pst.close();
            rs.close();
            cnx.close();
        } catch (Exception e) {
        }
        return c;
    }
    
    public String VerficarGanador(int a){
        b = "";
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL VerficarGanador(?)");
            pst.setInt(1, a);
            rs=pst.executeQuery();
            
            while(rs.next()){
                b = "El jugador " + rs.getInt("Jugador") + " gana con " + rs.getInt("Aciertos")
                        + " acietos.";
            }
            pst.close();
            rs.close();
            cnx.close();
        } catch (Exception e) {
        }
        return b;
    }
    
    public ArrayList<Aleatorio> ListarJugadores(){
        Aleatorio obj=null;
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL ListarJugadores()");
            rs=pst.executeQuery();
            listaAleatorio = new ArrayList<Aleatorio>();
            
            while(rs.next()){
                obj=new Aleatorio();
                obj.setJugador(rs.getInt("Jugador"));
                obj.setEleccion(rs.getInt("Eleccion"));
                obj.setAciertos(rs.getInt("Aciertos"));
                listaAleatorio.add(obj);
            }
            pst.close();
            rs.close();
            cnx.close();
        } catch (Exception e) {
        }
        return listaAleatorio;
    }
    
    public int VerificarEleccion(Aleatorio ex){
        a = 1;
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL VerificarEleccion(?)");
            pst.setInt(1, ex.getEleccion());
            rs=pst.executeQuery();
            
            while(rs.next()){
                a = rs.getInt(1);
            }
            pst.close();
            rs.close();
            cnx.close();
        } catch (Exception e) {
        }
        return a;
    }
}

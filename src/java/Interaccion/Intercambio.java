
package Interaccion;

import Conectar.Conneccion;
import Datos.Combate1;
import java.sql.*;
import java.util.ArrayList;

public class Intercambio {
    Connection cnx = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ArrayList<Combate1> listaCombate1 = null;
    Combate1 objCombate1 = null;
    int a;
    
    public Combate1 ListarTipo(Combate1 e){
        Combate1 obj=null;
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL ListarTipo(?, ?)");
            pst.setInt(1, e.getTipo());
            pst.setInt(2, e.getTipo());
            rs=pst.executeQuery();
            
            while(rs.next()){
                obj=new Combate1();
                obj.setJugador(e.getJugador());
                obj.setTipo(rs.getInt("Tipo"));
                obj.setEleccion(rs.getString("Eleccion"));
                obj.setVida(rs.getInt("Vida"));
                obj.setVidaMax(rs.getInt("VidaMax"));
                obj.setAtaque(rs.getInt("Ataque"));
                obj.setAtaqueMax(rs.getInt("AtaqueMax"));
                obj.setVelocidad(rs.getInt("Velocidad"));
                obj.setTurno(rs.getInt("Turno"));
            }
            pst.close();
            rs.close();
            cnx.close();
        } catch (Exception ex) {
        }
        return obj;
    }
    
    public void IngresarCaracteristicas(Combate1 e){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL IngresarCaracteristicas(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            pst.setInt(1,e.getTipo());
            pst.setString(2,e.getEleccion());
            pst.setInt(3,e.getVida());
            pst.setInt(4,e.getVidaMax());
            pst.setInt(5,e.getAtaque());
            pst.setInt(6,e.getAtaqueMax());
            pst.setInt(7,e.getVelocidad());
            pst.setInt(8,e.getTurno());
            pst.setInt(9,e.getJugador());
            
            pst.executeUpdate();
            pst.close();
            cnx.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Combate1 ListarUsuario(Combate1 e){
        Combate1 obj=null;
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL ListarUsuario(?)");
            pst.setInt(1, e.getJugador());
            rs=pst.executeQuery();
            
            while(rs.next()){
                obj=new Combate1();
                obj.setJugador(e.getJugador());
                obj.setTipo(rs.getInt("Tipo"));
                obj.setEleccion(rs.getString("Eleccion"));
                obj.setVida(rs.getInt("Vida"));
                obj.setVidaMax(rs.getInt("VidaMax"));
                obj.setAtaque(rs.getInt("Ataque"));
                obj.setAtaqueMax(rs.getInt("AtaqueMax"));
                obj.setVelocidad(rs.getInt("Velocidad"));
                obj.setTurno(rs.getInt("Turno"));
            }
            pst.close();
            rs.close();
            cnx.close();
        } catch (Exception ex) {
        }
        return obj;
    }
    
    public void IncrementarTurno(Combate1 e){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL IncrementarTurno(?, ?)");
            
            pst.setInt(1, e.getTurno() + 1);
            pst.setInt(2, e.getJugador());
            
            pst.executeUpdate();
            pst.close();
            cnx.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void AccionAtacar(Combate1 e, Combate1 e1, int b){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL AccionAtacar(?, ?)");
            if(a == 1)
                pst.setInt(1, e.getVida() - e1.getAtaque()*2);
            else
                pst.setInt(1, e.getVida() - e1.getAtaque());
            pst.setInt(2, e.getJugador());
            
            pst.executeUpdate();
            
            pst.close();
            cnx.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean DetectarFin(Combate1 e, Combate1 e1){
        if(e.getVida() <= 0 || e1.getVida() <= 0)
            return true;
        else
            return false;
    }
    
    public int MostrarFinal(Combate1 e){
        if(e.getVida() <= 0)
            return 1;
        else
            return 2;
    }
    
    public int eleccionRival(Combate1 e, Combate1 e1){
        a = 0;
        if(e.getVida() <= e1.getAtaque())
            return 1;
        else if(e1.getVida() <= 50)
            return 3;
        else if(e1.getAtaque() < e1.getAtaqueMax())
            return (int) (Math.random()*2+1);
        else{
            do{
                a = (int) (Math.random() * 2 + 1);
            }while(a == 2);
            return a;
        }
    }
    
    public void AccionAumentarAtaque(Combate1 e){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL AccionAumentarAtaque(?, ?)");
            if(e.getAtaque() < e.getAtaqueMax())
                pst.setInt(1, (int) (e.getAtaque() * 1.5));
            else
                pst.setInt(1, e.getAtaque());
            pst.setInt(2, e.getJugador());
            
            pst.executeUpdate();
            pst.close();
            cnx.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void AccionAumentarVida(Combate1 e){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL AccionAumentarVida(?, ?)");
            if(e.getVida() > e.getVidaMax() + 5)
                pst.setInt(1, e.getVida() - 5);
            else
                pst.setInt(1, e.getVida() + 35);
            pst.setInt(2, e.getJugador());
            
            pst.executeUpdate();
            pst.close();
            cnx.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}

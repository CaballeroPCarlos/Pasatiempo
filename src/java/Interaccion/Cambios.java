
package Interaccion;

import Conectar.Conneccion;
import Datos.Ingresar;
import java.sql.*;
import java.util.ArrayList;

public class Cambios {
    Connection cnx=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    ArrayList<Ingresar> listaIngresar=null;
    Ingresar objIngresar=null;
    
    public Ingresar ListarIngresar(){
        Ingresar obj=null;
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL ListarIngresar(1)");
            rs=pst.executeQuery();
            while(rs.next()){
                obj=new Ingresar();
                obj.setTurno(rs.getInt("turno"));
                obj.setVidaP(rs.getInt("vidaPropia"));
                obj.setVidaR(rs.getInt("vidaRival"));
                obj.setAtaqueP(rs.getInt("ataquePropio"));
                obj.setAtaqueR(rs.getInt("ataqueRival"));
            }
            pst.close();
            rs.close();
            cnx.close();
        } catch (Exception e) {
        }
        return obj;
    }
    
    public void Reemplazar(Ingresar ex){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL InsertarCaracteristicas(?, ?, ?, ?, ?)");
            
            pst.setInt(1,ex.getTurno());
            pst.setInt(2,ex.getVidaP());
            pst.setInt(3,ex.getVidaR());
            pst.setInt(4,ex.getAtaqueP());
            pst.setInt(5,ex.getAtaqueR());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public Ingresar ListarCaracteristicas(){
        Ingresar obj=null;
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL ListarIngresar(2)");
            rs=pst.executeQuery();
            while(rs.next()){
                obj=new Ingresar();
                obj.setTurno(rs.getInt("turno"));
                obj.setVidaP(rs.getInt("vidaPropia"));
                obj.setVidaR(rs.getInt("vidaRival"));
                obj.setAtaqueP(rs.getInt("ataquePropio"));
                obj.setAtaqueR(rs.getInt("ataqueRival"));
            }
            pst.close();
            rs.close();
            cnx.close();
        } catch (Exception e) {
        }
        return obj;
    }
    
    public int BuscarTurno(){
        int turno = 0;
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL BuscarTurno()");
            rs=pst.executeQuery();
            while(rs.next()){
                turno = (rs.getInt("turno") + 1);
            }
            
            rs.close();
            pst.close();
            cnx.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return turno;
    }
    
    public void CalcularTurno(int a){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL AumentarTurno(?)");
            pst.setInt(1,a);
            pst.executeUpdate();
            
            pst.close();
            cnx.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void AsestarAtaque(Ingresar ex, int a){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL AsestarAtaque(?)");
            if(a == 1)
                pst.setInt(1,ex.getVidaR()-ex.getAtaqueP()*2);
            else
                pst.setInt(1,ex.getVidaR()-ex.getAtaqueP());
            
            pst.executeUpdate();
            
            pst.close();
            cnx.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public boolean DetectarFin(Ingresar ex){
        if(ex.getVidaR() <= 0 || ex.getVidaP() <= 0)
            return true;
        else
            return false;
    }
    
    public int MostrarFinal(Ingresar ex){
        if(ex.getVidaP()<=0)
            return 1;
        else
            return 2;
    }
    
    public int eleccionRival(Ingresar ex){
        if(ex.getVidaP() <= ex.getAtaqueR())
            return 1;
        else if(ex.getVidaR() <= 50)
            return 3;
        else 
            return (int) (Math.random()*2+1);
    }
    
    public void RecibirAtaque(Ingresar ex, int a){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL RecibirAtaque(?)");
            if(a == 1)
                pst.setInt(1,ex.getVidaP()-ex.getAtaqueR()*2);
            else
                pst.setInt(1,ex.getVidaP()-ex.getAtaqueR());
            
            pst.executeUpdate();
            
            pst.close();
            cnx.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void AumentarAtaqueRival(Ingresar ex){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL AumentarAtaqueRival(?)");
            if(ex.getAtaqueR() <= 30)
                pst.setInt(1, (int) (ex.getAtaqueR()*1.5));
            else
                pst.setInt(1,ex.getAtaqueR());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void aumentarVidaRival(Ingresar ex){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL aumentarVidaRival(?)");
            if(ex.getVidaR() > 250)
                pst.setInt(1,ex.getVidaR() - 10);
            else
                pst.setInt(1,ex.getVidaR() + 15);
            
            pst.executeUpdate();
            pst.close();
            cnx.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void aumentarVidaPropia(Ingresar ex){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL aumentarVidaPropia(?)");
            if(ex.getVidaP() > 75)
                pst.setInt(1,ex.getVidaP() - 10);
            else
                pst.setInt(1,ex.getVidaP() + 30);
            
            pst.executeUpdate();
            pst.close();
            cnx.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void AumentarAtaquePropio(Ingresar ex){
        try {
            cnx=Conneccion.getConnection();
            pst=cnx.prepareStatement("CALL AumentarAtaquePropio(?)");
            if(ex.getAtaqueP() <= 15)
                pst.setInt(1, (int) (ex.getAtaqueP()*1.5));
            else
                pst.setInt(1,ex.getAtaqueP());
            pst.executeUpdate();
            pst.close();
            cnx.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

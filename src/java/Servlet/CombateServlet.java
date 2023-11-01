
package Servlet;

import Datos.Combate1;
import Interaccion.Intercambio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CombateServlet", urlPatterns = {"/CombateServlet"})
public class CombateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int op = Integer.parseInt(request.getParameter("op"));
            Combate1 usuario = new Combate1();
            Combate1 rival = new Combate1();
            int eleccion, a, aleatorio, i, fin;
            Intercambio intercambio = new Intercambio();
            String mensaje1, mensaje2, mensaje3, mensaje4;
            
            switch(op){
                case 1:{
                    eleccion = Integer.parseInt(request.getParameter("eleccion"));
                    usuario.setTipo(eleccion);
                    usuario.setJugador(5);
                    usuario = intercambio.ListarTipo(usuario);
                    intercambio.IngresarCaracteristicas(usuario);
                    intercambio.IncrementarTurno(usuario);
                    usuario = intercambio.ListarUsuario(usuario);
                    
                    do{
                        a=(int) (Math.random()*5);
                    }while(a == eleccion || a == 0);
                    rival.setTipo(a);
                    rival.setJugador(6);
                    rival = intercambio.ListarTipo(rival);
                    intercambio.IngresarCaracteristicas(rival);
                    intercambio.IncrementarTurno(rival);
                    rival = intercambio.ListarUsuario(rival);
                    
                    request.setAttribute("usuario", usuario);
                    request.setAttribute("rival", rival);
                }; break;
                case 2:{
                    usuario.setJugador(5);
                    usuario = intercambio.ListarUsuario(usuario);
                    
                    rival.setJugador(6);
                    rival = intercambio.ListarUsuario(rival);
                    
                    intercambio.IncrementarTurno(usuario);
                    intercambio.IncrementarTurno(rival);
                    
                    usuario = intercambio.ListarUsuario(usuario);
                    
                    rival = intercambio.ListarUsuario(rival);
                    
                    a = 0;
                    mensaje1 = "";
                    
                    for(i = 1; i <= usuario.getVelocidad(); i++){
                        aleatorio=(int) (Math.random()*10+1);
                        if(aleatorio==1){
                            a++;
                            switch(a){
                                case 1:{
                                    mensaje1 = "Recibió un golpe crítico";
                                }; break;
                                case 2:{
                                    mensaje1 = "Recibió dos golpes críticos";
                                }
                            }
                            
                            request.setAttribute("mensaje1", mensaje1);
                        }
                        intercambio.AccionAtacar(rival, usuario, aleatorio);
                        rival = intercambio.ListarUsuario(rival);
                    }
                    
                    if(intercambio.DetectarFin(usuario, rival)){
                        fin = intercambio.MostrarFinal(usuario);
                        request.setAttribute("fin", fin);
                    }else{
                        eleccion = intercambio.eleccionRival(usuario, rival);
                        switch(eleccion){
                            case 1:{
                                for(i = 1; i <= rival.getVelocidad(); i++){
                                    aleatorio=(int) (Math.random()*10+1);
                                    if(aleatorio==1){
                                        a++;
                                        mensaje2 = "";
                                        switch(a){
                                            case 1:{
                                                mensaje2 = "Recibiste un golpe crítico";
                                            }; break;
                                            case 2:{
                                                mensaje2 = "Recibiste dos golpes críticos";
                                            }
                                        }
                                        
                                        request.setAttribute("mensaje2", mensaje2);
                                    }
                                    intercambio.AccionAtacar(usuario, rival, aleatorio);
                                    usuario = intercambio.ListarUsuario(usuario);
                                }
                            }; break;
                            case 2:{
                                if(rival.getAtaque() <= rival.getAtaqueMax()){
                                    mensaje3 = "Aumentó su ataque";
                                    request.setAttribute("mensaje3", mensaje3);
                                }else{
                                    mensaje3 = "Intentó aumentar su ataque, pero no pudo.";
                                    request.setAttribute("mensaje3", mensaje3);
                                }
                                intercambio.AccionAumentarAtaque(rival);
                                
                                rival = intercambio.ListarUsuario(rival);
                            }; break;
                            case 3:{
                                if(rival.getVida() <= rival.getVidaMax() + 5){
                                    mensaje4 = "Se curó";
                                    request.setAttribute("mensaje4", mensaje4);
                                }else{
                                    mensaje4 = "Intentó curarse, pero no pudo.";
                                    request.setAttribute("mensaje4", mensaje4);
                                }
                                intercambio.AccionAumentarVida(rival);
                                
                                rival = intercambio.ListarUsuario(rival);
                            }
                        }
                        if(intercambio.DetectarFin(usuario, rival)){
                            fin = intercambio.MostrarFinal(usuario);
                            request.setAttribute("fin", fin);
                        }
                    }
                    request.setAttribute("usuario", usuario);
                    request.setAttribute("rival", rival);
                }; break;
                case 3:{
                    usuario.setJugador(5);
                    usuario = intercambio.ListarUsuario(usuario);
                    
                    rival.setJugador(6);
                    rival = intercambio.ListarUsuario(rival);
                    
                    intercambio.IncrementarTurno(usuario);
                    intercambio.IncrementarTurno(rival);
                    
                    usuario = intercambio.ListarUsuario(usuario);
                    
                    rival = intercambio.ListarUsuario(rival);
                    
                    intercambio.AccionAumentarVida(usuario);
                    
                    usuario = intercambio.ListarUsuario(usuario);
                    
                    eleccion = intercambio.eleccionRival(usuario, rival);
                    a = 0;
                    switch(eleccion){
                        case 1:{
                            for(i = 1; i <= rival.getVelocidad(); i++){
                                aleatorio=(int) (Math.random()*10+1);
                                if(aleatorio==1){
                                    a++;
                                    mensaje2 = "";
                                    switch(a){
                                        case 1:{
                                            mensaje2 = "Recibiste un golpe crítico";
                                        }; break;
                                        case 2:{
                                            mensaje2 = "Recibiste dos golpes críticos";
                                        }
                                    }
                                    
                                    request.setAttribute("mensaje2", mensaje2);
                                }
                                intercambio.AccionAtacar(usuario, rival, aleatorio);
                                usuario = intercambio.ListarUsuario(usuario);
                            }
                        }; break;
                        case 2:{
                            if(rival.getAtaque() <= rival.getAtaqueMax()){
                                mensaje3 = "Aumentó su ataque";
                                request.setAttribute("mensaje3", mensaje3);
                            }else{
                                mensaje3 = "Intentó aumentar su ataque, pero no pudo.";
                                request.setAttribute("mensaje3", mensaje3);
                            }
                            intercambio.AccionAumentarAtaque(rival);
                            
                            rival = intercambio.ListarUsuario(rival);
                        }; break;
                        case 3:{
                            if(rival.getVida() <= rival.getVidaMax() + 5){
                                mensaje4 = "Se curó";
                                request.setAttribute("mensaje4", mensaje4);
                            }else{
                                mensaje4 = "Intentó curarse, pero no pudo.";
                                request.setAttribute("mensaje4", mensaje4);
                            }
                            intercambio.AccionAumentarVida(rival);
                            
                            rival = intercambio.ListarUsuario(rival);
                        }
                    }
                    if(intercambio.DetectarFin(usuario, rival)){
                        fin = intercambio.MostrarFinal(usuario);
                        request.setAttribute("fin", fin);
                    }
                    request.setAttribute("usuario", usuario);
                    request.setAttribute("rival", rival);
                }; break;
                case 4:{
                    usuario.setJugador(5);
                    usuario = intercambio.ListarUsuario(usuario);
                    
                    rival.setJugador(6);
                    rival = intercambio.ListarUsuario(rival);
                    
                    intercambio.IncrementarTurno(usuario);
                    intercambio.IncrementarTurno(rival);
                    
                    usuario = intercambio.ListarUsuario(usuario);
                    
                    rival = intercambio.ListarUsuario(rival);
                    
                    intercambio.AccionAumentarAtaque(usuario);
                    
                    usuario = intercambio.ListarUsuario(usuario);
                    
                    eleccion = intercambio.eleccionRival(usuario, rival);
                    a = 0;
                    switch(eleccion){
                        case 1:{
                            for(i = 1; i <= rival.getVelocidad(); i++){
                                aleatorio=(int) (Math.random()*10+1);
                                if(aleatorio==1){
                                    a++;
                                    mensaje2 = "";
                                    switch(a){
                                        case 1:{
                                            mensaje2 = "Recibiste un golpe crítico";
                                        }; break;
                                        case 2:{
                                            mensaje2 = "Recibiste dos golpes críticos";
                                        }
                                    }
                                    
                                    request.setAttribute("mensaje2", mensaje2);
                                }
                                intercambio.AccionAtacar(usuario, rival, aleatorio);
                                usuario = intercambio.ListarUsuario(usuario);
                            }
                        }; break;
                        case 2:{
                            if(rival.getAtaque() <= rival.getAtaqueMax()){
                                mensaje3 = "Aumentó su ataque";
                                request.setAttribute("mensaje3", mensaje3);
                            }else{
                                mensaje3 = "Intentó aumentar su ataque, pero no pudo.";
                                request.setAttribute("mensaje3", mensaje3);
                            }
                            intercambio.AccionAumentarAtaque(rival);
                            
                            rival = intercambio.ListarUsuario(rival);
                        }; break;
                        case 3:{
                            if(rival.getVida() <= rival.getVidaMax() + 5){
                                mensaje4 = "Se curó";
                                request.setAttribute("mensaje4", mensaje4);
                            }else{
                                mensaje4 = "Intentó curarse, pero no pudo.";
                                request.setAttribute("mensaje4", mensaje4);
                            }
                            intercambio.AccionAumentarVida(rival);
                            
                            rival = intercambio.ListarUsuario(rival);
                        }
                    }
                    if(intercambio.DetectarFin(usuario, rival)){
                        fin = intercambio.MostrarFinal(usuario);
                        request.setAttribute("fin", fin);
                    }
                    request.setAttribute("usuario", usuario);
                    request.setAttribute("rival", rival);
                }
            }
            
            getServletContext().getRequestDispatcher("/Lucha2/CombateFrm.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

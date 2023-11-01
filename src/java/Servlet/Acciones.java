
package Servlet;

import Datos.Ingresar;
import Interaccion.Cambios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Acciones", urlPatterns = {"/Acciones"})
public class Acciones extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int op = Integer.parseInt(request.getParameter("op"));
            Ingresar ing = new Ingresar();
            Cambios cam = new Cambios();
            int turno, aleatorio, fin;
            String mensaje1, mensaje2, mensaje3, mensaje4;
            switch(op){
                case 1:{
                    ing = cam.ListarIngresar();
                    cam.Reemplazar(ing);
                    turno = cam.BuscarTurno();
                    cam.CalcularTurno(turno);
                    ing = cam.ListarCaracteristicas();
                    request.setAttribute("ing", ing);
                };
                break;
                case 2:{
                    turno = cam.BuscarTurno();
                    cam.CalcularTurno(turno);
                    ing = cam.ListarCaracteristicas();
                    aleatorio=(int) (Math.random()*10+1);
                    if(aleatorio==1){
                        mensaje1 = "Recibió un golpe crítico";
                        request.setAttribute("mensaje1", mensaje1);
                    }
                    cam.AsestarAtaque(ing, aleatorio);
                    
                    ing = cam.ListarCaracteristicas();
                    
                    if(cam.DetectarFin(ing)){
                        fin = cam.MostrarFinal(ing);
                        request.setAttribute("fin", fin);
                    } else{
                        int eleccion = cam.eleccionRival(ing);
                        switch(eleccion){
                            case 1:{
                                aleatorio=(int) (Math.random()*10+1);
                                if(aleatorio==1){
                                    mensaje2 = "Recibiste un golpe crítico";
                                    request.setAttribute("mensaje2", mensaje2);
                                }
                                cam.RecibirAtaque(ing, aleatorio);
                                
                                ing = cam.ListarCaracteristicas();
                            };
                            break;
                            case 2:{
                                if(ing.getAtaqueR() <= 30){
                                    mensaje3 = "Aumentó su ataque";
                                    request.setAttribute("mensaje3", mensaje3);
                                }
                                cam.AumentarAtaqueRival(ing);
                                
                                ing = cam.ListarCaracteristicas();
                            };
                            break;
                            case 3:{
                                if(ing.getVidaR() <= 250){
                                    mensaje4 = "Se curó";
                                    request.setAttribute("mensaje4", mensaje4);
                                }
                                cam.aumentarVidaRival(ing);
                                
                                ing = cam.ListarCaracteristicas();
                            }
                        }
                        if(cam.DetectarFin(ing)){
                            fin = cam.MostrarFinal(ing);
                            request.setAttribute("fin", fin);
                        }
                    }
                    
                    request.setAttribute("ing", ing);
                };
                break;
                case 3:{
                    turno = cam.BuscarTurno();
                    cam.CalcularTurno(turno);
                    ing = cam.ListarCaracteristicas();
                    
                    cam.aumentarVidaPropia(ing);
                    
                    ing = cam.ListarCaracteristicas();
                    
                    int eleccion = cam.eleccionRival(ing);
                    switch(eleccion){
                        case 1:{
                            aleatorio=(int) (Math.random()*10+1);
                            if(aleatorio==1){
                                mensaje2 = "Recibiste un golpe crítico";
                                request.setAttribute("mensaje2", mensaje2);
                            }
                            cam.RecibirAtaque(ing, aleatorio);
                            
                            ing = cam.ListarCaracteristicas();
                        };
                        break;
                        case 2:{
                            if(ing.getAtaqueR() <= 30){
                                mensaje3 = "Aumentó su ataque";
                                request.setAttribute("mensaje3", mensaje3);
                            }
                            cam.AumentarAtaqueRival(ing);
                            
                            ing = cam.ListarCaracteristicas();
                        };
                        break;
                        case 3:{
                            if(ing.getVidaR() <= 250){
                                mensaje4 = "Se curó";
                                request.setAttribute("mensaje4", mensaje4);
                            }
                            cam.aumentarVidaRival(ing);
                            
                            ing = cam.ListarCaracteristicas();
                        }
                    }
                    if(cam.DetectarFin(ing)){
                        fin = cam.MostrarFinal(ing);
                        request.setAttribute("fin", fin);
                    }
                    
                    request.setAttribute("ing", ing);
                };
                break;
                case 4:{
                    turno = cam.BuscarTurno();
                    cam.CalcularTurno(turno);
                    ing = cam.ListarCaracteristicas();
                    
                    cam.AumentarAtaquePropio(ing);
                    
                    ing = cam.ListarCaracteristicas();
                    
                    int eleccion = cam.eleccionRival(ing);
                    switch(eleccion){
                        case 1:{
                            aleatorio=(int) (Math.random()*10+1);
                            if(aleatorio==1){
                                mensaje2 = "Recibiste un golpe crítico";
                                request.setAttribute("mensaje2", mensaje2);
                            }
                            cam.RecibirAtaque(ing, aleatorio);
                            
                            ing = cam.ListarCaracteristicas();
                        };
                        break;
                        case 2:{
                            if(ing.getAtaqueR() <= 30){
                                mensaje3 = "Aumentó su ataque";
                                request.setAttribute("mensaje3", mensaje3);
                            }
                            cam.AumentarAtaqueRival(ing);
                            
                            ing = cam.ListarCaracteristicas();
                        };
                        break;
                        case 3:{
                            if(ing.getVidaR() <= 250){
                                mensaje4 = "Se curó";
                                request.setAttribute("mensaje4", mensaje4);
                            }
                            cam.aumentarVidaRival(ing);
                            
                            ing = cam.ListarCaracteristicas();
                        }
                    }
                    if(cam.DetectarFin(ing)){
                        fin = cam.MostrarFinal(ing);
                        request.setAttribute("fin", fin);
                    }
                    
                    request.setAttribute("ing", ing);
                }
            }
            getServletContext().getRequestDispatcher("/Lucha1/Combate.jsp").forward(request, response);
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

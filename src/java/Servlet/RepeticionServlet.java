
package Servlet;

import Datos.Aleatorio;
import Interaccion.Interaccion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RepeticionServlet", urlPatterns = {"/RepeticionServlet"})
public class RepeticionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int op = Integer.parseInt(request.getParameter("op"));
            Aleatorio aleatorio = new Aleatorio();
            Interaccion interaccion = new Interaccion();
            int jugadores, opcion1, opcion2, opcion3, opcion4, opcion5, opcion6, i;
            String mensaje = "";
            int a = 0;
            int b = 1;
            ArrayList<Aleatorio> lista = new ArrayList<Aleatorio>();
            
            switch(op){
                case 1:{
                    interaccion.ReiniciarJugadores();
                    
                    jugadores = Integer.parseInt(request.getParameter("jugadores"));
                    
                    for(i = 1; i <= jugadores; i++){
                        aleatorio.setJugador(i);
                        interaccion.InsertarJugadores(aleatorio);
                    }
                    
                    request.setAttribute("jugadores", jugadores);
                    getServletContext().getRequestDispatcher("/Repeticion/RepeticionBase.jsp").forward(request, response);
                };
                break;
                case 2:{
                    jugadores = Integer.parseInt(request.getParameter("jugadores"));
                    
                    i = 0;
                    opcion1 = 0;
                    opcion2 = 0;
                    opcion3 = 0;
                    opcion4 = 0;
                    opcion5 = 0;
                    opcion6 = 0;
                    
                    if(1 <= jugadores){
                        i++;
                        aleatorio.setJugador(i);
                        opcion1 = Integer.parseInt(request.getParameter("opcion1"));
                        aleatorio.setEleccion(opcion1);
                        interaccion.IngresarEleccion(aleatorio);
                    }
                    
                    if(2 <= jugadores){
                        i++;
                        aleatorio.setJugador(i);
                        opcion2 = Integer.parseInt(request.getParameter("opcion2"));
                        aleatorio.setEleccion(opcion2);
                        interaccion.IngresarEleccion(aleatorio);
                    }
                    
                    if(3 <= jugadores){
                        i++;
                        aleatorio.setJugador(i);
                        opcion3 = Integer.parseInt(request.getParameter("opcion3"));
                        aleatorio.setEleccion(opcion3);
                        interaccion.IngresarEleccion(aleatorio);
                    }
                    
                    if(4 <= jugadores){
                        i++;
                        aleatorio.setJugador(i);
                        opcion4 = Integer.parseInt(request.getParameter("opcion4"));
                        aleatorio.setEleccion(opcion4);
                        interaccion.IngresarEleccion(aleatorio);
                    }
                    
                    if(5 <= jugadores){
                        i++;
                        aleatorio.setJugador(i);
                        opcion5 = Integer.parseInt(request.getParameter("opcion5"));
                        aleatorio.setEleccion(opcion5);
                        interaccion.IngresarEleccion(aleatorio);
                    }
                    
                    if(6 <= jugadores){
                        i++;
                        aleatorio.setJugador(i);
                        opcion6 = Integer.parseInt(request.getParameter("opcion6"));
                        aleatorio.setEleccion(opcion6);
                        interaccion.IngresarEleccion(aleatorio);
                    }
                    
                    switch(jugadores){
                        case 2:{
                            if(opcion1 == opcion2){
                                mensaje ="Las apuestas deben ser diferentes.";
                                a = 1;
                            }
                        };
                        break;
                        case 3:{
                            if(opcion1 == opcion2 || opcion2 == opcion3 || opcion1 == opcion3){
                                mensaje ="Las apuestas deben ser diferentes.";
                                a = 1;
                            }
                        };
                        break;
                        case 4:{
                            if(opcion1 == opcion2 || opcion2 == opcion3 || opcion1 == opcion3
                                    || opcion4 == opcion1 || opcion4 == opcion2 || opcion4 == opcion3){
                                mensaje ="Las apuestas deben ser diferentes.";
                                a = 1;
                            }
                        };
                        break;
                        case 5:{
                            if(opcion1 == opcion2 || opcion2 == opcion3 || opcion1 == opcion3
                                    || opcion4 == opcion1 || opcion4 == opcion2 || opcion4 == opcion3
                                    || opcion5 == opcion1 || opcion5 == opcion2 || opcion5 == opcion3
                                    || opcion5 == opcion4){
                                mensaje ="Las apuestas deben ser diferentes.";
                                a = 1;
                            }
                        };
                        break;
                        case 6:{
                            if(opcion1 == opcion2 || opcion2 == opcion3 || opcion1 == opcion3
                                    || opcion4 == opcion1 || opcion4 == opcion2 || opcion4 == opcion3
                                    || opcion5 == opcion1 || opcion5 == opcion2 || opcion5 == opcion3
                                    || opcion5 == opcion4 || opcion6 == opcion1 || opcion6 == opcion2
                                    || opcion6 == opcion3 || opcion6 == opcion4 || opcion6 == opcion5){
                                mensaje ="Las apuestas deben ser diferentes.";
                                a = 1;
                            }
                        }
                    }
                    
                    if (a == 1){
                        request.setAttribute("jugadores", jugadores);
                        request.setAttribute("mensaje", mensaje);
                        request.setAttribute("opcion1", opcion1);
                        request.setAttribute("opcion2", opcion2);
                        request.setAttribute("opcion3", opcion3);
                        request.setAttribute("opcion4", opcion4);
                        request.setAttribute("opcion5", opcion5);
                        request.setAttribute("opcion6", opcion6);
                        getServletContext().getRequestDispatcher("/Repeticion/RepeticionInter.jsp").forward(request, response);
                    }else{
                        for(i = 0; i < 18; i++){
                            do{
                                a = (int) (Math.random() * 7);
                            }while(a == 0);
                            
                            aleatorio.setEleccion(a);
                            
                            a = interaccion.VerificarEleccion(aleatorio);
                            
                            if (a == 1){
                                aleatorio = interaccion.ListarEleccion(aleatorio);
                                interaccion.ActualizarAciertos(aleatorio);
                            }
                        }
                        
                        a = interaccion.VerficarMaximo();
                        
                        b = interaccion.VerficarRepeticion(a);
                        
                        if (b == 1)
                            mensaje = interaccion.VerficarGanador(a);
                        else
                            mensaje = "Hay mas de un ganador.";
                        
                        lista = interaccion.ListarJugadores();
                        
                        request.setAttribute("jugadores", jugadores);
                        request.setAttribute("mensaje", mensaje);
                        request.setAttribute("lista", lista);
                        getServletContext().getRequestDispatcher("/Repeticion/RepeticionFrm.jsp").forward(request, response);
                    }
                }
            }
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

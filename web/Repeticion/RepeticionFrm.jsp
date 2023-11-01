
<%@page import="java.util.ArrayList"%>
<%@page import="Datos.Aleatorio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int jugadores = (Integer) request.getAttribute("jugadores");
    ArrayList<Aleatorio> lista = null;
    lista = (ArrayList<Aleatorio>) request.getAttribute("lista");
    String mensaje = (String) request.getAttribute("mensaje");
    String opcion1 = "op=1" + "&jugadores=" + jugadores;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conclusion</title>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <form action="<%=request.getContextPath()%>/RepeticionServlet" method="POST">
                <input type="hidden" id="jugadores" name="jugadores" value="<% out.print(jugadores);%>">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <center><h1>Eleccion</h1></center>
                    </div>
                    <br>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-4">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Jugador:</th>
                                            <th>Numero Elegido:</th>
                                            <th>Aciertos:</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for(Aleatorio obj : lista){
                                        %>
                                        <tr>
                                            <td><% out.print(obj.getJugador());%></td>
                                            <td><% out.print(obj.getEleccion());%></td>
                                            <td><% out.print(obj.getAciertos());%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                                
                            </div>
                            <div class="col-sm-4">
                                <label><% out.print(mensaje);%></label>
                            </div>
                            <div class="col-sm-2"></div>
                        </div>
                        <br><br>
                        <div class="row">
                            <div class="col-sm-4">
                                <center>
                                    <a href="<%=request.getContextPath()%>/RepeticionServlet?<% out.print(opcion1);%>">
                                        <button type="button" class="btn btn-info">
                                            Volver a Elegir
                                        </button>
                                    </a>
                                </center>
                            </div>
                            <div class="col-sm-4">
                                <center>
                                    <a href="<%=request.getContextPath()%>/Repeticion/RepeticionMenu.jsp">
                                        <button type="button" class="btn btn-danger">
                                            Reiniciar
                                        </button>
                                    </a>
                                </center>
                            </div>
                            <div class="col-sm-4">
                                <center>
                                    <a href="<%=request.getContextPath()%>/Menu.jsp">
                                        <button type="button" class="btn btn-success">
                                            Volver al Menu
                                        </button>
                                    </a>
                                </center>
                            </div>
                        </div>
                    </div>
                    <br><br>
                </div>
            </form>
        </div>
    </body>
</html>

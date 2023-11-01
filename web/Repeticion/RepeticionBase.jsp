
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int jugadores = (Integer) request.getAttribute("jugadores");
    String mensaje = (String) request.getAttribute("mensaje");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eleccion</title>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <form action="<%=request.getContextPath()%>/RepeticionServlet" method="POST">
                <input type="hidden" id="op" name="op" value="2">
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
                                <%
                                    for(int i = 1; i <= jugadores; i++){
                                %>
                                <label for="opcion<% out.print(i);%>">
                                    Jugador <% out.print(i);%>:
                                </label>
                                <input type=number class="form-control" id="opcion<% out.print(i);%>"
                                       name="opcion<% out.print(i);%>" min="1" max="6"
                                       placeholder="Elija un numero (1 a 6)." required>
                                <br><br>
                                <%
                                    }
                                %>
                            </div>
                            <div class="col-sm-4">
                                <button type="submit" class="btn btn-success">
                                    Finalizar.
                                </button>
                            </div>
                            <div class="col-sm-2"></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4"></div>
                            <div class="col-sm-4">
                                <%
                                    if (mensaje != null) {
                                %>
                                <label><% out.print(mensaje);%></label>
                                <%
                                    }
                                %>
                            </div>
                            <div class="col-sm-4"></div>
                        </div>
                    </div>
                    <br>
                    <br>
                </div>
            </form>
        </div>
    </body>
</html>

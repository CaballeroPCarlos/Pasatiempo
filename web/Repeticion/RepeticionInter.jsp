
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int jugadores = (Integer) request.getAttribute("jugadores");
    String mensaje = (String) request.getAttribute("mensaje");
    
    int opcion1 = 1;
    int opcion2 = 1;
    int opcion3 = 1;
    int opcion4 = 1;
    int opcion5 = 1;
    int opcion6 = 1;
    
    if(1 <= jugadores)
        opcion1 = (Integer) request.getAttribute("opcion1");
    
    if(2 <= jugadores)
        opcion2 = (Integer) request.getAttribute("opcion2");
    
    if(3 <= jugadores)
        opcion3 = (Integer) request.getAttribute("opcion3");
    
    if(4 <= jugadores)
        opcion4 = (Integer) request.getAttribute("opcion4");
    
    if(5 <= jugadores)
        opcion5 = (Integer) request.getAttribute("opcion5");
    
    if(6 <= jugadores)
        opcion6 = (Integer) request.getAttribute("opcion6");
    
    int a = 1;
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
                                <%
                                    switch(i){
                                        case 1: a = opcion1;break;
                                        case 2: a = opcion2;break;
                                        case 3: a = opcion3;break;
                                        case 4: a = opcion4;break;
                                        case 5: a = opcion5;break;
                                        case 6: a = opcion6;
                                    }
                                %>
                                <input type=number class="form-control" id="opcion<% out.print(i);%>"
                                       name="opcion<% out.print(i);%>" min="1" max="6"
                                       value="<% out.print(a);%>"
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

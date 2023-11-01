
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <center><h1>Elija su habilidad</h1></center>
                </div>
                <br><br>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-3">
                            <a href="<%=request.getContextPath()%>/CombateServlet?op=1&eleccion=1">
                                <center>
                                    <button type="button" class="btn btn-success">
                                        <img src="<%=request.getContextPath()%>/Imagenes/Usuario1.jpg"
                                             width="200px" height="200px">
                                        <br><br>
                                        Habilidad: Vida+
                                    </button>
                                </center>
                            </a>
                            <br><br>
                            <label>Vida y Vida Maxima, Aumentadas.</label>
                        </div>
                        <div class="col-sm-3">
                            <a href="<%=request.getContextPath()%>/CombateServlet?op=1&eleccion=2">
                                <center>
                                    <button type="button" class="btn btn-danger">
                                        <img src="<%=request.getContextPath()%>/Imagenes/Usuario2.jpg"
                                             width="200px" height="200px">
                                        <br><br>
                                        Habilidad: Ataque+
                                    </button>
                                </center>
                            </a>
                            <br><br>
                            <label>Ataque y Ataque Maxima, Aumentados.</label>
                        </div>
                        <div class="col-sm-3">
                            <a href="<%=request.getContextPath()%>/CombateServlet?op=1&eleccion=3">
                                <center>
                                    <button type="button" class="btn btn-info">
                                        <img src="<%=request.getContextPath()%>/Imagenes/Usuario3.jpg"
                                             width="200px" height="200px">
                                        <br><br>
                                        Habilidad: Velocidad
                                    </button>
                                </center>
                            </a>
                            <br><br>
                            <label>Ataca dos Veces por Turno.</label>
                        </div>
                        <div class="col-sm-3">
                            <a href="<%=request.getContextPath()%>/CombateServlet?op=1&eleccion=4">
                                <center>
                                    <button type="button" class="btn btn-warning">
                                        <img src="<%=request.getContextPath()%>/Imagenes/Usuario4.jpg"
                                             width="200px" height="200px">
                                        <br><br>
                                        Habilidad: Carga+
                                    </button>
                                </center>
                            </a>
                            <br><br>
                            <label>Ataque Maximo Aumentado.</label>
                        </div>
                    </div>
                </div>
                <br><br>
                <center>
                    <a href="<%=request.getContextPath()%>/Menu.jsp">
                        <button type="button" class="btn btn-primary">
                            <label>MENU</label>
                        </button>
                    </a>
                </center>
            </div>
        </div>
    </body>
</html>

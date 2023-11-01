
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
            <form action="<%=request.getContextPath()%>/RepeticionServlet" method="POST">
                <input type="hidden" id="op" name="op" value="1">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <center><h1>Inicio</h1></center>
                    </div>
                    <br>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-4">
                                <label for="jugadores">Cantidad de Jugadores:</label>
                                <input type=number class="form-control" id="jugadores" name="jugadores"
                                       min="1" max="6" placeholder="Ingrese un numero (2 a 6)."
                                       required>
                            </div>
                            <div class="col-sm-4">
                                <button type="submit" class="btn btn-success">
                                    Siguiente.
                                </button>
                            </div>
                            <div class="col-sm-2"></div>
                        </div>
                    </div>
                    <br>
                    <br>
                </div>
            </form>
        </div>
    </body>
</html>

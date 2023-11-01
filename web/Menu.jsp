
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            .carousel-inner .item img {
                border: 0.1cm solid black;
            }
        </style>
    </head>
    <body data-spy="scroll" data-target=".navbar" data-offset="50">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#">Menu</a>
                </div>
                <div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li><a href='#juego1'>Combate contra Boss</a></li>
                            <li><a href='Repeticion/RepeticionMenu.jsp'>Apuesta</a></li>
                            <li><a href='#juego2'>Combate uno contra uno</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div id="juego1" class="container-fluid" style="background-color: #5e4a11;">
            <br><br><br><br><br><br>
            <h2></h2>
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active" style="background-color: #808080;"></li>
                    <li data-target="#myCarousel" data-slide-to="1" style="background-color: #808080;"></li>
                    <li data-target="#myCarousel" data-slide-to="2" style="background-color: #808080;"></li>
                    <li data-target="#myCarousel" data-slide-to="3" style="background-color: #808080;"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="item active">
                        <center>
                            <img src="<%=request.getContextPath()%>/Imagenes/Caballero.jpg"
                                 width="400px" height="400px">
                        </center>
                    </div>
                    <div class="item">
                        <center>
                            <img src="<%=request.getContextPath()%>/Imagenes/Enemigo.jpg"
                                 width="400px" height="400px">
                        </center>
                    </div>
                    <div class="item">
                        <center>
                            <img src="<%=request.getContextPath()%>/Imagenes/Victoria.jpg"
                                 width="600px" height="400px">
                        </center>
                    </div>
                    <div class="item">
                        <center>
                            <img src="<%=request.getContextPath()%>/Imagenes/Derrota.jpg"
                                 width="600px" height="400px">
                        </center>
                    </div>
                </div>
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Anterior Imagen</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Siguiente Imagen</span>
                </a>
            </div>
            <br><br>
            <center>
                <a href="Acciones?op=1" style="color: #ff0000;">
                    <h2><label>Probar Juego...</label></h2>
                </a>
            </center>
            <br><br>
        </div>
        
        <div id="juego2" class="container-fluid" style="background-color: #d999e0;">
            <br><br><br><br><br><br>
            <h2></h2>
            <div id="myCarousel2" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel2" data-slide-to="0" class="active" style="background-color: #808080;"></li>
                    <li data-target="#myCarousel2" data-slide-to="1" style="background-color: #808080;"></li>
                    <li data-target="#myCarousel2" data-slide-to="2" style="background-color: #808080;"></li>
                    <li data-target="#myCarousel2" data-slide-to="3" style="background-color: #808080;"></li>
                    <li data-target="#myCarousel2" data-slide-to="4" style="background-color: #808080;"></li>
                    <li data-target="#myCarousel2" data-slide-to="5" style="background-color: #808080;"></li>
                    <li data-target="#myCarousel2" data-slide-to="6" style="background-color: #808080;"></li>
                    <li data-target="#myCarousel2" data-slide-to="7" style="background-color: #808080;"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="item active">
                        <center>
                            <img src="<%=request.getContextPath()%>/Imagenes/Usuario1.jpg"
                                 width="400px" height="400px">
                        </center>
                    </div>
                    <div class="item">
                        <center>
                            <img src="<%=request.getContextPath()%>/Imagenes/Victoria1.jpg"
                                 width="600px" height="400px">
                        </center>
                    </div>
                    <div class="item">
                        <center>
                            <img src="<%=request.getContextPath()%>/Imagenes/Usuario2.jpg"
                                 width="400px" height="400px">
                        </center>
                    </div>
                    <div class="item">
                        <center>
                            <img src="<%=request.getContextPath()%>/Imagenes/Victoria2.jpg"
                                 width="600px" height="400px">
                        </center>
                    </div>
                    <div class="item">
                        <center>
                            <img src="<%=request.getContextPath()%>/Imagenes/Usuario3.jpg"
                                 width="400px" height="400px">
                        </center>
                    </div>
                    <div class="item">
                        <center>
                            <img src="<%=request.getContextPath()%>/Imagenes/Victoria3.jpg"
                                 width="600px" height="400px">
                        </center>
                    </div>
                    <div class="item">
                        <center>
                            <img src="<%=request.getContextPath()%>/Imagenes/Usuario4.jpg"
                                 width="400px" height="400px">
                        </center>
                    </div>
                    <div class="item">
                        <center>
                            <img src="<%=request.getContextPath()%>/Imagenes/Victoria4.jpg"
                                 width="600px" height="400px">
                        </center>
                    </div> 
                </div>
                <a class="left carousel-control" href="#myCarousel2" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Anterior Imagen</span>
                </a>
                <a class="right carousel-control" href="#myCarousel2" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Siguiente Imagen</span>
                </a>
            </div>
            <br><br>
            <center>
                <a href="Lucha2/CombateBase.jsp" style="color: #263895;">
                    <h2><label>Probar Juego...</label></h2>
                </a>
            </center>
            <br><br>
        </div>
    </body>
</html>
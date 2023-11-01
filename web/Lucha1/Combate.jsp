
<%@page import="Datos.Ingresar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Ingresar obj = new Ingresar();
    obj = (Ingresar) request.getAttribute("ing");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Combate</title>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <%
                if(request.getAttribute("fin") == null){
            %>
            <div class="panel panel-warning">
                <div class="panel-heading">
                    <h2><center><label>Turno: <% out.print(obj.getTurno());%></label></center></h2>
                </div>
                <br>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-4">
                            <center>
                                <img src="<%=request.getContextPath()%>/Imagenes/Caballero.jpg"
                                     style="width:70%;">
                            </center>
                            <br><br>
                            <table class="table table-condensed">
                                <tbody>
                                    <tr class="success">
                                        <td><h4><label>Vida Propia:</label></h4></td>
                                        <td>
                                            <h4>
                                                <label>
                                                    <% out.print(obj.getVidaP());%>
                                                </label>
                                            </h4>
                                        </td>
                                    </tr>
                                    <tr class="success">
                                        <td><h4><label>Ataque Propio:</label></h4></td>
                                        <td>
                                            <h4>
                                                <label>
                                                    <% out.print(obj.getAtaqueP());%>
                                                </label>
                                            </h4>
                                        </td>
                                    </tr>
                                    <%
                                        if(request.getAttribute("mensaje2") != null){
                                            String mensaje2 = (String) request.getAttribute("mensaje2");
                                    %>
                                    <tr class="success">
                                        <td colspan="2">
                                            <center>
                                                <h4><label><% out.print(mensaje2);%></label></h4>
                                            </center>
                                        </td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-sm-4">
                            <center>
                                <img src="<%=request.getContextPath()%>/Imagenes/Enemigo.jpg"
                                     style="width:70%;">
                            </center>
                            <br><br>
                            <table class="table table-condensed">
                                <tbody>
                                    <tr class="danger">
                                        <td><h4><label>Vida Enemiga:</label></h4></td>
                                        <td>
                                            <h4>
                                                <label>
                                                    <% out.print(obj.getVidaR());%>
                                                </label>
                                            </h4>
                                        </td>
                                    </tr>
                                    <tr class="danger">
                                        <td><h4><label>Ataque Enemiga:</label></h4></td>
                                        <td>
                                            <h4>
                                                <label>
                                                    <% out.print(obj.getAtaqueR());%>
                                                </label>
                                            </h4>
                                        </td>
                                    </tr>
                                    <%
                                        if(request.getAttribute("mensaje1") != null){
                                            String mensaje1 = (String) request.getAttribute("mensaje1");
                                    %>
                                    <tr class="danger">
                                        <td colspan="2">
                                            <center>
                                                <h4><label><% out.print(mensaje1);%></label></h4>
                                            </center>
                                        </td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                    <%
                                        if(request.getAttribute("mensaje3") != null){
                                            String mensaje3 = (String) request.getAttribute("mensaje3");
                                    %>
                                    <tr class="danger">
                                        <td colspan="2">
                                            <center>
                                                <h4><label><% out.print(mensaje3);%></label></h4>
                                            </center>
                                        </td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                    <%
                                        if(request.getAttribute("mensaje4") != null){
                                            String mensaje4 = (String) request.getAttribute("mensaje4");
                                    %>
                                    <tr class="danger">
                                        <td colspan="2">
                                            <center>
                                                <h4><label><% out.print(mensaje4);%></label></h4>
                                            </center>
                                        </td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-sm-4">
                            <center>
                                <a href="<%=request.getContextPath()%>/Acciones?op=2">
                                    <button type="button" class="btn btn-danger">
                                        <label>ATACAR</label>
                                    </button>
                                </a>
                            </center>
                            <br><br>
                            <center>
                                <a href="<%=request.getContextPath()%>/Acciones?op=3">
                                    <button type="button" class="btn btn-success">
                                        <label>CURAR</label>
                                    </button>
                                </a>
                            </center>
                            <br><br>
                            <center>
                                <a href="<%=request.getContextPath()%>/Acciones?op=4">
                                    <button type="button" class="btn btn-info">
                                        <label>AUMENTAR ATAQUE</label>
                                    </button>
                                </a>
                            </center>
                            <br><br>
                            <center>
                                <a href="<%=request.getContextPath()%>/Menu.jsp">
                                    <button type="button" class="btn btn-primary">
                                        <label>MENU</label>
                                    </button>
                                </a>
                            </center>
                            <br><br>
                            <center>
                                <a href="<%=request.getContextPath()%>/Acciones?op=1">
                                    <button type="button" class="btn btn-success">
                                        <label>RESETEAR</label>
                                    </button>
                                </a>
                            </center>
                        </div>
                    </div>
                </div>
                <br>
                <br>
            </div>
            <%
                } else{
                    int fin = (int) request.getAttribute("fin");
                    if(fin == 1){
            %>
            <div class="panel panel-danger">
                <div class="panel-heading">
                    <h2><center><label>HAS SIDO DERROTADO</label></center></h2>
                </div>
                <br>
                <div class="panel-body">
                    <center>
                        <img src="<%=request.getContextPath()%>/Imagenes/Derrota.jpg" width="600px" 
                             height="400px">
                    </center>
                </div>
                <br>
                <br>
                <div class="row">
                    <div class="col-sm-6">
                        <center>
                            <a href="<%=request.getContextPath()%>/Menu.jsp">
                                <button type="button" class="btn btn-primary">
                                        <label>MENU</label>
                                </button>
                            </a>
                        </center>
                    </div>
                    <div class="col-sm-6">
                        <center>
                            <a href="<%=request.getContextPath()%>/Acciones?op=1">
                                <button type="button" class="btn btn-success">
                                    <label>RESETEAR</label>
                                </button>
                            </a>
                        </center>
                    </div>
                </div>
                <br>
                <br>
            </div>
            <%
                    } else{
            %>
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h2><center><label>HAS CONSEGUIDO LA VICTORIA</label></center></h2>
                </div>
                <br>
                <div class="panel-body">
                    <center>
                        <img src="<%=request.getContextPath()%>/Imagenes/Victoria.jpg" width="600px" 
                             height="400px">
                    </center>
                </div>
                <br>
                <br>
                <div class="row">
                    <div class="col-sm-6">
                        <center>
                            <a href="<%=request.getContextPath()%>/Menu.jsp">
                                <button type="button" class="btn btn-primary">
                                        <label>MENU</label>
                                </button>
                            </a>
                        </center>
                    </div>
                    <div class="col-sm-6">
                        <center>
                            <a href="<%=request.getContextPath()%>/Acciones?op=1">
                                <button type="button" class="btn btn-success">
                                    <label>RESETEAR</label>
                                </button>
                            </a>
                        </center>
                    </div>
                </div>
                <br>
                <br>
            </div>
            <%
                    }
                }
            %>
        </div>
    </body>
</html>

<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.unicid.bean.Produto" %>


<html>
    <head>
        <link rel="stylesheet" type="text/css" href = "estilo.css" />
        <title>Consulta de Produtos</title>
    </head>
   <body>
        <h2 align="center">Consulta de Produtos</h2>
        <jsp:useBean id="produto" scope="session" class="br.edu.unicid.bean.Produto" />
     
		
        <form>
            <center>
            <table>
                <tr>
                    <td>C�digo:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtCod"                             
                           value="<%=produto.getCodigo()%>" readonly="readonly" />
                    </td>
                </tr>
                <tr>
                    <td>Quantidade:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtQuantidade" 
                        value="<%=produto.getQuantidade()%>" readonly="readonly" />
                    </td>
                </tr>
                <tr>
                    <td>Nome:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtNome" 
					value="<%=produto.getNome()%>" readonly="readonly" />
                    </td>
                </tr>
                
                <tr>
                    <td>Descri��o:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtDescricao" 
                    value="<%=produto.getDescricao()%>" readonly="readonly" />
                    </td>
                </tr>
                
				<tr>
					<td colspan="2" align="center"><a href="index.jsp">P�gina 
Principal</a></td>
				</tr>             
             </table>
            </center>
        </form>
    </body>
</html>

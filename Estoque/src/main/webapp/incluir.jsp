<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incluir Produtos</title>
</head>
<body>
	<center>
	<table border="1" width="42%">
	<form action="ServletProduto" method="get">   
		<input type = "hidden" name ="cmd" value="incluir"> <br />
		<tr>
			<th colspan="2"><h1>Cadastro de Produtos</h1></th>
		</tr>	
		<tr>
			<td>C�digo:</td> 
			<td><input type = "text" name = "txtCod"  size="60" maxlength = "60"></td>
			</tr>
		<tr>
			<td>Quantidade:</td> 
			<td><input type = "text" name =  "txtQuantidade" size="60" maxlength = "60"></td>
		</tr>	
		<tr>
			<td>Nome:</td> <td><input type = "text" size="60" name = "txtNome" 
maxlength = "60"></td>
		</tr>
		
		<tr>
			<td>Descri��o:</td> 
			<td><input type = "text" name = "txtDescricao" size="60" maxlength = "60"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Enviar"></td>
		</tr>	
	</form>
	</table>
	</center>
</body>
</html>
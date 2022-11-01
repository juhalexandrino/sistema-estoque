
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.unicid.bean.Produto" %>
<%@ page import="br.edu.unicid.dao.ProdutoDAO" %>


<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>


<html>
<head>
<title>Lista de Produtos</title>
</head>
<body>
	<center>
	<table width= "100%" border="1" cellpadding="2" cellspacing="0">
		<tr>
			<th colspan="4"><h3>Lista de Produtos</h3></th>
		
		</tr>
		<tr>
			<th>Código</th>
			<th>Quantidade</th>
			<th>Nome</th>
			<th>Descricao</th>
			
			 
		</tr>
          	<%
          		
                List <Produto> lista = new ArrayList<Produto>();
                lista = (ArrayList) request.getAttribute("produtosList");
                for(Produto p: lista ){%>
			<tr>
				<td><%=p.getCodigo()%></td>
				<td><%=p.getQuantidade()%></td>
				<td><%=p.getNome()%></td>
				<td><%=p.getDescricao()%></td>				
			</tr>
            <%
                }
          %>
		<tr>
			<td colspan="6" align="center"><a href="index.jsp">Página Principal</a></td>
		</tr>	
	</table>
	</center>
	</body>
</html>
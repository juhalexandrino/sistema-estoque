<%@page contentType="text/html"%>
<%@page pageEncoding="ISO-8859-1"%>


<html>
    <head>
        <title>Atualizar Produtos</title>
    </head>
    <body>
        <h3 align="center">Atualizar Produtos</h3>
        <jsp:useBean id="produto" scope="session" class="br.edu.unicid.bean.Produto" />
        

        <form action="ServletProduto?cmd=atualizar" method="post">
            <center>
            <table>
                <tr>
                    <td>Codigo:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtCod"                             
                            value="<%=produto.getCodigo()%>" readonly="readonly" />
                    </td>
                </tr>
                <tr>
                    <td>Quantidade:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtQuantidade" 
                         value="<%=produto.getQuantidade()%>" />
                    </td>
                </tr>
                <tr>
                    <td>Nome:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtNome"                        
                        value="<%=produto.getNome()%>" />
                    </td>
                </tr>
                
                <tr>
                    <td>Descrição:</td>
                    <td>
                        <input type="text" maxlength="60"  size = "60" name="txtDescricao" 
                        value="<%=produto.getDescricao()%>" />
                    </td>
                </tr>
                
                    <th>
                        <input type="submit" name="btnAlterar" value="Confirmar Atualização" />
                    </th>
                </tr>		
            </table>
            </center>
        </form>
    </body>
</html>

package br.edu.unicid.web;

import java.io.IOException;
import java.nio.charset.CoderMalfunctionError;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.ProdutoDAO;


/**
 * Servlet implementation class ServletProduto
 */
@WebServlet("/ServletProduto")
public class ServletProduto extends HttpServlet {
	

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // a variável cmd indica o tipo de ação - incluir, alterar, consulta.....
        String cmd = request.getParameter("cmd");
        // cria um objeto dao - CRUD
        ProdutoDAO dao;
        // cria um objeto do tipo produto
        Produto produto = new Produto();
        if (cmd != null) {
            try {
                // inicializa os atributos da classe Produto
            produto.setCodigo(Integer.parseInt(request.getParameter("txtCod")));
            produto.setDescricao(request.getParameter("txtDescricao"));
            produto.setNome(request.getParameter("txtNome"));
            produto.setQuantidade(Integer.parseInt(request.getParameter("txtQuantidade")));
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {
        	// cria a instancia do objeto dao
            dao = new ProdutoDAO();
            RequestDispatcher rd = null;
           
            // lista todos os produtos
            if (cmd.equalsIgnoreCase("listar")) {
                List produtosList = dao.todosProdutos();
            
            // cria uma sessão para encaminhar a lista para uma JSP
                request.setAttribute("produtosList", produtosList);
                
            // redireciona para a JSP mostrarProdutosCads
                rd = request.getRequestDispatcher("/mostrarProdutosCads.jsp");
            }
            
            // incluir produto
            else if (cmd.equalsIgnoreCase("incluir")) {
                dao.salvar(produto);
                rd = request.getRequestDispatcher("ServletProduto?cmd=listar");
             
            // consulta produto para exclusão    
            } else if (cmd.equalsIgnoreCase("exc")) {
                produto = dao.procurarProduto(produto.getCodigo());
                HttpSession session = request.getSession(true);
                session.setAttribute("produto", produto);
                rd = request.getRequestDispatcher("/formExcProdutos.jsp");
             
            // exclui produto
            } else if (cmd.equalsIgnoreCase("excluir")) {
                dao.excluir(produto);
                rd = request.getRequestDispatcher("ServletProduto?cmd=listar");
             
            // consulta produto para alteração
            }  else if (cmd.equalsIgnoreCase("atu")) {
                produto = dao.procurarProduto(produto.getCodigo());
                HttpSession session = request.getSession(true);
                session.setAttribute("produto", produto);
                rd = request.getRequestDispatcher("/formAtuProdutos.jsp");
             
            // consulta produto
            } else if (cmd.equalsIgnoreCase("con")) {
                produto = dao.procurarProduto(produto.getCodigo());
                HttpSession session = request.getSession(true);
                session.setAttribute("produto", produto);
                rd = request.getRequestDispatcher("/formConsProdutos.jsp");
            
             // altera produto    
            } else if (cmd.equalsIgnoreCase("atualizar")) {
                dao.atualizar(produto);
                rd = request.getRequestDispatcher("ServletProduto?cmd=listar");
            
            // direciona para a página principal
            } else if (cmd.equalsIgnoreCase("principal")) {
                rd = request.getRequestDispatcher("/index.jsp");
            }            
            // executa a ação de direcionar para a página JSP
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    } 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }}
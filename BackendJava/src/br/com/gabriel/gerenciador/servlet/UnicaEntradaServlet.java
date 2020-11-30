package br.com.gabriel.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gabriel.gerenciador.acao.Acao;
import br.com.gabriel.gerenciador.acao.EditaEmpresa;
import br.com.gabriel.gerenciador.acao.ListaEmpresas;
import br.com.gabriel.gerenciador.acao.MostraEmpresa;
import br.com.gabriel.gerenciador.acao.NovaEmpresa;
import br.com.gabriel.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")

public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramsAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") ==  null; 
		boolean ehUmaAcaoProtegida = !(paramsAcao.equals("Login") || paramsAcao.equals("LoginForm"));
		
		if( ehUmaAcaoProtegida && usuarioNaoEstaLogado ) {
			response.sendRedirect( "entrada?acao=LoginForm" );
			return;
		}
		
		String nomeDaClasse = "br.com.gabriel.gerenciador.acao." + paramsAcao;
		String nome;
		
		try {
			Class classe =  Class.forName(nomeDaClasse); //carrega a classe com nome;
			Object obj = classe.newInstance();
			Acao acao = (Acao) obj;
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEEndereco = nome.split(":");
		
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher( tipoEEndereco[1] );
			rd.forward(request, response);
		} else {
			response.sendRedirect( tipoEEndereco[1] );
		}
		
	/*	
		if (paramsAcao.equals("ListaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(request, response );
			
		} else if (paramsAcao.equals("RemoveEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.executa(request,response);
			
		} else if ( paramsAcao.equals("MostraEmpresa")){
			MostraEmpresa acao = new MostraEmpresa();
			nome = acao.executa(request, response );
			
		} else if ( paramsAcao.equals("EditaEmpresa")) {
			EditaEmpresa acao = new EditaEmpresa();
			nome = acao.executa(request,response);
			
		}else if ( paramsAcao.equals("NovaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executa(request,response);
		}
		*/
		
	}
}

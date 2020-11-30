package br.com.gabriel.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao {
	
	public String executa (HttpServletRequest request, HttpServletResponse response) throws IOException {
		Banco banco = new Banco();
		String req = request.getParameter("id");
			
		Integer id = Integer.valueOf(req);
		banco.removeEmpresa(id);
			
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
	
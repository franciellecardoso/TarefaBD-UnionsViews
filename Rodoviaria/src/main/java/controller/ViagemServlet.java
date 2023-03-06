package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Viagem;
import persistence.GenericDao;
import persistence.ViagemDao;

@WebServlet("/viagem")
public class ViagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViagemServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String placa = request.getParameter("placa");
		String hora_saida = request.getParameter("hora_saida");
		String hora_chegada = request.getParameter("hora_chegada");
		String partida = request.getParameter("partida");
		String destino = request.getParameter("destino");

		String botao = request.getParameter("botao");

		GenericDao gDao = new GenericDao();
		ViagemDao vDao = new ViagemDao(gDao);

		Viagem v = new Viagem();
		List<Viagem> viagens = new ArrayList<>();
		String erro = "";
		String saida = "";

		try {

			if (botao.equals("Buscar")) {

				v = valido(codigo, placa, hora_saida, hora_chegada, partida, destino, botao);
				v = vDao.select(v);
			}

		} catch (SQLException | ClassNotFoundException | IOException e) {
			erro = e.getMessage();
		} finally {

			request.setAttribute("viagem", v);
			request.setAttribute("viagens", viagens);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			RequestDispatcher rd = request.getRequestDispatcher("viagem.jsp");
			rd.forward(request, response);
		}
	}

	private Viagem valido(String codigo, String placa, String hora_saida, String hora_chegada, String partida,
			String destino, String botao) throws IOException {

		Viagem v = new Viagem();

		if (botao.equals("Buscar")) {
			if (codigo.equals("")) {
				throw new IOException("Preencher Codigo de Viagem");
			} else {
				v.setCodigo(Integer.parseInt(codigo));
			}
		}
		return v;
	}
}

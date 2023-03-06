package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Motorista;
import model.Onibus;
import model.Viagem;

public class ViagemDao implements ICRUDDao<Viagem> {

	private GenericDao gDao;

	public ViagemDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public void insert(Viagem v) throws SQLException, ClassNotFoundException {
	}

	@Override
	public void update(Viagem v) throws SQLException, ClassNotFoundException {

	}

	@Override
	public void delete(Viagem v) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "DELETE viagem WHERE codigo = ? ";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, v.getCodigo());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public Viagem select(Viagem v) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT * FROM v_descricao_viagem WHERE Codigo_Viagem = ?";
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, v.getCodigo());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Motorista m = new Motorista();
			m.setCodigo(rs.getInt("codigo"));
			m.setNome(rs.getString("nome"));
			m.setNaturalidade(rs.getString("naturalidade"));

			Onibus o = new Onibus();
			o.setPlaca(rs.getString("placa"));
			o.setMarca(rs.getString("marca"));
			o.setAno(rs.getInt("ano"));
			o.setDescricao(rs.getString("descricao"));

			v.setCodigo(rs.getInt("codigo"));
			v.setPlaca(rs.getString("placa"));
			v.setHora_saida(rs.getInt("hora_saida"));
			v.setHora_chegada(rs.getInt("hora_chegada"));
			v.setPartida(rs.getString("partida"));
			v.setDestino(rs.getString("chegada"));
			v.setOnibus(o);
			v.setMotorista(m);

		}
		rs.close();
		ps.close();
		c.close();
		return v;
	}

	@Override
	public List<Viagem> list() throws SQLException, ClassNotFoundException {
		return null;
	}
}

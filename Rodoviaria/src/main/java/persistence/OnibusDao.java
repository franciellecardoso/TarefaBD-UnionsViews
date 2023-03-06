package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Onibus;

public class OnibusDao implements ICRUDDao<Onibus> {

	private GenericDao gDao;

	public OnibusDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public void insert(Onibus o) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO onibus VALUES (?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, o.getPlaca());
		ps.setString(2, o.getMarca());
		ps.setInt(3, o.getAno());
		ps.setString(4, o.getDescricao());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void update(Onibus o) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "UPDATE onibus SET marca = ?, ano = ?, descricao = ? WHERE placa = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, o.getMarca());
		ps.setInt(2, o.getAno());
		ps.setString(3, o.getDescricao());
		ps.setString(4, o.getPlaca());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void delete(Onibus o) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "DELETE onibus WHERE placa = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, o.getPlaca());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public Onibus select(Onibus o) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT * FROM v_descricao_onibus WHERE placa = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, o.getPlaca());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			o.setMarca(rs.getString("marca"));
			o.setAno(rs.getInt("ano"));
			o.setDescricao(rs.getString("descricao"));
		}
		ps.execute();
		ps.close();
		c.close();
		return o;
	}

	@Override
	public List<Onibus> list() throws SQLException, ClassNotFoundException {
		return null;
	}

}

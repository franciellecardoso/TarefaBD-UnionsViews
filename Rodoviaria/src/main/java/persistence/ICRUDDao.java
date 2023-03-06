package persistence;

import java.sql.SQLException;
import java.util.List;

public interface ICRUDDao<T> {
	public void	insert(T t) throws SQLException, ClassNotFoundException;
	public void	update(T t) throws SQLException, ClassNotFoundException;
	public void	delete(T t) throws SQLException, ClassNotFoundException;
	public T select(T t) throws SQLException, ClassNotFoundException;
	public List<T> list() throws SQLException, ClassNotFoundException;
}

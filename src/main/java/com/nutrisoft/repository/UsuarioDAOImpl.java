package com.nutrisoft.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nutrisoft.model.Usuario;
import com.nutrisoft.model.enums.PerfilEnum;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private DataSource dataSource;

	public void addUsuario(Usuario usuario) {}
	
	public void updateUsuario(Usuario usuario) {}

	public List<Usuario> listUsuarios() {
		String sql = "SELECT t1.id,t1.nome,t1.email,t2.login,t2.perfil FROM pessoa t1,usuario t2 WHERE t2.id = t1.id";
		return (List<Usuario>) new NamedParameterJdbcTemplate(dataSource).query(sql, new HashMap<String, String>(), new RowMapper<Usuario>() {
			@Override
			public Usuario mapRow(ResultSet rs, int linha) throws SQLException {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setPerfil(PerfilEnum.getById(rs.getInt("id")));
				return usuario;
			}
		});
	}

	public Usuario getUsuarioById(int id) {
		return null;
	}
	
	public Usuario getUsuarioByLoginSenha(String login, String senha) {
		String sql = "SELECT t1.id,t1.nome,t1.email,t2.login,t2.perfil FROM pessoa t1,usuario t2 WHERE t2.id = t1.id and t2.login=:login and t2.senha=md5(:senha);";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("login", login);
		params.put("senha", senha);
		
		return (Usuario) new NamedParameterJdbcTemplate(dataSource).queryForObject(sql, params, new RowMapper<Usuario>() {
			@Override
			public Usuario mapRow(ResultSet rs, int linha) throws SQLException {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setPerfil(PerfilEnum.getById(rs.getInt("id")));
				return usuario;
			}
		});
	}
	
	public void removeUsuario(int id) {}
}
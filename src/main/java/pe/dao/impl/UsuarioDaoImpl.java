package pe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import pe.dao.UsuarioDao;
import pe.model.LoginForm;
import pe.model.Usuario;
import pe.util.DBUtil;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{

	@Override
	public Usuario doLogin(LoginForm loginForm) {
		// TODO Auto-generated method stub
		Usuario usuario = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getCon();
			ps = con.prepareStatement("select * from usuario where login = ? and clave = ? and activo = ? ");
			ps.setString(1, loginForm.getLogin());
			ps.setString(2, loginForm.getClave());
			ps.setInt(3, 1);
			rs = ps.executeQuery();
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("id_usuario"));
				usuario.setLogin(rs.getString("login"));
				usuario.setClave(rs.getString("clave"));
				usuario.setActivo(rs.getInt("activo"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeResource(rs);
			DBUtil.closeResource(ps);
			DBUtil.closeResource(con);
		}
		return usuario;
	}
}

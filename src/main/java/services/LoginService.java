package services;

import java.sql.SQLException;

//import model.User;
import model.Usuario;
//import model.nullobjects.NullUser;
import persistence.DAO;
//import persistence.UserDAO;
import persistence.UsuarioDAO;
import utils.Crypt;

public class LoginService {
	
	public Usuario login(String usuario, String clave) throws SQLException {
		UsuarioDAO dao = DAO.getUsuarioDAO();
    	Usuario usuarioEncontrado = dao.buscarPorUsuario(usuario);
    	
    	if (usuarioEncontrado != null && Crypt.match(clave, usuarioEncontrado.getClave())) {
    		return usuarioEncontrado;
    	}
    	
    	return null;
	}
}

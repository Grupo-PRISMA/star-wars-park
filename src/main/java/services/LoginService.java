package services;

import java.sql.SQLException;

//import model.User;
import model.Usuario;
//import model.nullobjects.NullUser;
import persistence.DAO;
//import persistence.UserDAO;
import persistence.UsuarioDAO;
//import persistence.commons.DAOFactory;

public class LoginService {

	public Usuario login(String usuario, String clave) throws SQLException {
		UsuarioDAO dao = DAO.getUsuarioDAO();
    	Usuario usuarioEncontrado = dao.buscarPorUsuario(usuario);
    	
    	/*if (user.isNull() || !user.checkPassword(password)) {
    		usuarioEncontrado = NullUser.build();
    	}*/
    	if (usuarioEncontrado != null && usuarioEncontrado.getClave().equals(clave)) {
    		//usuarioEncontrado = NullUser.build();
    		return usuarioEncontrado;
    	}
    	
    	return null;
	}
}

package services;

import java.sql.SQLException;

//import model.User;
import model.Usuario;
//import model.nullobjects.NullUser;
import persistence.DAO;
//import persistence.UserDAO;
import persistence.UsuarioDAO;
import utils.Crypt;
//import persistence.commons.DAOFactory;

public class LoginService {

	public Usuario login(String usuario, String clave) throws SQLException {
		UsuarioDAO dao = DAO.getUsuarioDAO();
    	Usuario usuarioEncontrado = dao.buscarPorUsuario(usuario);
    	
    	/*if (user.isNull() || !user.checkPassword(password)) {
    		usuarioEncontrado = NullUser.build();
    	}*/
    	System.out.println(usuarioEncontrado);
    	System.out.println(Crypt.match(clave, usuarioEncontrado.getClave()));
    	if (usuarioEncontrado != null && Crypt.match(clave, usuarioEncontrado.getClave())) {
    		//usuarioEncontrado = NullUser.build();
    		return usuarioEncontrado;
    	}
    	
    	return null;
	}
}

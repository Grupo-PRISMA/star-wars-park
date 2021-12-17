package controller.session;


import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import model.User;
import model.Usuario;
import services.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 8308079314140233763L;
	private LoginService loginService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
	}
	
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String usuario = req.getParameter("usuario");
    	String clave = req.getParameter("clave");
    	
    	Usuario usuarioIdentificado = null;
    	
    	try {
    		usuarioIdentificado = loginService.login(usuario, clave);
    	} catch (Exception e) {
    		System.out.println("Error en login: " + e.getMessage());
    	}
    	
    	if (usuarioIdentificado != null && usuarioIdentificado.isActivo()) {
    		req.getSession().setAttribute("usuario", usuarioIdentificado);
    		resp.sendRedirect("index.jsp");    		
       	} else {
    		req.setAttribute("mensaje", "Usuario inexistente o contraseña incorrecta");
    		req.setAttribute("tipo", "danger");
    		
    		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
    		dispatcher.forward(req, resp);
    	}
    }
}

package filters;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
//import model.User;
import model.Usuario;

@WebFilter(urlPatterns = "*.do")
public class LoggedFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		ArrayList<String> seccionesAdmin = new ArrayList<>();
		seccionesAdmin.add("usuario");
		seccionesAdmin.add("tipo-atraccion");
		seccionesAdmin.add("atraccion");
		seccionesAdmin.add("tipo-promocion");
		seccionesAdmin.add("promocion");
		
		//httpServletRequest HttpServletRequest = 
		Usuario usuario = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("usuario");
		
		if (usuario != null) {
			if (!usuario.isAdmin()) {
				String servletPath = ((HttpServletRequest) request).getServletPath(); 
				String seccion = servletPath.substring(1, servletPath.indexOf('/', 1));
				
				if (seccionesAdmin.contains(seccion)) {
					//response.sendRedirect("/star-wars-park/usuario/index.do");
					RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				chain.doFilter(request, response);
			}
		} else {
			request.setAttribute("mensaje", "Por favor, ingresa al sistema");

			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}

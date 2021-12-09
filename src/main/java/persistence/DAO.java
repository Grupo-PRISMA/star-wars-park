package persistence;

public class DAO {
	//private static AtraccionDAO atraccionDAO;
	private static UsuarioDAO usuarioDAO;
	//private static PromocionDAO promocionDAO;
	//private static ItinerarioDAO itinerarioDAO;
	private static TipoAtraccionDAO tipoAtraccionDAO;
	private static TipoPromocionDAO tipoPromocionDAO;
/*
	public static AtraccionDAO getAtraccionDAO() {
		if (atraccionDAO == null) {
			atraccionDAO = new AtraccionDAO();
		}

		return atraccionDAO;
	}
*/
	public static UsuarioDAO getUsuarioDAO() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAO();
		}

		return usuarioDAO;
	}
/*
	public static PromocionDAO getPromocionDAO() {
		if (promocionDAO == null) {
			promocionDAO = new PromocionDAO();
		}

		return promocionDAO;
	}

	public static ItinerarioDAO getItinerarioDAO() {
		if (itinerarioDAO == null) {
			itinerarioDAO = new ItinerarioDAO();
		}

		return itinerarioDAO;
	}
	*/
	public static TipoAtraccionDAO getTipoAtraccionDAO() {
		if (tipoAtraccionDAO == null) {
			tipoAtraccionDAO = new TipoAtraccionDAO();
		}

		return tipoAtraccionDAO;
	}
	
	public static TipoPromocionDAO getTipoPromocionDAO() {
		if (tipoPromocionDAO == null) {
			tipoPromocionDAO = new TipoPromocionDAO();
		}

		return tipoPromocionDAO;
	}
}

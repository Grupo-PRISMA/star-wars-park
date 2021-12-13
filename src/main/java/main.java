import utils.Crypt;

public class main {

	public static void main(String[] args) {
		String clave = Crypt.hash("admin"); 
		System.out.println(clave);
		System.out.println(Crypt.match("admin", clave)); 
		

	}

}

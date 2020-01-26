import java.util.Objects;

/*
 * Esta clase contiene codigo de producto, y permite realizar consultas sobre el mismo
 */

public class Producto implements Comparable<Producto>{
	
	private String codigo;
	
	//constructores 
	public Producto() {
		codigo="000-00000-0";
	}
	public Producto(String cod) {
		if(codigoCorrecto(cod))
			codigo=cod;
		else {
			codigo="000-00000-0";
			System.out.println("Codigo incorrecto");
		}
	}
	
	//define si es prioritario un producto a partir de la letra con la que comienza su codigo.
	public Boolean esPrioritario() {
		Character primerLetra=codigo.charAt(0);
		if(primerLetra.equals('P') || primerLetra.equals('W') || primerLetra.equals('p') || primerLetra.equals('w')) {
			return true;
		}
		return false;
	}
	
	//funcion que determina la correctitud del digito verificador
	public Boolean verificar() {
		String cadenas[]=codigo.split("-");
		String codRegion=cadenas[1];
		String digitoVerif=cadenas[2];
		Integer sumatoria = 0;

		
		while(codRegion.length()>1) {
			for(int i=0;i<codRegion.length();i++) {
				sumatoria+= codRegion.charAt(i)-'0';
			}
			codRegion=sumatoria.toString();
			sumatoria=0;
		}
		if(codRegion.toString().equals(digitoVerif))
			return true;
		return false;
	}
	

	//verifica que coincida el codigo de producto, pasado al constructor, con la regex definida
	private boolean codigoCorrecto(String cod) {
		
		String Regexp = "([A-Z || a-z]{3})[-]([0-9]{5})[-]([0-9])";
		return java.util.regex.Pattern.matches(Regexp, cod);
		
	}
	
	//metodo sobreescrito en pos de mostrar de forma adecuada la informacion de una instancia de la clase
	@Override
	  public String toString() {
	    return "Codigo de producto:\t"+codigo+"\n";
	  }
	
	//se utiliza para que se pueda ordenar con el metodo sort
	//Aclaracion: Ordena por codigo alfabetico de producto, pero también lo está haciendo en funcion de los campos siguientes
	  public int compareTo(Producto prod) {
		  	String compCod=((Producto)prod).getCodigo();
	        return this.codigo.compareToIgnoreCase(compCod);

	  }
	  
	  public String getCodigo() {
		return codigo;

	}
	  //Utilizado para los metodos union e interseccion en el main
	  public boolean equals(Producto prod) {
			return this.getCodigo().equalsIgnoreCase(prod.getCodigo());
		}

/*	//Prueba minimalista del funcionamiento
	public static void main(String[] args) {
		Producto prod= new Producto("DCR-88578-9");
		
		if(prod.esPrioritario())
			System.out.println("Es prioritario");
		else	System.out.println("No es prioritario");
		if(prod.verificar())
			System.out.println("Digito verificador correcto");
		else	System.out.println("No es correcto el digito verificador");
	}
*/
}

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/*
 * Clase utilizada para implementar una interfaz en pos de mostrar las funcionalidades,
 * 		ademas de implementar las funciones relacionadas a listas de productos. 
 */
public class Main {

	//Thread Principal
	public static void main(String[] args) {
		Boolean opcionSalir;
		System.out.println("Bienvenido al menu");
		do {
			opcionSalir=desplegarMenu();
		} while(opcionSalir == false);
		
		System.out.println("Cerrando menu");
	}
	
	//metodo encargado de la funcionalidad del menu y la interaccion con el usuario
	public static  Boolean desplegarMenu() {
			
			Scanner scanner = new Scanner (System.in);
			Producto prod;
			List<Producto> listaProd1;
		  	List<Producto> listaProd2;
		  	
		  	mostrarLeyenda();
			switch(leerCaracter(scanner)) {
			//implementa la funcion esPrioritario
			  case 1:
				  System.out.println("Ingresar codigo de Producto");
				 prod = new Producto(scanner.next());
				 if(prod.esPrioritario())	
					 System.out.println("El codigo ingresado es prioritario");
				 else	
					 System.out.println("El codigo ingresado no es prioritario");
				  break;
			//implementa la funcion verificar
			  case 2:
				  System.out.println("Ingresar codigo de Producto");
				  prod = new Producto(scanner.next());
					 if(prod.verificar())	
						 System.out.println("El codigo verificador es correcto");
					 else
						 System.out.println("El codigo verificador no es correcto");
				   break;
			//implementa la funcion de ordenar lista de productos
			  case 3:
				  	ordenarLista();
				    break;
			//implementa la funcion de interseccion	    
			  case 4:
				  	
				  	listaProd1 = cargarLista();
				  	listaProd2 = cargarLista();
				    interseccion(listaProd1, listaProd2);
				    break;
			//implementa la funcion de union	    	    
			  case 5:
				  	listaProd1 = cargarLista();
				  	listaProd2 = cargarLista();
				  	union(listaProd1, listaProd2);
				    break;
		   
			  default:
			    return true;
			}
			
			return false;
			
		}

	private static void ordenarLista() {
		List<Producto> listaProd;
		
		listaProd = cargarLista();
	  	Collections.sort(listaProd);
	  	System.out.println(listaProd.toString());
		
	}

	private static void interseccion(List<Producto> listaProd1, List<Producto> listaProd2) {

		List<Producto> list  = new ArrayList<Producto>();

        for (Producto t1 : listaProd1) {
        	for (Producto t2 : listaProd2) {
        		if(t1.equals(t2)) {
        			list.add(t1);
        		}
        	}
        }

        System.out.println(list.toString());
		
	}

	private static void union(List<Producto> listaProd1, List<Producto> listaProd2){
		Set<Producto> set = new HashSet<Producto>();

        set.addAll(listaProd1);
        set.addAll(listaProd2);

        System.out.println(set.toString());
	}
	
	public static <T> List<T> cargarLista() {
        Set<T> set = new HashSet<T>();
        Scanner scanner = new Scanner (System.in);
        String lectura;
        List<Producto> listaProd1 = new ArrayList<Producto>();
        
	  	System.out.println("Ingresar codigos de Producto respetando el formato XXX-NNNNN-Y");
	  	System.out.println("Para indicar el fin de la lista1, escribir FIN");
	  	lectura=scanner.next();
	  	
	  	while(!lectura.equalsIgnoreCase("fin")){
	  		listaProd1.add(new Producto(lectura));
	  		lectura=scanner.next();
	  	}
	  	
	  	set.addAll((Collection<? extends T>) listaProd1);
        return new ArrayList<T>(set);
    }
	
	private static void mostrarLeyenda() {
		System.out.println("Seleccione la operacion a probar \n"
				+ "Ingresar 1 para verificar si es prioritario \n"
				+ "Ingresar 2 para verificar digito \n"
				+ "Ingresar 3 para ordenar un conjunto de productos\n"
				+ "Ingresar 4 para obtener la interseccion de dos conjuntos de productos\n"
				+ "Ingresar 5 para obtener la union de dos conjuntos de productos\n"
				+ "Ingresar cualquier otro caracter para salir");
		
	}
	
	private static int leerCaracter(Scanner scanner) {
		
		String entrada=scanner.next();
		int i = entrada.charAt(0)-'0';
		return i;
		
	}

}

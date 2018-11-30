import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class MezclaNatural{
	public static Integer[]lectura(){
		File archivo1 = new File("./src/Archivo1.txt");
		FileReader frA1 = null;
		BufferedReader brA1;
		Integer[] arr1 = new Integer[0];
		
		try {// se lee el achivo
			frA1 = new FileReader(archivo1);
			brA1 = new BufferedReader(frA1);
			String lineaArchivo1;
			try {
				lineaArchivo1 = brA1.readLine();
				String[]numeros = lineaArchivo1.split(",");
				arr1 = new Integer[numeros.length];
				for(int i=0; i<=numeros.length-1;i++) {
					Integer intObj = new Integer(numeros[i]);
					arr1[i] = intObj;
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
			e.printStackTrace();
		}try {
			frA1.close();
		}catch (IOException e) {
			System.out.println("Error al cerrar el archivo");
		}
		return arr1;
	}
	private static Comparable[]aux;
	public static void ordenamientoMezclaNatural(Comparable[] a) {//Originalmente es el
		aux = new Comparable[a.length];								//que se manda a llamar
		ordenamientoMezclaNatural(a, 0, a.length-1);
		mostrar(a);
	}
	public static boolean estaOrdenado(Comparable[] a) {//Para ver si el arreglo ya esta ordenado
		for(int i=1; i<a.length; i+= 1) {
			if (a[i-1].compareTo(a[i]) > 0) {
				return false;
			}
		}
		return true;
	}
	//Se sobrecarga el metodo con diferentes parametros
	private static void ordenamientoMezclaNatural(Comparable[] a, int primero, int ultimo) {
		int i = primero;
		int j = 0;
		int medio = 0;
		int az = 0;
		while(true) {
			i=0;
			while (i < a.length) {
				if(i == a.length-1) {
					break;
				}else if(a[i].compareTo(a[i+1]) > 0) {
					break;
				}
				i++;
			}
			j = i+1;
			while(j < a.length) {
				if(j == a.length-1) {
					break;
				}else if (a[j].compareTo(a[j+1]) > 0) {
					break;
				}
				j++;
			}
			// medio = primero + (j - primero)/2;
			Mezcla(a, primero, i, j);
			primero = 0;
			
			if(estaOrdenado(a)) {
				break;
			}
		}
	}
	public static void Mezcla(Comparable[]a, int primero, int medio, int ultimo) {
		int i = primero;
		int j = medio +1;
		for(int k=primero; k <= ultimo; k++) {
			aux[k] = a[k];
		} 
		for(int k = primero; k <= ultimo; k++) {
			if(i > medio) {
				a[k] = aux[j++];
			}else if (j > ultimo) {
				a[k] = aux[i++];
			}else if(aux[i].compareTo(aux[j]) > 0) {
				a[k] = aux[j++];
			}else {
				a[k] = aux[i++];
			}
		}
	}
	public static void mostrar(Comparable[] a) {
		for (int i=0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}
}//class mezclaNatural
public class NaturalMerge {
	public static void main(String[] args) {
	MezclaNatural mn = new MezclaNatural();
	mn.mostrar(mn.lectura());
	System.out.println("");
	mn.ordenamientoMezclaNatural(mn.lectura());

	}

}
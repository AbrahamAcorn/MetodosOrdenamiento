import java.util.Arrays;
import java.util.Scanner;

class MetodosOrdenamiento{
	public void muestraVector(int vector[]) {
		System.out.println(Arrays.toString(vector));
	}
	public int[] llenaVector(int tam) {
		int vector[]=new int[tam];
		
		for (int i=0;i<tam;i++) {
			vector[i]=(int) (Math.random() * 100);
		}
		return vector;
	}
	public void comparador(long init,long fin,int compars,int intercam,int recors) {
		System.out.println("Tiempo: "+(fin-init));
		System.out.println("Comparaciones: "+compars);
		System.out.println("Intercambios: "+intercam);
		System.out.println("Recorridos: "+recors);
	}
	
	public void ordenamientoBurbuja1(int[] numeros) {
		int recorrido=0, compas=0, intercambios=0,aux=0;
		
		long init = System.nanoTime();
		
		for(int i=2; i <= numeros.length; i++) {
			for(int j=0; j <= numeros.length-i; j++) {
				
				compas++;
				if(numeros[j] > numeros[j+1]) {
					aux = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = aux;
					intercambios++;
				}
				recorrido++;
			}
		}
		//tiempo final
		long fin=System.nanoTime();
		
		comparador(init,fin,compas,intercambios,recorrido);
		
	}
	public void ordenamientoBurbuja2(int[] numeros) {
		int recorrido=0, compas=0, intercambios=0, aux=0;	
		int i=1;
		boolean ordenado = false;
		
		long init = System.nanoTime();
		
		while( (i < numeros.length) && (ordenado == false)) {
			i=i+1;
			ordenado=true;
			for(int j=0; j <= numeros.length -i; j++) {
				compas++;
				if(numeros[j] > numeros[j+1]) {
					ordenado = false;
					aux = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = aux;
					intercambios++;
				}
				recorrido++;
			}
		}
		
		long fin = System.nanoTime();
	
		comparador(init,fin,compas,intercambios,recorrido);
	}
 public void ordenamientoBurbuja3(int[] numeros) {
		
		int recorrido=0, compas=0, intercambios=0,aux=0;
		
		int i=1;
		boolean ordenado;
		
		long init = System.nanoTime();
		
		do {
			i=i+1;
			ordenado = true;
			
			for(int j=0; j <= numeros.length-i; j++) {
				compas++;
				if(numeros[j] > numeros[j+1]) {
					intercambios++;
					aux = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = aux;
				}
				recorrido++;
			}
		} while( (i < numeros.length) && (ordenado == true) );
		
		long fin = System.nanoTime();
		
		comparador(init,fin,compas,intercambios,recorrido);
	}
 public void ordenamientoPorSeleccion(int[] numeros) {
		int recorrido=0, intercambios=0, compas=0,aux=0;
		long init = System.nanoTime();
		for(int i=0;i<numeros.length;i++) {
			int minimo=i;
			for(int j=i+1;j<numeros.length;j++) {
				if(numeros[j]<numeros[minimo]) {
					minimo = j;
					intercambios++;
				}
				 aux = numeros[i];
				numeros[i]= numeros[minimo];
				numeros[minimo]=aux;
				compas++;
			}
			recorrido++;
		}
		long fin = System.nanoTime();
		
		comparador(init,fin,compas,intercambios,recorrido);
	}
 
 public void OrdenamientoInsercion(int array[]) {
	 int recorrido=0, intercambios=0, compas=0,aux=0,j=0;
		long init = System.nanoTime();
		
		for(int i=1;i<array.length;i++) {

			aux=array[i];
			j=i-1;
			
			while((j>=0)&&(aux<array[j])) {
				array[j+1]=array[j];
             compas++;
				j--;
			}
			array[j+1]=aux;
			intercambios++;
		}
		long fin=System.nanoTime();
		comparador(init,fin,compas,intercambios,recorrido);
	}
 
}


public class AlgoritmosOrdenamiento {

	public static void main(String[] args) {
		Scanner ent=new Scanner(System.in);
		MetodosOrdenamiento meh=new MetodosOrdenamiento();
		int opc=0;int vector[];
		do {
			System.out.println("Que metodo desa utilizar"+"\n1)Burbuja"+"\n2)seleccion"+"\n3)Insercion");
			opc=ent.nextInt();
		switch(opc) {
		case 1:
			System.out.println("Ordenamiento Burbuja 1");
			vector=meh.llenaVector(1000);
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja1(vector);
			meh.muestraVector(vector);
			System.out.println("Ordenamiento Burbuja 2");
			vector=meh.llenaVector(1000);
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja2(vector);
			meh.muestraVector(vector);
			System.out.println("Ordenamiento Burbuja 3");
			vector=meh.llenaVector(1000);
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja3(vector);
			meh.muestraVector(vector);
			break;
		case 2:
			System.out.println("\nOrdenamiento Seleccion");
			vector=meh.llenaVector(100);
			meh.muestraVector(vector);
			meh.ordenamientoPorSeleccion(vector);
			meh.muestraVector(vector);
			break;
		case 3:
			System.out.println("\nOrdenamiento Insercion");
			vector=meh.llenaVector(100);
			meh.muestraVector(vector);
			meh.OrdenamientoInsercion(vector);
			meh.muestraVector(vector);
			break;
		default:
			System.out.println("Esa no es una opcion");
			break;
		}
		
		
		}while(opc!=3);
		

	}

}

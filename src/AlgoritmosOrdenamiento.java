import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class MetodosOrdenamiento{
	public void muestraVector(int vector[]) {
		for(int i=0;i<vector.length;i++) {
			System.out.print("-["+vector[i]+"]-");
			if(i%20==0) {
				System.out.println();
			}
		}
	}
	public int[] copiaVector(int vector[]) {
		int[] newVect=vector.clone();
		return newVect;
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
 
 public void ordenamientoInsercion(int array[]) {
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
 public void ordenamientoShellSort(int array[]) {
	 int salto, aux, i;
	 int recorrido=0, intercambios=0, compas=0;
	 boolean cambio;
	 long init = System.nanoTime();
	 for(salto=array.length/2;salto!=0;salto/=2) {
		 recorrido++;
		 cambio=true;
		 while(cambio) {
			 compas++;
			 cambio=false;
			 for(i=salto;i<array.length;i++) {
				 
				 if(array[i-salto]>array[i]) {
					 aux=array[i];
					 array[i]=array[i-salto];
					 array[i-salto]=aux;
					 intercambios++;
					 cambio=true;
				 }
			 }
		 }
	 }
	 long fin=System.nanoTime();
	 comparador(init,fin,compas,intercambios,recorrido);
 }
 //quicksort NO FUNCIONA
 public void ordenamientoQuickSort(int numeros[],int primero,int ultimo) {
	 int recorrido = 0,intercambios=0,compas=0;
		
     
     long init =  System.nanoTime();
		int i,j,pivote,aux;
		i = primero;
		j = ultimo;
		pivote = numeros[primero];
		while (i < j) {
         while (numeros[i] <= pivote && i < j) {
             i++;
         }
         while (numeros[j] > pivote) {
             j--;
         }
         if (i < j) {
         	compas++;
             aux = numeros[i];
             numeros[i] = numeros[j];
             numeros[j] = aux;
             intercambios++;
         }
     }
		recorrido++;
		numeros[primero] = numeros[j];
     numeros[j] = pivote;
     intercambios++;
     if (primero < j - 1) {
         ordenamientoQuickSort(numeros, primero, j - 1);
     }
     if (j + 1 < ultimo) {
         ordenamientoQuickSort(numeros, j + 1, ultimo);
     }
     
     long fin = System.nanoTime();
     
     comparador(init,fin,compas,intercambios,recorrido);  
		
 }
 
 public static void radixSort(int[] arr){
     if(arr.length == 0)
         return;
     int[][] np = new int[arr.length][2];
     int[] q = new int[0x100];
     int i,j,k,l,f = 0;
     for(k=0;k<4;k++){
         for(i=0;i<(np.length-1);i++)
             np[i][1] = i+1;
         np[i][1] = -1;
         for(i=0;i<q.length;i++)
             q[i] = -1;
         for(f=i=0;i<arr.length;i++){
             j = ((0xFF<<(k<<3))&arr[i])>>(k<<3);
             if(q[j] == -1)
                 l = q[j] = f;
             else{
                 l = q[j];
                 while(np[l][1] != -1)
                     l = np[l][1];
                 np[l][1] = f;
                 l = np[l][1];
             }
             f = np[f][1];
             np[l][0] = arr[i];
             np[l][1] = -1;
         }
         for(l=q[i=j=0];i<0x100;i++)
             for(l=q[i];l!=-1;l=np[l][1])
                     arr[j++] = np[l][0];
     }
 }
 public void Intercalacion(){
	 File archivo1=new File("./src/Archivo1.txt");//Archivos a leer
		File archivo2=new File("./src/Archivo2.txt");//Archivos a leer
				
		FileReader frA1 = null;
		BufferedReader brA1;
		FileReader frA2 = null;
		BufferedReader brA2;
		
		FileWriter archivo3=null;
		PrintWriter pr=null;
		
		try{//Apertura del archivo de salida para escritura
			archivo3=new FileWriter("./src/ArchivoSalida.txt", false);
			pr=new PrintWriter(archivo3);
			
			try {//Apertura del archivo1 para lectura
				frA1=new FileReader(archivo1);
				brA1=new BufferedReader(frA1);
				String lineaArchivo1;
				
				try {//Apertura del archivo2 para lectura
					frA2=new FileReader(archivo2);
					brA2=new BufferedReader(frA2);
					String lineaArchivo2;
					boolean repetir=true;
					lineaArchivo1=brA1.readLine();
					lineaArchivo2=brA2.readLine();
										
					do{//Se realizan comparaciones mientras la bandera no cambie
						if(Integer.parseInt(lineaArchivo1)<Integer.parseInt(lineaArchivo2)){
							pr.println(lineaArchivo1);
							if((lineaArchivo1=brA1.readLine())==null){
								pr.println(lineaArchivo2);
								while((lineaArchivo2=brA2.readLine())!=null){
									pr.println(lineaArchivo2);
								}
								repetir=false;
							}
						}
						else if(Integer.parseInt(lineaArchivo1)>Integer.parseInt(lineaArchivo2)){
							pr.println(lineaArchivo2);
							if((lineaArchivo2=brA2.readLine())==null){
								pr.println(lineaArchivo1);
								while((lineaArchivo1=brA1.readLine())!=null){
									pr.println(lineaArchivo1);
								}
								repetir=false;
							}
						}
						else{
							pr.println(lineaArchivo1);
							pr.println(lineaArchivo2);
							if((lineaArchivo1=brA1.readLine())==null){
								pr.println(lineaArchivo2);
								while((lineaArchivo2=brA2.readLine())!=null){
									pr.println(lineaArchivo2);
								}
								repetir=false;
							}
							if((lineaArchivo2=brA2.readLine())==null){
								pr.println(lineaArchivo1);
								while((lineaArchivo1=brA1.readLine())!=null){
									pr.println(lineaArchivo1);
								}
								repetir=false;
							}
						}
					}while(repetir);
				} catch (FileNotFoundException e) {
					System.out.println("Error al abrir el archivo");
					//e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					try {
						frA2.close();
					} catch (IOException e) {
						System.out.println("Error al cerrar el archivo");
					}	
				}//Final del archivo2
			} catch (FileNotFoundException e) {
				System.out.println("Error al abrir el archivo");
				//e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					frA1.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el archivo");
				}
			}//Final del archivo1
			System.out.println("Archivos combinados y ordenados correctamente");
		}catch (IOException e){
			System.out.println("Error al abrir o crear el archivo");
		}finally{
			try{
				archivo3.close();
			}catch(IOException e){
				System.out.println("Error al cerrar el archivo");
			}
		}//Final del archivo3	
 }
 
 public void mergeSort(Integer[] array,int lo,int n) {
	 int low=lo;
	 int high=n;
	 if(low>=high) {
		 return;
	 }
	 int middle=(low+high)/2;
	 
	 mergeSort(array,low,middle);
	 mergeSort(array,middle+1,high);
	 int endlow=middle;
	 int starthigh=middle+1;
	 while((lo<=endlow)&&(starthigh<=high)) {
		 if (array[low]<array[starthigh]) {
			 low++;
		 }else {
			 int temp=array[starthigh];
			 for(int k=starthigh-1;k>=low;k--) {
				array[k+1]=array[k]; 
			 }
			 array[low]=temp;
			 low++;
			 starthigh++;
			 }
	 }
 }
 
 
 public void naturalMergeSort() {
	 
 }
}

public class AlgoritmosOrdenamiento {

	public static void main(String[] args) throws NumberFormatException,IOException{
		Scanner ent=new Scanner(System.in);
		MetodosOrdenamiento meh=new MetodosOrdenamiento();
		int opc=0;int vector[],vectorUno[],vectorDiez[],vectorCien[],vectorMillo[];
		vectorUno=meh.llenaVector(1000);
		vectorDiez=meh.llenaVector(10000);
		vectorCien=meh.llenaVector(100000);
		vectorMillo=meh.llenaVector(1000000);
		do {
			System.out.println("Que metodo desa utilizar"+"\n1)Burbuja"+"\n2)seleccion"+"\n3)Insercion"+"\n4)Shellsort"
		+"\n5)QuickSort"+"\nOrdenamiento En archivos"+"\n6)Intercalacion"+"\n7)Mezcla Directa"+"\nMezcla Natural");
			opc=ent.nextInt();
		switch(opc) {
		case 1:
			System.out.println("Ordenamiento Burbuja 1");
			
			System.out.println("-----------------------1,000 datos----------");
			vector=vectorUno.clone();
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja1(vector);
			meh.muestraVector(vector);
			System.out.println("-----------------------10,000 datos----------");
			vector=vectorDiez.clone();
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja1(vector);
			meh.muestraVector(vector);
			System.out.println("-----------------------100,000 datos----------");
			vector=vectorCien.clone();
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja1(vector);
			meh.muestraVector(vector);
			System.out.println("-----------------------1,000,000 datos----------");
			vector=vectorMillo.clone();
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja1(vector);
			meh.muestraVector(vector);
			System.out.println("Ordenamiento Burbuja 2");
			vector=vectorUno.clone();
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja2(vector);
			meh.muestraVector(vector);
			System.out.println("-----------------------10,000 datos----------");
			vector=vectorDiez.clone();
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja2(vector);
			meh.muestraVector(vector);
			System.out.println("-----------------------100,000 datos----------");
			vector=vectorCien.clone();
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja2(vector);
			meh.muestraVector(vector);
			System.out.println("-----------------------1,000,000 datos----------");
			vector=vectorMillo.clone();
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja2(vector);
			meh.muestraVector(vector);
			System.out.println("Ordenamiento Burbuja 3");
			System.out.println("-----------------------1,000 datos----------");
			vector=vectorUno.clone();
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja3(vector);
			meh.muestraVector(vector);
			System.out.println("-----------------------10,000 datos----------");
			vector=vectorDiez.clone();
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja3(vector);
			meh.muestraVector(vector);
			System.out.println("-----------------------100,000 datos----------");
			vector=vectorCien.clone();
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja3(vector);
			meh.muestraVector(vector);
			System.out.println("-----------------------1,000,000 datos----------");
			vector=vectorMillo.clone();
			meh.muestraVector(vector);
			meh.ordenamientoBurbuja3(vector);
			meh.muestraVector(vector);
			break;
		case 2:
			System.out.println("\nOrdenamiento Seleccion");
			System.out.println("Ordenamiento con 1,000 datos");
			vector=vectorUno.clone();
			meh.muestraVector(vector);
			meh.ordenamientoPorSeleccion(vector);
			meh.muestraVector(vector);
			System.out.println("Ordenamiento con 10,000 datos");
			vector=vectorDiez.clone();
			meh.muestraVector(vector);
			meh.ordenamientoPorSeleccion(vector);
			meh.muestraVector(vector);
			System.out.println("Ordenamiento con 100,000 datos");
			vector=vectorCien.clone();
			meh.muestraVector(vector);
			meh.ordenamientoPorSeleccion(vector);
			meh.muestraVector(vector);
			System.out.println("Ordenamiento con 1,000,000 datos");
			vector=vectorMillo.clone();
			meh.muestraVector(vector);
			meh.ordenamientoPorSeleccion(vector);
			meh.muestraVector(vector);
			break;
		case 3:
			System.out.println("\nOrdenamiento Insercion");
			System.out.println("Ordenamiento con 1,000 datos");
			vector=vectorUno.clone();
			meh.muestraVector(vector);
			meh.ordenamientoInsercion(vector);
			meh.muestraVector(vector);
			System.out.println("Ordenamiento con 10,000 datos");
			vector=vectorDiez.clone();
			meh.muestraVector(vector);
			meh.ordenamientoInsercion(vector);
			meh.muestraVector(vector);
			System.out.println("Ordenamiento con 100,000 datos");
			vector=vectorCien.clone();
			meh.muestraVector(vector);
			meh.ordenamientoInsercion(vector);
			meh.muestraVector(vector);
			System.out.println("Ordenamiento con 1,000,000 datos");
			vector=vectorMillo.clone();
			meh.muestraVector(vector);
			meh.ordenamientoInsercion(vector);
			meh.muestraVector(vector);
			break;
		case 4:
			System.out.println("\nOrdenamiento ShellSort");
			System.out.println("Ordenamiento con 1,000 datos");
			vector=vectorUno.clone();
			meh.muestraVector(vector);
			meh.ordenamientoShellSort(vector);
			meh.muestraVector(vector);
			System.out.println("Ordenamiento con 10,000 datos");
			vector=vectorDiez.clone();
			meh.muestraVector(vector);
			meh.ordenamientoShellSort(vector);
			meh.muestraVector(vector);
			System.out.println("Ordenamiento con 100,000 datos");
			vector=vectorCien.clone();
			meh.muestraVector(vector);
			meh.ordenamientoShellSort(vector);
			meh.muestraVector(vector);
			System.out.println("Ordenamiento con 1,000,000 datos");
			vector=vectorMillo.clone();
			meh.muestraVector(vector);
			meh.ordenamientoShellSort(vector);
			meh.muestraVector(vector);
			break;
		case 5:
			System.out.println("\nOrdenamiento QuickSort");
			vector= new int[]{7,8,9,3,6,3,3,26,3};
			meh.ordenamientoQuickSort(vector, 7, 3);
			break;
		case 6:
			meh.Intercalacion();
			break;
		case 7:
			System.out.println("Ordenamiento MergeSort (Mezcla directata)");
			try {
				BufferedReader br=new BufferedReader(new FileReader("./src/Archivo1.txt"));
				ArrayList<Integer> lines=new ArrayList<Integer>();
				String line;
				while((line=br.readLine())!=null) {
					lines.add(Integer.parseInt(line));
				}
				br.close();
				Integer[] inputArray=lines.toArray(new Integer[lines.size()]);
				meh.mergeSort(inputArray, 0, inputArray.length-1);
				for(Integer i:inputArray) {
					System.out.println(i);
				}
			}catch(IOException ie) {
				System.out.println(ie.getMessage());
			}
		break;
		case 8:
			System.out.println("Ordenamiento NaturalMergeSort (Mezcla Narural)");
		case 10:System.out.println("------Salido :v----");
		break;
		default:
			System.out.println("Esa no es una opcion");
			break;
		}
		
		
		}while(opc!=10);
		

	}

}

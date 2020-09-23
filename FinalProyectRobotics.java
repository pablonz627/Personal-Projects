import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
public class ProyectoFinalRobotica {

	public static void main(String[] args) {
		//Nombre del autor: Pablo Navarro Zepeda 
		
		//Matricula del autor: A01284116
		
		//Nombre del programa: ALMACEN 7 ELEVEN
		
		//Descripcion: Programa de almacén de tienda 7 eleven que pueda organizarle a la tienda sus productos y tenga control de que entra y sale a la tienda. 
		//Es importante hacerla para poder ayudar a la empresa en estos tiempos de cuarentena digitalizando sus almacenes. La ventaja que ofrece es que es mucho 
		//mas interactiva con el usuario y puede ser accesada desde casa. El objetivo es que lo usen los empleados para registrar productos y hagan ventas.
		
		String opcion;
		String opc;
		boolean salir = false;
		int opcionInt;
		int conteoprod= 10;
		
		int clave[]  = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String nombre[]  = { "gansito", "takis", "doritos", "oreo", "coca", "sprite", "sabritas", "cafe", "redbull", "hersheys"};
		double precio[]  = { 12.5, 19,9, 25.6, 15.0, 30.0, 18.5, 14.5, 12.0, 35.0, 21.0};
		
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Pablo Navarro Zepeda A01284116");
		System.out.println("¡Almacen 7 Eleven!");
		
		while(!salir){
			System.out.println("");
			System.out.println("Menu de Opciones:");
			System.out.println("A) Altas");
			System.out.println("B) Bajas");
			System.out.println("C) Cambios");
			System.out.println("D) Listado");
			System.out.println("E) Caja");
			System.out.println("F) Imprimir almacen");
			System.out.println("G) Salir");
		
			System.out.println("¿Que opcion desea? (Escribelas en mayusculas)");
			
			opcion = teclado.nextLine();
			opc=opcion.substring(0);
			
			switch(opc) {
				case "A":
						 boolean salirA=false;
						 
						 int claveA;
						 String nombreA;
						 double precioA;
						 
							while (!salirA) {
							System.out.println("");
							System.out.println("Altas: Agregar producto");
							System.out.println("Escribe los siguientes datos:");
							
							System.out.println("Nombre (Debe tener mas de dos caracteres):");
							nombreA= teclado.nextLine();
							
							if (nombreA.length()<=2){
								System.out.println("Nombre invalido. Tiene que tener mas de dos caracteres.");
								
							}else {
								nombre= AgregarNombre(conteoprod,nombre,nombreA); //LLAMA METODO QUE AGREGA ELEMENTO A  ARREGLO NOMBRE
								System.out.println("Precio (Debe tener decimales):");
								precioA = teclado.nextDouble();
								precio= AgregarPrecio(conteoprod,precio,precioA);//LLAMA METODO QUE AGREGA ELEMENTO A  ARREGLO
								
					
								System.out.println("Clave (Debe ser un numero ente 1 y 5000):"); //CONDICION
								claveA = teclado.nextInt();
								
								if (claveA<1 && claveA>5000){
									System.out.println("Ya no ha espacio en el almacen"); //CONDICION
									claveA= claveA-1;
									
								} else {
									clave= AgregarClave(conteoprod,clave,claveA); //LLAMA METODO QUE AGREGA ELEMENTO A ARREGLO CLAVE
								}
								
								conteoprod= clave.length;
								
								
								System.out.println("¿Quieres escribir otro dato? (Escribe 1 si es 'SI' y 2 si es 'NO') "); 
								int respuesta = teclado.nextInt();
								opcion = teclado.nextLine();
								
								if (respuesta == 2){
									salirA = true;
									
								}
							
							}
							
							
							
							}
							break;
					
				
				case "B": 
					
						int claveborrar;
						int indiceB;
						String nombreborrar;
							
							do {
								System.out.println("");
								System.out.println("Bajas: Eliminar producto");
								System.out.println("1) Por Clave");
								System.out.println("2) Por Nombre");
								System.out.println("3) Regresar");
								System.out.println("¿Cual es tu opcion del ejemplo 1-3 ?");
								 
								opcionInt= teclado.nextInt();
								opcion = teclado.nextLine();
								
								switch(opcionInt){
								
								case 1 : 
									System.out.println("");
									System.out.println("Estas son las productos en el almacen:  ");
									ImprimirAlmacenClave(clave,nombre,precio); //METODO QUE IMPRIME ALMACEN DE FORMA ORDENADA (PRRIMERO CLAVE)
									System.out.println("");
									
									System.out.println("Escribe la clave del producto que quieres borrar:");
									claveborrar = teclado.nextInt();
									
									indiceB = -1;
									for (int i=0;i<nombre.length;i++) {		//FOR QUE OBTIENE INDICE DE CLAVEBORRAR Y LO GUARDA EN INDICEB
									    if (clave[i] == claveborrar) {
									        indiceB = i;
									        break;
									    }
									}
									
									clave= RemoverClave(clave,indiceB);
									nombre= RemoverNombre(nombre,indiceB); //METODOS QUE REMUEVEN EL ELEMENTO DE ARREGLO CON EL PARAMETRO DEL INDICE B
									precio= RemoverPrecio(precio,indiceB);
									
									
									System.out.println("");
									System.out.println("Este es el almacen sin el producto que eliminaste:  ");	
									ImprimirAlmacenClave(clave,nombre,precio); //IMRPRIME ARREGLOS YA CON ELEMENTO ELIMINADO
									System.out.println("");
									
									conteoprod = clave.length;
									
									break;
									
								case 2 : 
									System.out.println("");
									System.out.println("Estos son los productos en el almacen:  ");	 //IMRPRIME ARREGLOS DEL ALMACEN (PRIMERO NOMBRE)
									ImprimirAlmacenNombre(clave,nombre,precio);
									System.out.println("");
									
									System.out.println("Escribe el nombre del producto que quieres eliminar:  ");
									nombreborrar = teclado.nextLine();
									
									indiceB = -1;
									for (int i=0;i<nombre.length;i++) {
									    if (nombre[i].equals(nombreborrar)) { //FOR QUE OBTIENE INDICE DE CLAVEBORRAR Y LO GUARDA EN INDICEB
									        indiceB = i;
									        break;
									    }
									}
									
									clave= RemoverClave(clave,indiceB);
									nombre= RemoverNombre(nombre,indiceB); //METODOS QUE ELIMINAN ELEMENTO EN INDICE B
									precio= RemoverPrecio(precio,indiceB);
									
									System.out.println("¡El produtco fue eliminado!");
									
									System.out.println("Este es el almacen sin el producto que eliminaste:  ");	
									
									ImprimirAlmacenNombre(clave,nombre,precio); //METODO QUE IMPRIME LOS ARREGLOS (PRIMERO NOMBRE) CON PRODUCTOS YA ELIMINADOS)
									
									
									conteoprod = clave.length;
									
									break;
								case 3 : break;
								default: System.out.print("¡Opcion Incorrecta!");	
								
								}
							} while(opcionInt<1 && opcionInt<=3);
								
							break;
					
					
				case "C": 
					
					int clavecambiar=0;
					int clavenueva;
					String nombrecambiar;
					String nombrenuevo;
					double preciocambiar;
					double precionuevo;
					int indiceC;
					int decisionC;
					
						do {
							System.out.println("");
							System.out.println("Cambios: Cambiar elemento en producto");
							System.out.println("1) Por Clave");
							System.out.println("2) Por Nombre");
							System.out.println("3) Regresar");
							System.out.println("¿Cual es tu opcion del ejemplo 1-3 ?");
							 
							opcionInt= teclado.nextInt();
							opcion = teclado.nextLine();
							
							switch(opcionInt){
							
							case 1 : 
								
								System.out.println("");
								System.out.println("Estas son los productos en el almacen  ");	
								
								ImprimirAlmacenClave(clave,nombre,precio); //METODO QUE IMPRIME ARREGLOS (PRIMERO CLAVE)
								
								System.out.println("");
								
								System.out.println("¿Que quieres cambiar?");
								System.out.println("1) Clave");
								System.out.println("2) Nombre");
								System.out.println("3) Precio");
								
								decisionC = teclado.nextInt();
								
								switch(decisionC) {
								
										case 1: 
											System.out.println("Escribe la clave del producto que quieres cambiar : ");
											clavecambiar = teclado.nextInt();
												
											indiceC = -1;
											for (int i=0;i<nombre.length;i++) {
											    if (clave[i] == clavecambiar) { //METODO QUE OBTIENE INDICE DE ARREGLO CLAVE QUE TIENE VALOR DE CLAVECAMBIAR
											        indiceC = i;
											        break;
											    }
											}
											
											System.out.println("Escribe la clave nueva del producto:  ");
											clavenueva = teclado.nextInt();
											
											clave[indiceC]= clavenueva; //SE CAMBIA EL VALOR DE LA CLAVE
											
											System.out.println("¡La clave fue cambiada!");
											
											break;
											
											
											
											
										case 2: 
											
											System.out.println("Escribe el nombre del producto que quieres cambiar:  ");
											nombrecambiar = teclado.nextLine();
												
											indiceC = -1;
											for (int i=0;i<nombre.length;i++) {
											    if (nombre[i] == nombrecambiar) {		 //METODO QUE OBTIENE INDICE DE ARREGLO NOMBRE QUE TIENE VALOR DE NOMBRECAMBIAR
											        indiceC = i;
											        break;
											    }
											}
											
											System.out.println("Escribe el nuevo nombre del producto:  ");
											nombrenuevo = teclado.nextLine();
											
											nombre[indiceC]= nombrenuevo; //SE CAMBIA EL VALOR DE LA CLAVE
											
											System.out.println("¡El nombre fue cambiado!");
											
											break;
											
											
										
										case 3: 
											
											System.out.println("Escribe el precio del producto que quieres cambiar:  ");
											preciocambiar = teclado.nextDouble();
												
											indiceC = -1;
											for (int i=0;i<nombre.length;i++) {
											    if (precio[i] == preciocambiar) { //METODO QUE OBTIENE INDICE DE ARREGLO PRECIO QUE TIENE VALOR DE PRECIOCAMBIAR
											        indiceC = i;
											        indiceC = i;
											        break;
											    }
											}
											
											System.out.println("Escribe el nuevo preciodel producto:  ");
											precionuevo = teclado.nextDouble();
											
											precio[indiceC]= precionuevo; //SE CAMBIA EL VALOR DE PRECIO
											
											System.out.println("¡El precio fue cambiado!");
											
											break;
											
											
								}
								
								
								break;
								
								
								
							case 2 : 
								System.out.println("");
								System.out.println("Estas son los productos en el almacen : ");	
								
								ImprimirAlmacenNombre	(clave,nombre,precio);  //METODO QUE IMPRIME ARREGLOS (PRIMERO NOMBRE)
								System.out.println("");
								
								System.out.println("¿Que quieres cambiar?");
								System.out.println("1) Clave");
								System.out.println("2) Nombre");
								System.out.println("3) Precio");
								
								decisionC = teclado.nextInt();
								
								switch(decisionC) {
								
										case 1: 
											System.out.println("Escribe la clave del producto que quieres cambiar : ");
											clavecambiar = teclado.nextInt();
												
											indiceC = -1;
											for (int i=0;i<nombre.length;i++) {      //AQUI SE OBTIENE EL INDICE DEL ARREGLO CLAVE QUE TENGA EL MISMO VALOR QUE CLAVECAMBIAR
											    if (clave[i] == clavecambiar) {
											        indiceC = i;
											        break;
											    }
											}
											
											System.out.println("Escribe la clave nueva del producto:  ");
											clavenueva = teclado.nextInt();
											
											clave[indiceC]= clavenueva; //AQUI SE CAMBIO EL NOMBRE
											
											System.out.println("¡La clave fue cambiada!");
											
											break;
											
											
											
											
										case 2: 
											
											System.out.println("Escribe el nombre del producto que quieres cambiar:  ");
											nombrecambiar = teclado.nextLine();
												
											indiceC = -1;
											for (int i=0;i<nombre.length;i++) {
											    if (nombre[i] == nombrecambiar) {    //AQUI SE OBTIENE EL INDICE DEL ARREGLO NOMBRE QUE TENGA EL MISMO VALOR QUE CLAVECAMBIAR
												    if (clave[i] == clavecambiar) {
											        indiceC = i;
											        break;
											    }
											}
											}
									
											
											System.out.println("Escribe el nuevo nombre del producto:  ");
											nombrenuevo = teclado.nextLine();
											
											nombre[indiceC]= nombrenuevo; //AQUI SE CAMBIA EL NUEVO NOMBRE
											
											System.out.println("¡El nombre fue cambiado!");
											
											break;
											
											
										
										case 3: 
											
											System.out.println("Escribe el precio del producto que quieres cambiar:  ");
											preciocambiar = teclado.nextDouble();
												
											indiceC = -1;
											for (int i=0;i<nombre.length;i++) {
											    if (precio[i] == preciocambiar) {     //AQUI SE OBTIENE EL INDICE DEL ARREGLO PRECIO QUE TENGA EL MISMO VALOR QUE PRECIOCAMBIAR
											        indiceC = i;
											        break;
											    }
											}
											
											System.out.println("Escribe el nuevo precio del producto:  ");
											precionuevo = teclado.nextDouble();
											
											precio[indiceC]= precionuevo; //SE GUARDA EL NUEVO VALOR DEL PRODUCTO
											
											System.out.println("¡El nuevo precio fue cambiado!");
											
											break;
											
											
								}
							
								break;
								
							case 3 : break;
							default: System.out.print("¡Opcion Incorrecta!");	
							
							}
						} while(opcionInt<1 && opcionInt<=3);
							
						break;
						
						
					
				case "D": 
					do {
						System.out.println("");
						System.out.println("Listados: Ordenar productos segun seleccion");
						System.out.println("1) Ordenado por Clave");
						System.out.println("2) Ordenado por Nombre");
						System.out.println("3) Regresar");
						System.out.println("¿Cual es tu opcion del ejemplo 1-3 ?");
						 
						opcionInt= teclado.nextInt();
						opcion = teclado.nextLine();
						
						switch(opcionInt){
						
						case 1 : 
							System.out.println("");
							System.out.println("Almacen ordenado por clave:"); //SE IMPRIME ARREGLOS ORDENADOS POR CLAVE
							ImprimirAlmacenClave(clave,nombre,precio);
							System.out.println("");
							break;
							
						case 2 : 
							System.out.println("");
							System.out.println("Almacen ordenado por nombre:"); //SE IMPRIME ARREGLOS ORDENADOS POR NOMBRE
							ImprimirAlmacenNombre(clave,nombre,precio);
							System.out.println("");
							break;
							
						case 3 : break;
						default: System.out.print("¡Opcion Incorrecta!");	
						
						}
					} while(opcionInt<1 && opcionInt<=3);
						
					break;
					
				case "E":
					
				int claveproductocomprar;	
				int indiceE;
				double totalcuenta = 0;
				int totalproductos=0;
				int respuestaE;
				int numtarjeta;
				int numefectivo;
				int respuestapago;
				
						System.out.println("");
						System.out.println("Caja: Pagar un producto");
						System.out.println("");
						System.out.println("Este es el almacen actual:");
						ImprimirAlmacenClave(clave,nombre,precio);				//MUESTRA LOS PRODUCTOS EN EL ALMACEN(ARRRAYS)
						System.out.println("");
						
						
						
						do {
						System.out.println("Porfavor escribe la clave del producto que quieres comprar:");
						claveproductocomprar = teclado.nextInt();
						
						indiceE = -1;
						for (int i=0;i<nombre.length;i++) {
						    if (clave[i] == claveproductocomprar) { //BUSCA EL INDICE DEL ELEMENTO DEL ARREGLO QUE SEA EL MISMO QUE CLAVEPRODUCTOCOMPRAR
						        indiceE = i;
						        break;
						    }
						}
						
						totalcuenta= totalcuenta+precio[indiceE]; //SE AGREGA EL PRECIO A LA CUENTA 
						totalproductos= totalproductos+1; //SE SUMA UNO AL TOTAL DE PRODUCTOS
						
						System.out.println("¡Tu producto fue agregado al carrito!");
						System.out.println("¿Deseas comprar algo mas? (Escribe 1 es SI o 2 si es NO)");
						respuestaE = teclado.nextInt();
							
						}while (respuestaE==1); //WHILE QUE REPITE PROCESO DE COMPRAR
						
						
						
						
						System.out.println("Tu total a pagar es de: $"+totalcuenta);
						System.out.println("Estas comprando: "+totalproductos+" productos"); //SE IMPRIME CUENTAS Y TOTAL DE PRODUCTOS
						System.out.println(" ");
						System.out.println("¿Deseas pagar con tarjeta o efectivo? (Escribe 1 si es con TARJETA o 2 si es con EFECTIVO)");
						respuestapago = teclado.nextInt();
						
						if (respuestapago == 1) {
							System.out.println("Escribe el numero de tu tarjeta:"); //RECIBE INSTRUCCION Y GUARDA TARJETA EN NUMTARJETA
							numtarjeta = teclado.nextInt();
							
							System.out.println("¡Aprobado!");
							System.out.println("¡Gracias por comprar en 7 Eleven!");
							
						}else  if(respuestapago== 2){
							System.out.println("¿Con cuanto va a pagar?");		//RECIBE INSTRUCCUION Y PIDE CANTIDAD CON LA QUE SE VA A PAGAR
							numefectivo = teclado.nextInt();
							
							System.out.println("Su cambio es de: "+(numefectivo-totalcuenta)); //RESTA LO QUE SE VA A PAGAR CON LA CUENTA Y IMPRIME RESULTADO
							System.out.println("¡Gracias por comprar en 7 Eleven!");
							salir = true;
						}
						
						
					break;
					
					
					
					
				case "F":
					System.out.println("");
					System.out.println("Almacen actual:");
					ImprimirAlmacenClave(clave,nombre,precio);		//IMPRIME ARREGLOS EN ALMACEN
					System.out.println("");
					
					break;
					
					
					
				case "G":
					System.out.print("¡Gracias por usar los almacenes digitales de 7 Eleven!");	 //DESPEDIDA
					salir = true;
					
					break;
					
				
				default: System.out.println("Opcion incorrecta! Escribe solo una letra entre A y F");
				
			
			
			}
			
		}
	
			

	}
	
	
		
		//METODOS PARTE A
	
	public static int[] AgregarClave(int n, int arr[], int x) //METODO QUE AGREGA ELEMENTOS A ARRELGO INT
    { 
        int i; 
  
        
        int newarr[] = new int[n + 1]; 
  
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i]; 
  
        newarr[n] = x; 
  
        return newarr; 
    } 
  
	public static String[] AgregarNombre(int n, String arr[], String x) //METODO QUE AGREGA ELEMENTOS A ARRELGO STRING
    { 
        int i; 
  
        
        String newarr[] = new String[n + 1]; 
  
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i]; 
  
        newarr[n] = x; 
  
        return newarr; 
    } 
  
	public static double[] AgregarPrecio(int n, double arr[], double x) //METODO QUE AGREGA ELEMENTOS A ARRELGO DOUBLE
    { 
        int i; 
  
        
        double newarr[] = new double[n + 1]; 
  
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i]; 
  
        newarr[n] = x; 
  
        return newarr; 
    } 
	
	
	
	
	// METODOS PARTE B
	
	
	public static int[] RemoverClave(int[] arr, int indice)	{ //METODO QUE ELIMINA ELEMENTOS A ARRELGO INT

			if (arr == null || indice < 0 || indice >= arr.length) { 

				 System.out.println("¡El producto no esta en el almacen!");	
		return arr; 
			} 

 
			int[] otroarreglo = new int[arr.length - 1]; 
			
			for (int i = 0, k = 0; i < arr.length; i++) { 

				if (i == indice) { 
					continue; 
				} 
 
				otroarreglo[k++] = arr[i]; 
			} 

			System.out.println("¡El produtco fue eliminado!");
			return otroarreglo; 
		} 
	
	
	
	public static String[] RemoverNombre(String[] arr, int indice)	{   //METODO QUE ELIMINA ELEMENTOS A ARRELGO STRING

		if (arr == null || indice < 0 || indice >= arr.length) { 

			 
	return arr; 
		} 


		String[] otroarreglo = new String[arr.length - 1]; 
		
		for (int i = 0, k = 0; i < arr.length; i++) { 

			if (i == indice) { 
				continue; 
			} 

			otroarreglo[k++] = arr[i]; 
		} 

		
		return otroarreglo; 
	} 
	
	
	
	
	
	public static double[] RemoverPrecio(double[] arr, int indice)	{  //METODO QUE AGREGA ELEMENTOS A ARRELGO DOUBLE

		if (arr == null || indice < 0 || indice >= arr.length) { 

			 
	return arr; 
		} 


		double[] otroarreglo = new double[arr.length - 1]; 
		
		for (int i = 0, k = 0; i < arr.length; i++) { 

			if (i == indice) { 
				continue; 
			} 

			otroarreglo[k++] = arr[i]; 
		} 

		
		return otroarreglo; 
	} 
	
	
	
	public static void ImprimirAlmacenNombre(int[] clave, String[] nombre, double[]precio) { //METODO QUE IMPRIME ARREGLOS ORDENADO POR NOMBRE
		
			
		 
		
		for(int i=0;i<clave.length;i++) {
			System.out.println("Nombre: "+nombre[i]+","+" Clave: "+clave[i]+","+" Precio: "+precio[i]);
		}
		
	}
	
	
	public static void ImprimirAlmacenClave(int[] clave, String[] nombre, double[]precio) { //METODO QUE IMPRIME ARREGLOS ORDENADO POR CLAVE
		
		
		for(int i=0;i<clave.length;i++) {
			System.out.println("Clave: "+clave[i]+","+" Nombre: "+nombre[i]+","+" Precio: "+precio[i]);
		}
		
	}
	
	
}	
	



	

	
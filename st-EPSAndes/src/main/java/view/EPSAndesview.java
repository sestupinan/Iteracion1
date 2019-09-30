package view;

public class EPSAndesview {


	public void printMenu() {
		System.out.println("---------ISIS 1206 - Estructuras de datos----------");
		System.out.println("---------------------Proyecto 2----------------------");
		System.out.println("0. Cargar datos del semestre");
		System.out.println("1. Obtener el ranking de las N franjas horarias que tengan más infracciones");
		System.out.println("2. Realizar el ordenamiento de las infracciones por Localización Geográfica (Xcoord, Ycoord).");
		System.out.println("3. Buscar las infracciones por rango de fechas [Fecha Inicial (Año/Mes/Día), Fecha Final (Año/Mes/Día)].");
		System.out.println("4. Obtener el ranking de los N tipos de infracción(ViolationCode) que tengan más infracciones");
		System.out.println("5. Realizar el ordenamiento de las infracciones por Localización Geográfica en un arbol ordenado(Xcoord, Ycoord).");
		System.out.println("6. Buscar las franjas de fecha-hora donde se tiene un valor acumulado de infracciones en un rango dado [US$ valor inicial, US$ valor final]. .");
		System.out.println("7. Obtener la información de una localización dada (AddressID).");
		System.out.println("8. Obtener las infracciones en un rango de horas [HH:MM:SS inicial, HH:MM:SS final]");
		System.out.println("9. Obtener el ranking de las N localizaciones geográficas (Xcoord, Ycoord) con la mayor cantidad de infracciones.");
		System.out.println("10. Mostrar una gráfica ASCII con la información de las infracciones por código (ViolationCode).");
		System.out.println("11. Salir");
		
		System.out.println("Digite el nï¿½mero de opciï¿½n para ejecutar la tarea, luego presione enter: (Ej., 1):");

	}

	public void printMessage(String mensaje) {
		System.out.println(mensaje);
	}
}

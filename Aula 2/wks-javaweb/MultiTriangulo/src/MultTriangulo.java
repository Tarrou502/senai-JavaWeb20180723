import java.util.Scanner;

public class MultTriangulo {


	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o n�mero de linhas");
		if ( sc.hasNext()) {
			int n = sc.nextInt();
		
			System.out.print("A quantidade de triangulo ");
			int qtd = sc.nextInt();
			for (int i =1; i<= qtd;i++) { 
				ImprimeTrianguloRetangulo(n);
		   	    System.out.print("\n");
			}
			sc.close();
		}
	}
	
	
	public static void ImprimeTrianguloRetangulo(int n) {
		for (int i =1; i<= n;i++) {
			for (int j =1; j<= i;j++) {
				System.out.print("a");
			}	
			System.out.print("\n");
		}
	}
}
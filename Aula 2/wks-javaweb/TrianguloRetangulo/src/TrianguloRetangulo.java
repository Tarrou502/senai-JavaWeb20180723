import java.util.Scanner;

public class TrianguloRetangulo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o número de linhas ");
		if ( sc.hasNext()) {
			int n = sc.nextInt();
			for (int i =1; i<= n;i++) {
				for (int j =1; j<= i;j++) { 	
					System.out.print("a");
				}
				System.out.print("\n");
			}
			sc.close();
		}
	}
}

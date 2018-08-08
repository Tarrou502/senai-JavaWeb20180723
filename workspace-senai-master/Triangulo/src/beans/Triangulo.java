package beans;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Triangulo {
	
	private String letra;
	private int qtde;
	
	public String exibeLetra(){
		letra = JOptionPane.showInputDialog("Digite a letra que deseja exibir");
		qtde = Integer.parseInt(JOptionPane.showInputDialog("Qual a quantidade que deseja exibir de 1 a 3?"));
		if (qtde == 1) {
		return letra;
		}
		else if (qtde == 2) {
			return letra = letra + letra;
			
		}
		else if (qtde == 3) {
			return letra = letra + letra + letra;
		}else
			return "Digite um numero valido";
	}
}
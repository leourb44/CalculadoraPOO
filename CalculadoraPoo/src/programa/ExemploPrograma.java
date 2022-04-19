package programa;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.calculadora.classe.Multiplicacao;
import classe.Subtracao;
import interfaces.ICalculadora;

public class ExemploPrograma {	
		
		public static void main(String args[]) {
			
			Integer opc = 0;
			do {
				opc = menu();
				
				ArrayList<Double> entrada = menuEntradaDados();
				
				Double data[] = new Double[entrada.size()];
				
				for (int i = 0; i < entrada.size(); i++) {
					data[i] = entrada.get(i);
				}
				
				String tipoEntrada = verificaTipoEntrada(data);	
				
				switch (opc) {
				case 1:
					interfaces.ICalculadora soma = new Soma();
					
					if(tipoEntrada.equals
							("inteiro")) {
						System.out.println(soma.calcula(convertDoubleToInt(data)));
					}
					if(tipoEntrada.equals("double")) {
						System.out.println(soma.calcula(data));
					}
					if(tipoEntrada.equals("float")) {
						System.out.println(soma.calcula(convertDoubleToFloat(data)));
					}
					
					break;
				case 2:
					ICalculadora sub = new Subtracao();
					
					if(tipoEntrada.equals("inteiro")) {
						System.out.println(sub.calcula(convertDoubleToInt(data)));
					}
					if(tipoEntrada.equals("double")) {
						System.out.println(sub.calcula(data));
					}
					if(tipoEntrada.equals("float")) {
						System.out.println(sub.calcula(convertDoubleToFloat(data)));
					}
					
					
					break;
				case 3:
					interfaces.ICalculadora div = new Divisao();
					
					if(tipoEntrada.equals("inteiro")) {
						System.out.println(div.calcula(convertDoubleToInt(data)));
					}
					if(tipoEntrada.equals("double")) {
						System.out.println(div.calcula(data));
					}
					if(tipoEntrada.equals("float")) {
						System.out.println(div.calcula(convertDoubleToFloat(data)));
					}
					
					break;
				case 4:
					br.com.calculadora.interfaces.ICalculadora multi = new Multiplicacao();
					
					if(tipoEntrada.equals("inteiro")) {
						System.out.println(multi.calcula(convertDoubleToInt(data)));
					}
					if(tipoEntrada.equals("double")) {
						System.out.println(multi.calcula(data));
					}
					if(tipoEntrada.equals("float")) {
						System.out.println(multi.calcula(convertDoubleToFloat(data)));
					}
					
					break;
				default:
					System.out.println("Finalizando a aplicação...");
					System.exit(0);
					break;
				}
			} while (opc != 0);
			
		}
		
		@SuppressWarnings("resource")
		public static Integer menu() {
			Scanner scan = new Scanner(System.in);
			StringBuilder sb = new StringBuilder();
			sb.append("===================================\n");
			sb.append("=========  CALCULADORA   ==========\n");
			sb.append("===================================\n");
			sb.append("Digite 1 para realizar SOMA \n");
			sb.append("Digite 2 para realizar SUBTRAÇÃO \n");
			sb.append("Digite 3 para realizar DIVISÃO \n");
			sb.append("Digite 4 para realizar MULTIPLICAÇÃO \n");
			sb.append("Digite 0 para encerrar \n");
			
			System.out.println(sb.toString());
			Integer opc = scan.nextInt();
			if(opc == 0) {
				System.exit(0);
			}
			return opc;
		}
		
		@SuppressWarnings("resource")
		public static ArrayList<Double> menuEntradaDados() {
			ArrayList<Double> entrada = new ArrayList<>();
			Scanner scan = new Scanner(System.in);
			StringBuilder sb = new StringBuilder();
			sb.append("===================================\n");
			sb.append("=========  Entrada de Dados   =====\n");
			sb.append("===================================\n");
			
			Integer usuarioQuerContinuar = 0;
			do {			
				System.out.println("Digite o número:");
				if (scan.hasNextDouble()) {
					entrada.add(scan.nextDouble());
				}			
				if (entrada.size() >= 2) {
					System.out.println("Você deseja iserir mais número? [0 - SIM | 1 - NÃO]");
					usuarioQuerContinuar = scan.nextInt();
				}
				
			} while (entrada.size() < 2 || usuarioQuerContinuar == 0);
		
			return entrada;
		}
		
		public static String verificaTipoEntrada(Double[] entrada) {
			Integer numeroEntradaInteiros = 0;
			Integer numeroEntradaFloat = 0;
			Integer numeroEntradaDouble = 0;
			for (int i = 0; i < entrada.length; i++) {
				
				double n = entrada[i];
				
				if ((int) n == n) {
					numeroEntradaInteiros++;
				} else if (Double.toString(n).split("\\.")[1].length() < 7) {
					numeroEntradaFloat++;
				} else {
					numeroEntradaDouble++;
				}			
			}
			
			if (numeroEntradaInteiros > 0 && numeroEntradaFloat == 0 && numeroEntradaDouble == 0) {
				return "inteiro";
			}
			
			if ((numeroEntradaInteiros > 0 || numeroEntradaInteiros == 0) && numeroEntradaFloat > 0 && numeroEntradaDouble == 0) {
				return "float";
			}
			
			return "double";
		}
		
		public static Integer[] convertDoubleToInt(Double[] array) {
		    Integer[] arr = new Integer[array.length];
		    for (int i = 0; i < array.length; i++) {
		        arr[i] = (int) array[i].doubleValue();
		    }
		    return arr;
		}
		
		public static Float[] convertDoubleToFloat(Double[] array) {
		    Float[] arr = new Float[array.length];
		    for (int i = 0; i < array.length; i++) {
		        arr[i] = Float.parseFloat(array[i].toString());
		    }
		    return arr;
		}
		
	}

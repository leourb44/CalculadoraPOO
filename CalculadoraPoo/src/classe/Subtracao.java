package classe;

import interfaces.ICalculadora;

public class Subtracao implements ICalculadora {

	@Override
	public Integer calcula(Integer n1, Integer n2) {

		Integer resultado = null;

		if (n1 == null || n2 == null) {

			System.out.println("Não é possivel realizar a operação sem uma entrada de dados!");

		} else {
			resultado = n1 - n2;
		}

		return resultado;
	}

	@Override
	public Float calcula(Float n1, Float n2) {

		Float resultado = null;

		if (n1 == null || n2 == null) {

			System.out.println("Não é possivel realizar a operação sem uma entrada de dados!");

		} else {
			resultado = n1 - n2;
		}

		return resultado;
	}

	@Override
	public Double calcula(Double n1, Double n2) {
		
		Double resultado = null;

		if (n1 == null || n2 == null) {

			System.out.println("Não é possivel realizar a operação sem uma entrada de dados!");

		} else {
			resultado = n1 - n2;
		}

		return resultado;
	}

	@Override
	public Integer calcula(Integer[] numeros) {
		Integer sub = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			sub -= numeros[i];
		}
		return sub;
	}

	@Override
	public Float calcula(Float[] numeros) {
		Float sub = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			sub -= numeros[i];
		}
		return sub;
	}

	@Override
	public Double calcula(Double[] numeros) {
		Double sub = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			sub -= numeros[i];
		}
		return sub;
	}

}

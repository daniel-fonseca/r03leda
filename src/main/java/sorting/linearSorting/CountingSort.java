package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		boolean isSortable = false;
		
		//verificando se o array eh ordenavel
		if (leftIndex < rightIndex && rightIndex < array.length) {
			isSortable = true;
		}
		
		if (!isSortable) {
			return;
		}
		
		//achando o maior elemento do array de entrada
		int maior = array[leftIndex];
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		
		Integer[] slice = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
		Integer[] sliceOrdenado = countingSort(slice, maior);
		int j = 0;
		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = sliceOrdenado[j];
			j++;
		}
		
	}
	
	private Integer[] countingSort(Integer[] slice, int k) {
		boolean hasZero = false;
		Integer[] sliceOrdenado = new Integer[slice.length];
		
		//verificando se ha elementos iguais a zero no array
		for (int i = 0; i < slice.length; i++) {
			if (slice[i] == 0) {
				hasZero = true;
			}
		}
		
		if (!hasZero) {
			sliceOrdenado = countingSortWithoutZero(slice, k);
		} else {
			sliceOrdenado = countingSortWithZero(slice, k);
		}
		
		return sliceOrdenado;
	}
	
	
	private Integer[] countingSortWithZero(Integer[] slice, int k) {
	//ao inves de termos que um elemento mapeado para um array de contagem cujo indice-1 representa seu valor, teremos esse
	//mapeamento feito para um array de contagem cujo indice representa o proprio elemento. para isso o array de contagem
	//deve ser criado do tamanho do maior elemento + 1.
		int[] contagem = new int[k + 1];
		
		//passo 1: contagem da frequencia de cada elemento
		for (int i = 0; i < slice.length; i++) {
			contagem[slice[i]]++;
		}
		
		//passo 2: soma cumulativa no array de contagem
		for (int i = 1; i < contagem.length; i++) {
			contagem[i] += contagem[i-1];
		}
		
		//passo 3: iterar slice do fim ao inicio registrando em sliceOrdenado os elementos
		Integer[] sliceOrdenado = new Integer[slice.length];
		for (int i = slice.length - 1; i >= 0; i--) {
			sliceOrdenado[contagem[slice[i]] - 1] = slice[i];
			contagem[slice[i]]--;
		}
		
		return sliceOrdenado;	
	}
	
	private Integer[] countingSortWithoutZero(Integer[] slice, int k) {
		int[] contagem = new int[k];
		
		//passo 1: contagem da frequencia de cada elemento
		for (int i = 0; i < slice.length; i++) {
			contagem[slice[i] - 1]++;
		}
		
		//passo 2: soma cumulativa no array de contagem
		for (int i = 1; i < contagem.length; i++) {
			contagem[i] += contagem[i - 1];
		}
		
		
		
		//passo 3: iterar slice do fim ao inicio, registrando em sliceOrdenado os elementos
		Integer[] sliceOrdenado = new Integer[slice.length];
		for (int i = slice.length - 1; i >= 0; i--) {
			sliceOrdenado[contagem[slice[i] - 1] - 1] = slice[i];
			contagem[slice[i] - 1]--;
		}
		
		return sliceOrdenado;
	}

}

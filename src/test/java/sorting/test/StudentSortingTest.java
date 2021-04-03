package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.CountingSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new CountingSort();
		//Assert.fail("Implementation not provided");
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
	
	@Test
	public void testUltimoElementoNoFinal() {
		Integer[] array = {9, 8, 7, 6, 5, 1};
		Integer[] arraySorted = {1, 5, 6, 7, 8, 9};
		implementation.sort(array, 0, 5);
		Assert.assertArrayEquals(arraySorted, array);
	}
	
	@Test
	public void testUltimoElementoNoFinalSlice() {
		Integer[] array = {9, 8, 7, 6, 5, 1};
		Integer[] arraySorted = {5, 6, 7, 8, 9, 1};
		implementation.sort(array, 0, 4);
		Assert.assertArrayEquals(arraySorted, array);
	}
	
	@Test
	public void testUltimoElementoNoFinalSlice2() {
		Integer[] array = {9, 8, 7, 6, 5, 1};
		Integer[] arraySorted = {9, 5, 6, 7, 8, 1};
		implementation.sort(array, 1, 4);
		Assert.assertArrayEquals(arraySorted, array);
	}
	
	
	@Test
	public void testIndexInvalidos() {
		Integer[] array = {9, 8, 7, 6, 5, 1};
		Integer[] arrayExpected = {9, 8, 7, 6, 5, 1};
		implementation.sort(array, 6, 9);
		Assert.assertArrayEquals(arrayExpected, array);
	}
	
	@Test
	public void testLeftIndexInvalido() {
		Integer[] array = {9, 8, 7, 6, 5, 1};
		Integer[] arrayExpected = {9, 8, 7, 6, 5, 1};
		implementation.sort(array, 6, 0);
		Assert.assertArrayEquals(arrayExpected, array);
	}
	
	@Test
	public void testRightIndexInvalido() {
		Integer[] array = {9, 8, 7, 6, 5, 1};
		Integer[] arrayExpected = {9, 8, 7, 6, 5, 1};
		implementation.sort(array, 0, 6);
		Assert.assertArrayEquals(arrayExpected, array);
	}
	
	@Test
	public void testArrayAleatorio() {
		Integer[] array = {32, 24, 79, 125, 20, 3, 72, 124, 475, 2303, 11};
		Integer[] arraySorted = {3, 11, 20, 24, 32, 72, 79, 124, 125, 475, 2303};
		implementation.sort(array, 0, 10);
		Assert.assertArrayEquals(arraySorted, array);
	}
	
	@Test
	public void testArrayIsAlreadySorted() {
		Integer[] array = {3, 11, 20, 24, 32, 72, 79, 124, 125, 475, 2303};
		Integer[] arraySorted = {3, 11, 20, 24, 32, 72, 79, 124, 125, 475, 2303};
		implementation.sort(arraySorted, 0, 10);
		Assert.assertArrayEquals(arraySorted, array);
	}
}
package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoteryService {
	private List<Jogo> jogos;

	private Jogo jogoSorteado;
	private int numSorteio = 0;

	public LoteryService() {
		this.jogos = new ArrayList<Jogo>();
		this.carregaJogos();
	}

	private void carregaJogos() {
		numSorteio = 1451;
		this.jogoSorteado = new Jogo("02", "10", "11", "33", "52", "57");

		this.jogos.add(new Jogo("02", "07", "10", "15", "17", "26")); // Alfredo
		this.jogos.add(new Jogo("03", "05", "07", "17", "50", "54")); // Bourbon
		this.jogos.add(new Jogo("03", "06", "24", "28", "49", "53")); // Bruno V
		this.jogos.add(new Jogo("03", "06", "11", "17", "33", "58")); // Charlau
		this.jogos.add(new Jogo("02", "05", "16", "18", "25", "27")); // Charles
		this.jogos.add(new Jogo("08", "15", "20", "34", "38", "58")); // Danilo
		this.jogos.add(new Jogo("03", "06", "16", "27", "32", "53")); // Edilson
		this.jogos.add(new Jogo("01", "06", "13", "16", "31", "55")); // Erika
		this.jogos.add(new Jogo("07", "15", "23", "28", "35", "46")); // Felipe Ferraz
		this.jogos.add(new Jogo("05", "13", "18", "30", "49", "52")); // Felipe Farias
		this.jogos.add(new Jogo("11", "23", "35", "45", "48", "52")); // Geo
		this.jogos.add(new Jogo("05", "17", "29", "33", "41", "51")); // Glauber
		this.jogos.add(new Jogo("05", "12", "31", "45", "52", "56")); // Henrique
		this.jogos.add(new Jogo("09", "12", "15", "18", "23", "28")); // Ivamacio
		this.jogos.add(new Jogo("06", "08", "16", "21", "24", "34")); // Jorjão
		this.jogos.add(new Jogo("03", "05", "35", "36", "40", "42")); // Leo
		this.jogos.add(new Jogo("13", "16", "17", "23", "28", "32")); // Lu
		this.jogos.add(new Jogo("05", "10", "18", "19", "24", "33")); // Luzinete
		this.jogos.add(new Jogo("02", "06", "15", "20", "25", "27")); // Mauro
		this.jogos.add(new Jogo("09", "12", "19", "23", "25", "59")); // Pether
		this.jogos.add(new Jogo("01", "06", "27", "33", "45", "54")); // Rafael Bacelar
		this.jogos.add(new Jogo("03", "11", "20", "21", "34", "48")); // Rodrigo Borges
		this.jogos.add(new Jogo("13", "33", "36", "45", "48", "52")); // Rodrigo Jardim
		this.jogos.add(new Jogo("02", "07", "16", "20", "30", "39")); // Rodrigo Marroquim
		this.jogos.add(new Jogo("02", "04", "13", "44", "51", "55")); // Stefano
		this.jogos.add(new Jogo("06", "11", "13", "24", "42", "51")); // Jamenson

		this.jogos.add(new Jogo("03", "11", "15", "35", "37", "46")); // Gabi

	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public Jogo getJogoSorteado() {
		return jogoSorteado;
	}

	public void setJogoSorteado(Jogo jogoSorteado) {
		this.jogoSorteado = jogoSorteado;
	}

	public static void main(String[] args) {
		LoteryService rodada = new LoteryService();
		System.out.println(
				"Resultado do sorteio de número " + rodada.numSorteio + ": " + rodada.jogoSorteado.getNumeros() + "\n");
		for (Jogo jogo : rodada.jogos) {
			int quantidadeDeNumeros = 0;
			List<String> numerosAcertados = new ArrayList<String>();
			for (String numero : rodada.jogoSorteado.getNumeros()) {
				if (jogo.getNumeros().contains(numero)) {
					quantidadeDeNumeros++;
					numerosAcertados.add(numero);

				}
			}
			System.out.println("Jogo: " + jogo.getNumeros() + "  -  Acertos: " + quantidadeDeNumeros + "  ->  "
					+ numerosAcertados);
		}

		/*
		 * int[] array = new int[]{45,25,3,65,48,21,3,6,1,8};
		 * 
		 * print(array);
		 * 
		 * quick_sort(array, 5, 10);
		 * 
		 * print(array);
		 */

	}

	// public static void print(int[] array) {
	// System.out.println("=================================================");
	// for (int i=0; i<array.length; i++) {
	// System.out.println(array[i]);
	// }
	// }

	// public static void quick_sort(int[] v, int ini, int fim) {
	// int meio;
	//
	// if (ini < fim) {
	// meio = partition(v, ini, fim);
	// quick_sort(v, ini, meio);
	// quick_sort(v, meio + 1, fim);
	// }
	// }

	// public static int partition(int[] v, int ini, int fim) {
	// int pivo, topo;
	// pivo = v[ini];
	// topo = ini;
	//
	// for (int index = ini + 1; index < fim; index++) {
	// if (v[index] < pivo) {
	// v[topo] = v[index];
	// v[index] = v[topo + 1];
	// topo++;
	// }
	// }
	// v[topo] = pivo;
	// return topo;
	// }

}

class Jogo {

	private List<String> numeros;

	public Jogo() {
		this.numeros = new ArrayList<String>();
	}

	public Jogo(String num1, String num2, String num3, String num4, String num5, String num6) {
		this();
		this.numeros.add(num1);
		this.numeros.add(num2);
		this.numeros.add(num3);
		this.numeros.add(num4);
		this.numeros.add(num5);
		this.numeros.add(num6);
	}

	public List<String> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<String> numeros) {
		this.numeros = numeros;

	}
}

import java.util.Random;

public class jogo {
	public static void main(String[] args) {
		Random n = new Random();
		String[] sufixo = { "de Copa","de Espada","de Ouro","de Paus" };
		String[] baralho = { "A","1","2","3","4","5","6","7","8","9","10","J","Q","K" };
		String naipe = null;
		String carta = null;
		String cartas = null;
		String[] lista = new String[20];
		for (int i = 0; i < 20; i++) {
			naipe = sufixo[((int) (sufixo.length * Math.random()))];
			cartas = baralho[((int) (baralho.length * Math.random()))];
			carta = cartas + " " + naipe;
			lista[i] = carta;
		}
		System.out.println("(JOGADOR 1): " + lista[0] + " | " + lista[1] + " | " + lista[2] + " | " + lista[3] + " | " + lista[4]);
		System.out.println("(JOGADOR 2): " + lista[5] + " | " + lista[6] + " | " + lista[7] + " | " + lista[8] + " | " + lista[9]);
		System.out.println("(JOGADOR 3): " + lista[10] + " | " + lista[11] + " | " + lista[12] + " | " + lista[13] + " | " + lista[14]);
		System.out.println("(JOGADOR 4): " + lista[15] + " | " + lista[16] + " | " + lista[17] + " | " + lista[18] + " | " + lista[19]);
	}
}
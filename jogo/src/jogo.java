import java.util.Random;

public class jogo {

	public static void main(String[] args) {
		
		Random n = new Random();
		
		String[] sufixo = {"de Copa","de Coração","de Ouro","de Paus"};
		String naipe = null;
		int carta = 0;
		String cartas = null;
		String[] lista = new String[20];
		
		for(int i = 0 ; i < 20 ; i++){
			naipe = sufixo[((int) (sufixo.length * Math.random()))];
			carta = n.nextInt(13)+1;
			cartas = Integer.toString(carta)+" "+naipe;
			lista[i] = cartas;
		}		
		
		System.out.println("(JOGADOR 1): " + lista[0]+" | "+lista[1]+" | "+lista[2]+" | "+lista[3]+" | "+lista[4]);		
		System.out.println("(JOGADOR 2): " + lista[5]+" | "+lista[6]+" | "+lista[7]+" | "+lista[8]+" | "+lista[9]);
		System.out.println("(JOGADOR 3): " + lista[10]+" | "+lista[11]+" | "+lista[12]+" | "+lista[13]+" | "+lista[14]);
		System.out.println("(JOGADOR 4): " + lista[15]+" | "+lista[16]+" | "+lista[17]+" | "+lista[18]+" | "+lista[19]);
	}
}

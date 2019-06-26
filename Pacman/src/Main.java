import com.unicamp.mc322.pacman.Game;

public class Main {

	public static void main(String[] args) {
		System.out.println("BEM VINDO AO PACMAN322");
		System.out.println("QUAL MAPA VOCE DESEJA JOGAR? O PADRÃO(1) OU O ALEATÓRIO(2)?");
		Game game = new Game();
		game.start();
	}

}

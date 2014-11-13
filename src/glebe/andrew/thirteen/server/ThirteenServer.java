package glebe.andrew.thirteen.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class ThirteenServer {
    public static void main(String[] args) throws UnknownHostException,
	    IOException {
	ServerSocket listener = new ServerSocket(40002);
	System.out.println("Thirteeen server is now listening!");
	try {
	    while (true) {
		//Start a Game
		Game game = new Game();
		//Wait for Players and assign them to a position in the playerNum Array.
		game.playerNum[0] = new Player(listener.accept(), 1, game);
		game.playerNum[1] = new Player(listener.accept(), 2, game);
		game.playerNum[2] = new Player(listener.accept(), 3, game);
		game.playerNum[3] = new Player(listener.accept(), 4, game);
		//Deal the cards
		game.deal();
		//Set current Player
		game.currentPlayer = game.playerNum[0];
		//Start Player threads.
		new Thread(game.playerNum[0]).start();
		new Thread(game.playerNum[1]).start();
		new Thread(game.playerNum[2]).start();
		new Thread(game.playerNum[3]).start();
	    }
	} finally {
	    listener.close();
	}
    }
}

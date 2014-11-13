package glebe.andrew.thirteen.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

class Player implements Runnable {
    Game game;
    ArrayList<Object> hand = new ArrayList<Object>();
    Socket socket;
    int playerNumber;
    ObjectInputStream objectIn;
    ObjectOutputStream objectOut;

    public Player(Socket socket, int playerNumber, Game game) {
	this.socket = socket;
	this.playerNumber = playerNumber;
	try {
	    objectIn = new ObjectInputStream(socket.getInputStream());
	    objectOut = new ObjectOutputStream(socket.getOutputStream());
	    objectOut.writeObject("Welcome Player " + playerNumber + "/n"
		    + "Waiting fo r other players to connect...");
	} catch (IOException e) {
	    System.out.println("oh snap, something is wrong " + e);
	}
    }

    public void run() {
	// This is what happens when the Player thread is started IE:
	// "new Thread(game.playerNum[0]).start();"
	try {
	    objectOut.writeObject("Ok, everyone is here. Let's get this bitch lit!");

	    while (true) {
		Object cardPlayed = objectIn.readObject();
		if (game.currentPlayer(this, cardPlayed)) {
		    game.curStack = cardPlayed;
		}
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	  }
    }

    public void tellEveryone(Object cardPlayed) {
	try {
	objectOut.writeObject(cardPlayed);
	} catch (IOException e) { }
    }
}
package glebe.andrew.thirteen.server;

public class Game {

    Player[] playerNum = new Player[4];
    Player currentPlayer;
    Object curStack;
    int turns = 0;
    
    public boolean hasWinner() { // This Method needs to be finished.
	if (playerNum[turns%4].hand.size() == 0)
	    return true;
	else
	    return false;
    }

    public void deal() {

    }

    public boolean checkRank(Cards[] play) {
	boolean equalRanks = true;
	for (int i = 0; i < play.length - 1;) {
	    if (play[i + 1].getRank() == play[i].getRank())
		i++;
	    else {
		equalRanks = false;
		break;
	    }
	}
	return equalRanks;
    }
   
    public void otherPlayerPlayed(Object handPlayed) {
	playerNum[0].tellEveryone(handPlayed);
	playerNum[1].tellEveryone(handPlayed);
	playerNum[2].tellEveryone(handPlayed);
	playerNum[3].tellEveryone(handPlayed);
    }

    public boolean currentPlayer(Player player, Object handPlayed) {
	if (player.equals(currentPlayer)) {
	    otherPlayerPlayed(handPlayed);
	    curStack = handPlayed;
	    currentPlayer = playerNum[turns%4];
	    turns++;
	    return true;
	}
	else {
	    return false;
	}
    }

}

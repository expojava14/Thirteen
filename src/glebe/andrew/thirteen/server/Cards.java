package glebe.andrew.thirteen.server;

public class Cards implements Comparable<Cards>
{
    
    private final int rank_;
    private final int suit_;
    
    public Cards(int rank, int suit)
    {
        rank_ = rank;
        suit_ = suit;
    }
    
    public int getRank()
    {
        return rank_;
    }
    
    public int getSuit()
    {
        return suit_;
    }
    
    public String toString()
    {
        String card = "AS";
        return card;
    }
    
    public int compareTo(Cards compareCards)
    {
        int compareRank = ((Cards) compareCards).getRank();
        return this.rank_ - compareRank;
    }
}

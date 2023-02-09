import java.util.ArrayList;
import java.util.Comparator;
import java.io.*;

public class CardTrading {
	private final int N;
	private final int T;
	private final int K;
	private ArrayList<Card> deck = new ArrayList<Card>();

	//Constructor
	CardTrading() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NTK = br.readLine().split(" ");
		this.N = Integer.parseInt(NTK[0]);
		this.T = Integer.parseInt(NTK[1]);
		this.K = Integer.parseInt(NTK[2]);

		int[] allCards = new int[T+1];
		String[] decks = br.readLine().split(" ");
		for (String card : decks) {
			int cardNum = Integer.parseInt(card);
			allCards[cardNum]++;
		}

		for (int ithCard = 1; ithCard <= T; ithCard++) {
			String[] rateTable = br.readLine().split(" ");
			int buy = Integer.parseInt(rateTable[0]);
			int sell = Integer.parseInt(rateTable[1]);

			Card card = new Card(ithCard, buy, sell);
			card.setNumOfThis(allCards[ithCard]);
			this.deck.add(card);
		}
	}

	public void computeOptimumProfit() {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		this.deck.sort(new CardComparator());
		long profit = 0;

		for (int cardIdx = 0; cardIdx < K; cardIdx++) {
			Card currCard = this.deck.get(cardIdx);
			profit -= currCard.buy();
		}

		for (int cardIdx = K; cardIdx < this.deck.size(); cardIdx++) {
			Card currCard = this.deck.get(cardIdx);
			profit += currCard.sell();
		}
		pw.println(profit);
		pw.flush();
		pw.close();
	}

	public static void main(String[] args) throws IOException { 
		CardTrading game = new CardTrading();
		game.computeOptimumProfit();
	}
}

class Card {
	private final int NUM;
	private final int BUY_PRICE;
	private final int SELL_PRICE;
	private int numOfThis; // To keep track the number of this card

	Card(int NUM, int buyPrice, int sellPrice) {
		this.NUM = NUM;
		this.BUY_PRICE = buyPrice;
		this.SELL_PRICE = sellPrice;
	}

	void setNumOfThis(int num) {
		this.numOfThis = num;
	}

	int sell() {
		int income = this.SELL_PRICE * this.numOfThis;
		return income;
	}

	int buy() {
		int expenses = this.BUY_PRICE * (2 - this.numOfThis);
		return expenses;
	}

	int computeValue() {
		return this.sell() + this.buy();
	}

	@Override
	public String toString() {
		return "" + this.NUM;
	}
}

class CardComparator implements Comparator<Card> {
	@Override
	public int compare(Card cA, Card cB) {
		int cardAValue = cA.computeValue();
		int cardBValue = cB.computeValue();
		int temp = Integer.compare(cardAValue, cardBValue);

		if (temp != 0) {
			return temp;
		} else {
			return Integer.compare(cA.buy(), cB.buy());
		}	
	}
}

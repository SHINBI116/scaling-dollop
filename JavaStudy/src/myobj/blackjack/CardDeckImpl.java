package myobj.blackjack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CardDeckImpl implements CardDeck {
	
	LinkedList<Card> cards = new LinkedList<>();
	
	public CardDeckImpl() {
		reset();
	}
	
	private void reset() {
		for (int suit = 0; suit < Card.NUM_OF_SUITS; ++suit) {
			for (int rank = 0; rank < Card.NUM_OF_RANK; ++rank) {
				cards.add(new Card(suit, rank));
			}
		}
		shuffle();
	}
	
	@Override
	public void shuffle() {
		Collections.shuffle(cards);
		
	}

	@Override
	public Card draw() {
		// list.remove() : 비어있을때 에러 발생(예외처리 방식으로 해결 가능)
		// list.pollFirst() : 비어있으면 null을 리턴(if문으로 해결 가능)
		// 외워서 해결하는 것이 아니라 메서드에 대한 주석을 읽어보고 알아야 한다
		Card card = cards.pollFirst();
		
		if (card == null) {
			reset();

			return draw(); // 재귀 호출
		}
		
		return card;
	}

}

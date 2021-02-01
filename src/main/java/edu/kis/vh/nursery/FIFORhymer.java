package edu.kis.vh.nursery;

import edu.kis.vh.nursery.storage.IntArrayStack;
import edu.kis.vh.nursery.storage.IntStorage;

public class FIFORhymer extends DefaultCountingOutRhymer {

	/*** 
	 * ! Odpowiedz na Pytanie: Jaki wybór będzie najlepszy (napisz komentarz)? 
	 * W celu optymalizacji lepszym wyborem będzie IntArrayStack, poprzez wykorzystanie statycznej tablicy i 
	 * braku potrzeby alokacji pamięci na nowy Node skraca się czas dostępu potrzebny do przypisania nowej wartości.
	 * 
	 * Natomiast w sytuacji w której nie znany byłby rozmiar, wymagana jest częsta insercja
	 * (operacje wymagające ciągłego alokowania dodatkowego miejsca) wtedy IntLinked byłby lepszy.
	 */
	private final IntArrayStack tempRhymer = new IntArrayStack();

	public FIFORhymer() {
        super();
    }

    public FIFORhymer(IntStorage intStorage) {
        super(intStorage);
    }

	@Override
	public int countOut() {
		while (!callCheck())
			tempRhymer.countIn(super.countOut());
		int ret = tempRhymer.countOut();
		while (!tempRhymer.callCheck())
			countIn(tempRhymer.countOut());
		return ret;
	}
}

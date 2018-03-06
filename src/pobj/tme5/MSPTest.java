package pobj.tme5;

public class MSPTest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		MultiSetParser msp = new MultiSetParser();
		MultiSet<String> ms;
		try {
			ms = msp.parse("data/WarAndPeace.txt");
			ms.toString();
		} catch (InvalidMultiSetFormat e) {
			e.printStackTrace();
		}
	}

}

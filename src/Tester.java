
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeResistorColors h = new DecodeResistorColors();
		//System.out.println(h.decodeResistorColors("brown black black"));
		
		System.out.println(h.encodeResistorColors("330k ohms"));
		System.out.println(h.encodeResistorColors("10k ohms"));
		System.out.println(h.encodeResistorColors("22k ohms"));
		System.out.println(h.encodeResistorColors("4.7k ohms"));

	}

}

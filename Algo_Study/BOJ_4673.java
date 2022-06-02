public class BOJ_4673{

	public static void main(String[] args) {
		
		boolean selfNum = true;
		
		for(int i=1; i<=10000; i++) {
			
			for(int j=1; j<=10000; j++) {
				if(i == d(j)) {
					selfNum = false; break;
				}
			}
			if(selfNum == true) {
				System.out.println(i);
			}
			selfNum = true;
		}
	}
	
	static int d(int n) {
		
		String str = Integer.toString(n);
		
		for(int i=0; i<str.length(); i++) {
			n += Integer.parseInt(str.substring(i, i+1));
		}
		
		return n;
	}
}

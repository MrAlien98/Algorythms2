package rec;

public class Main {

	public static void main(String[] args) {
		System.out.println(isPalindrome("culluc"));
		System.out.println(invertir("esternocleidomastoideo"));
	}

	public static boolean isPalindrome(String str) {
		if(str.length()==1 || str.length()==0) {
			return true;
		}else {
			if(str.charAt(0)==str.charAt(str.length()-1)) {
				return isPalindrome(str.substring(1, str.length()-1));
			}else {
				return false;
			}
		}
	}
	
	public static String invertir(String cad) {
		if(cad.length() == 1) {
			return cad;
		}else {
			return invertir(cad.substring(1)) + cad.charAt(0);
		}
	}
	
}

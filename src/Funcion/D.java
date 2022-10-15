package Funcion;

public class D {

	public D() {
		// TODO Auto-generated constructor stub
	}
public static void main(String[] args) {
	String str = "(2,2)";
	// parameter inside split method is the pattern that matches opened and closed parenthesis, 
	// that means all characters inside "[ ]" escaping parenthesis with "\\" -> "[\\(\\)]"
	String[] parts = str.split("[\\(\\,\\)]");
	for (String part : parts) {
	   // I print first "Your", in the second round trip "String"
	   System.out.println(part);
	}
}
}

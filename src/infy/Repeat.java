package infy;

import java.util.Arrays;
import java.util.Collections;

//https://mkyong.com/java/java-how-to-print-a-name-10-times/
public class Repeat {

	public static void main(String args[]) {
		Repeat r = new Repeat();
		r.Java11Repeat();
		r.Java8IntStreamrange();
		r.javaStringJoinArray();
		r.JavaStringJoin();
		r.JavaCharStrReplace();
		r.JavaNoLoop();
		JavaSampleReadRecursion("MYTest\n", 100);

	}

	public void Java11Repeat() {
		String str = "Mkyong\n";
		System.out.println(str.repeat(10));
	}

	public void Java8IntStreamrange() {
		String str = "Mkyong\n";
		System.out.println(str.repeat(10));
	}

	public void javaStringJoinArray() {

		String[] str = new String[10];
		Arrays.fill(str, "Mkyong");
		System.out.println(String.join("\n", str));
	}

	public void JavaStringJoin() {

		System.out.print(String.join("\n", Collections.nCopies(10, "Mkyong")));

	}

	public void JavaCharStrReplace() {
		char[] chars = new char[10];
		String str = new String(chars);
		System.out.print(str.replace("\0", "Mkyong\n"));
	}

	public void JavaNoLoop() {
		String s1 = "Java\n";
		String s3 = s1 + s1 + s1;
		String s10 = s3 + s3 + s3 + s1;
		String s30 = s10 + s10 + s10;
		String s100 = s30 + s30 + s30 + s10;
		String s300 = s100 + s100 + s100;
		String s1000 = s300 + s300 + s300 + s100;
		System.out.print(s1000);
	}

	static void JavaSampleReadRecursion(String name, int times) {

		System.out.println(times + ":" + name);

		if (times > 1) {
			JavaSampleReadRecursion(name, times - 1);
		}
	}

}

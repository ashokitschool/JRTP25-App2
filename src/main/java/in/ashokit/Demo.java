package in.ashokit;

import java.util.Random;

public class Demo {

	public static void main(String[] args) {

		String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuv";

		StringBuffer randomString = new StringBuffer(5);
		Random random = new Random();

		for (int i = 0; i < 5; i++) {
			int randomIndex = random.nextInt(alphanumericCharacters.length());
			char randomChar = alphanumericCharacters.charAt(randomIndex);
			randomString.append(randomChar);
		}

		System.out.println(randomString.toString());
	}

}

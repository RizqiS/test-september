package com.example.demo;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);
		// System.out.println(soal1(200, 5, 0.05F));
		System.out.println(soal1(250, 2, 0.02F));

		// soal2(5);
		// String input = "imagination";
		// System.out.println(soal3(input, 3));

		// int[] price = { 2000, 50000, 100_000, 152_000 };
		// soal4(price);
		// soal5();
	}

	static float soal1(float ta1, int duration, float ph1) {

		// check duration days if 1, 2, 3, 4, 5
		if (duration == 1) {
			ta1 = 210.00F;
		} else if (duration == 2) {
			ta1 = 220.50F;
		} else if (duration == 3) {
			ta1 = 231.53F;
		} else if (duration == 4) {
			ta1 = 243.10F;
		} else if (duration == 5) {
			ta1 = 255.26F;
		} else {
			ta1 = 0;
		}

		// calculating the result
		return (ta1 * duration) / ph1;
	}

	static void soal2(int height) {

		// looping rows from 1 to height
		for (int i = 1; i <= height; i++) {
			// Print space on the left
			for (int j = height; j < i; j--) {
				System.out.print(" ");
			}
			// check if == 1 Print white space otherwise print '/'
			if (i == 1) {
				System.out.print(" ");
			} else {
				System.out.print("/");
			}
			// Print '*'
			for (int k = 0; k < i; k++) {
				System.out.print("*");
			}
			// check if == 1 Print white space otherwise print '\'
			if (i == 1) {
				System.out.print(" ");
			} else {
				System.out.print("\\");
			}

			// Move rows after each row of the pyramid
			System.out.println();
		}
	}

	static String soal3(String word, int remove) {
		// do the calculation of each character
		Map<Character, Integer> frequencyMap = new HashMap<>();
		for (char ch : word.toCharArray()) {
			frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
		}

		StringBuilder result = new StringBuilder();
		for (char ch : word.toCharArray()) {
			if (frequencyMap.get(ch) <= remove) {
				result.append(ch);
			}
		}

		return result.toString();
	}

	static void soal4(int[] price) {
		for (int prices : price) {
			float discount = 0F;
			String benefit = "";
			if (prices > 400_000) {
				discount = 0.10F;
				benefit = "ransel";
			} else if (prices > 200_000) {
				discount = 0.07F;
				benefit = "payung";
			} else if (prices > 70_000) {
				discount = 0.05F;
				benefit = "topi";
			}

			int countResult = (int) (prices * discount);
			NumberFormat currencyFormatID = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

			System.out.println("Total price : " + currencyFormatID.format(prices));
			System.out.println("discount : " + discount);
			System.out.println("bonus : " + benefit);
			System.out.println("final price: " + currencyFormatID.format(countResult));
		}
	}

	static void soal5() {

		// Data akun dan nominal
		int[] noAkun = { 111, 211, 201 };
		int[] nominal = { 200000, 50000, 150000 };

		// Membuat map untuk menyimpan informasi akun
		Map<Integer, AccountSoal5> accounts = new HashMap<>();
		for (int i = 0; i < noAkun.length; i++) {
			accounts.put(noAkun[i], new AccountSoal5(noAkun[i], nominal[i]));
		}

		// Menambahkan transaksi
		trancationSoal5(accounts, 11, 200000, 0); // Akun ke-1, debit 200000, kredit 0

		// Menampilkan informasi akun
		for (AccountSoal5 account : accounts.values()) {
			System.out.println(account);
		}
	}

	public static void trancationSoal5(Map<Integer, AccountSoal5> accounts, int accountNumber, double debit,
			double kredit) {
		AccountSoal5 account = accounts.get(accountNumber);
		if (account != null) {
			account.setDebit(debit);
			account.setKredit(kredit);
		} else {
			System.out.println("Akun tidak ditemukan: " + accountNumber + "\n");
		}
	}

	static class AccountSoal5 {
		private int number;
		private double nominal;
		private double debit;
		private double kredit;

		public AccountSoal5(int number, double nominal) {
			this.number = number;
			this.nominal = nominal;
			this.debit = 0;
			this.kredit = 0;
		}

		public void setDebit(double debit) {
			this.debit = debit;
		}

		public void setKredit(double kredit) {
			this.kredit = kredit;
		}

		@Override
		public String toString() {
			return "# akun # debit # kredit \n" + "Akun: " + number +
					"\nNominal: " + nominal +
					"\nDebit: " + debit +
					"\nKredit: " + kredit +
					"\n";
		}
	}
}

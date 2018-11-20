package main;

import gui.InitFrame;
import system.BankSystem;

public class Main {
	public static void main(String[] args) {
		new InitFrame(new BankSystem());
	}
}

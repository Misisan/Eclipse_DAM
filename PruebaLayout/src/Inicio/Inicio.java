package Inicio;

import javax.swing.JFrame;

import Ventanas.Principal;

public class Inicio extends JFrame {
	public Inicio() {
	}

	public static void main(String[] args) {
		Principal ventanaInicial = new Principal();
		ventanaInicial.setVisible(true);
	}

}

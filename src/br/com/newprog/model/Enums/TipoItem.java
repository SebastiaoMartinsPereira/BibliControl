package br.com.newprog.model.Enums;

public enum TipoItem {
	LIVRO,REVISTA;
	
	public static TipoItem fromInteger(int x) {
		switch (x) {
		case 0:
			return LIVRO;
		case 1:
			return REVISTA;
		default:
			return null;
		}
	}
}

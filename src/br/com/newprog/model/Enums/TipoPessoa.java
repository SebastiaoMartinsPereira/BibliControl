package br.com.newprog.model.Enums;

public enum TipoPessoa {
	ALUNO, PROFESSOR, FUNCIONARIO;

	public static TipoPessoa fromInteger(int x) {
		switch (x) {
		case 0:
			return ALUNO;
		case 1:
			return PROFESSOR;
		case 2:
			return FUNCIONARIO;
		default:
			return null;
		}
	}
}

package br.dev.marcelodeoliveira.appium.tests.model.dto;

import br.dev.marcelodeoliveira.appium.core.enums.GameConsole;

public class FormularioModel {
	String nome;
	GameConsole console;
	Boolean checkBoxSelected;
	Boolean switchSelected;

	public FormularioModel(String nome, GameConsole console, boolean switchSelected, boolean checkBoxState) {
		super();
		this.nome = nome;
		this.console = console;
		this.switchSelected = switchSelected;
		this.checkBoxSelected = checkBoxState;
	}


	public String getNome() {
		return nome;
	}

	public GameConsole getConsole() {
		return console;
	}

	public String getConsoleComboStr() {
		return console.getComboName();
	}

	public String getConsoleRequestStr() {
		return console.getResponseName();
	}


	public Boolean isCheckBoxSelected() {
		return checkBoxSelected;
	}

	public Boolean isSwitchSelected() {
		return switchSelected;
	}
	public String checkBoxStatus() {
		return checkBoxSelected?"Marcado":"Descelecionado";
	}
	
	public String switchStatus() {
		return switchSelected?"On":"Off";
	}

}

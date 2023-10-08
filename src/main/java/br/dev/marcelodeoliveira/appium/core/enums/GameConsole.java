package br.dev.marcelodeoliveira.appium.core.enums;

public enum GameConsole {

	XBOX_ONE("XBox One", "xone"), PS4("PS4", "ps4"), NINTENDO_SWITCH("Nintendo Switch", "switch");

	private String comboName, responseName;

	GameConsole(String comboName, String responseName) {
		this.comboName = comboName;
		this.responseName = responseName;
	}

	public String getComboName() {
		return this.comboName;
	}

	public String getResponseName() {
		return this.responseName;
	}

}

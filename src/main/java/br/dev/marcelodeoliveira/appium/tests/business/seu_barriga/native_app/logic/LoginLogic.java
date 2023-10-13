package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.logic;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.page.LoginPage;
import br.dev.marcelodeoliveira.appium.tests.model.dto.UserLoginDTO;
import br.dev.marcelodeoliveira.appium.tests.model.dto.UserSignUpDTO;

public class LoginLogic extends BaseLogic {

	private LoginPage page;
	UserSignUpDTO usuarioDtoCadastro;
	UserLoginDTO usuarioLoginDto;

	public void defaultTestSetUpReset() {
		click(page.getbtnReset());
	}

	private void setupDataMass() {
		usuarioDtoCadastro = new UserSignUpDTO("Ghrb", "magh@ri.bi", "!1234");
		usuarioLoginDto = usuarioDtoCadastro.getLoginUserDTO();
	}

	public void login() {
		fillLoginForm();
		clickEnter();
	}

	private void clickEnter() {
		click(page.getBtnEntrar());
		System.out.println("for debug purpouses");
	}

	public void fillLoginForm() {
		writeText(page.getTxtLoginEmail(), usuarioLoginDto.getEmail());
		writeText(page.getTxtLoginPassword(), usuarioLoginDto.getPassword());
	}

	@Override
	protected void setupPages(BasePage... pages) {
		setupDataMass();
		this.page = new LoginPage();
	}

	public void reset() {
		click(page.getbtnReset());
	}

}

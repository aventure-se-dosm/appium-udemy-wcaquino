package br.dev.marcelodeoliveira.appium.tests.business.seu_barriga.native_app.login;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.tests.model.dto.UserLoginDTO;
import br.dev.marcelodeoliveira.appium.tests.model.dto.UserSignUpDTO;

public class LoginLogic extends BaseLogic {

	private LoginPage page;
	UserSignUpDTO usuarioDtoCadastro;
	UserLoginDTO usuarioLoginDto;

//	@Override
//	protected void setupPages(BasePage... pages) {
//		this.loginPage = new LoginPage();
//
//	}

//	public void login() {
//		// TODO Auto-generated method stub
//
//	}
//
//	public void defaultTestSetUpReset() {
//		// TODO Auto-generated method stub
//
//	}

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

	public void wipeAllReset() {
		// TODO Auto-generated method stub
		// All data are wiped out (accounts, transactions, &c&al@all!

	}

	public void reset() {
		click(page.getbtnReset());
	}

}
package br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.logic;

import br.dev.marcelodeoliveira.appium.core.BaseLogic;
import br.dev.marcelodeoliveira.appium.core.BasePage;
import br.dev.marcelodeoliveira.appium.tests.business.elements_interaction.page.SwipePage;

public class SwipeLogic extends BaseLogic {

	private SwipePage page;

	public void swipeToTheRight() {
		swipeLeft();
	}

	public void swipeToTheLeft() {
		swipeRight();
	}

	public void clicaBtnDir() {
		click(page.getIcoSlideToTheRight());
	}

	public void clicaBtnEsq() {
		click(page.getIcoSlideToTheLeft());
	}

	@Override
	protected void setupPages(BasePage... pages) {
		this.page = new SwipePage();

	}

}

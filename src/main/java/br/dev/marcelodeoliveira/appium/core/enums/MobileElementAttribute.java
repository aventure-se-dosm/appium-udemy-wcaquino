package br.dev.marcelodeoliveira.appium.core.enums;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;







public enum MobileElementAttribute {

	CHECKABLE(), CHECKED(), CLASS(), CLICKABLE(), CONTENT_DESC(), ENABLED(), FOCUSABLE(), FOCUSED(), LONG_CLICKABLE(),
	PACKAGE(), PASSWORD(), RESOURCE_ID(), SCROLLABLE(), SELECTION_START(), SELECTION_END(), SELECTED(), TEXT(), HINT(),
	EXTRAS(), ORIGINAL_TEXT(), BOUNDS(), INDEX(), DISPLAYED(), CONTENT_SIZE();

	public String getName() {
		return hyphenized();
	}

	public String hyphenized() {
		return this.name().toLowerCase().replace("_", "-");
	}

	public String camelCased() {
		return Arrays.asList(this.name().toLowerCase().split("_")).stream().map( str -> StringUtils.capitalize(str))
				.reduce((x, y) -> x.concat(y)).get();
	}

	public String lowerCased() {
		return this.name().toLowerCase();
	}
}

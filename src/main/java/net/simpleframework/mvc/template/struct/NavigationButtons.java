package net.simpleframework.mvc.template.struct;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.coll.ArrayListEx;
import net.simpleframework.common.html.element.AbstractElement;
import net.simpleframework.common.html.element.AbstractLinkElement;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class NavigationButtons extends ArrayListEx<NavigationButtons, AbstractElement<?>> {

	public static NavigationButtons of(final AbstractLinkElement<?>... btns) {
		return new NavigationButtons().append(btns);
	}

	private String separatorHtml;

	public String getSeparatorHtml() {
		return StringUtils.text(separatorHtml, "<span class='nav_img'></span>");
	}

	public NavigationButtons setSeparatorHtml(final String separatorHtml) {
		this.separatorHtml = separatorHtml;
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		int i = 0;
		for (final AbstractElement<?> btn : this) {
			if (i++ > 0) {
				sb.append(getSeparatorHtml());
			}
			sb.append(btn.setClassName("nav_item"));
		}
		return sb.toString();
	}

	private static final long serialVersionUID = 5679380307264466992L;
}

package net.simpleframework.mvc.template.struct;

import java.util.ArrayList;
import java.util.List;

import net.simpleframework.common.html.element.AbstractButtonEx;
import net.simpleframework.common.web.EUrlMatch;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class TabButton extends AbstractButtonEx<TabButton> {

	private EUrlMatch matchMethod;

	private List<TabButton> children;

	public TabButton(final Object text, final String href) {
		super(text);
		setHref(href);
	}

	public EUrlMatch getMatchMethod() {
		return matchMethod == null ? EUrlMatch.endsWith : matchMethod;
	}

	public void setMatchMethod(final EUrlMatch matchMethod) {
		this.matchMethod = matchMethod;
	}

	public List<TabButton> getChildren() {
		if (children == null) {
			children = new ArrayList<TabButton>();
		}
		return children;
	}

	@Override
	protected String getDownMenu() {
		final StringBuilder sb = new StringBuilder();
		sb.append("<span class=\"tmenu\" id=\"m").append(getId()).append("\"></span>");
		return sb.toString();
	}
}

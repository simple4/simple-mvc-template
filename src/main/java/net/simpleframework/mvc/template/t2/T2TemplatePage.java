package net.simpleframework.mvc.template.t2;

import net.simpleframework.common.html.element.SpanElement;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.ui.menu.MenuBean;
import net.simpleframework.mvc.template.AbstractTemplatePage;
import net.simpleframework.mvc.template.RootTemplatePage;
import net.simpleframework.mvc.template.struct.NavigationButtons;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class T2TemplatePage extends RootTemplatePage {

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);
		addHtmlViewVariable(getClass(), "content");

		if (isInheritedPage(T2TemplatePage.class)) {
			addImportCSS(new String[] {
					getCssResourceHomePath(pParameter, AbstractTemplatePage.class) + "/template.css",
					getCssResourceHomePath(pParameter, T2TemplatePage.class) + "/t2.css" });

			addComponentBean(pParameter, MenuBean.class, MenuT1.class).setContainerId("site_menu_bar");
		}
	}

	@Override
	public NavigationButtons getNavigationBar(final PageParameter pParameter) {
		return super.getNavigationBar(pParameter).setSeparatorHtml(SpanElement.NAV.toString());
	}

	public String toInfoHTML(final PageParameter pParameter) {
		final StringBuilder sb = new StringBuilder();
		final NavigationButtons nav = getNavigationBar(pParameter);
		if (nav != null) {
			sb.append(nav);
		}
		return sb.toString();
	}
}

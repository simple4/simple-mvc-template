package net.simpleframework.mvc.template;

import net.simpleframework.common.html.element.LinkElement;
import net.simpleframework.mvc.AbstractMVCPage;
import net.simpleframework.mvc.IMVCTemplate;
import net.simpleframework.mvc.MVCContextFactory;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.ComponentParameter;
import net.simpleframework.mvc.component.ui.menu.AbstractMenuHandler;
import net.simpleframework.mvc.component.ui.menu.MenuItem;
import net.simpleframework.mvc.component.ui.menu.MenuItems;
import net.simpleframework.mvc.template.struct.NavigationButtons;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class RootTemplatePage extends AbstractTemplatePage {

	public static LinkElement BTN_HOME = new LinkElement("#(RootTemplatePage.0)").setHref("/");

	/**
	 * 定义导航条
	 * 
	 * @param pParameter
	 * @return
	 */
	public NavigationButtons getNavigationBar(final PageParameter pParameter) {
		return NavigationButtons.of(BTN_HOME);
	}

	@Override
	protected NamedTemplate createNamedTemplates(final PageParameter pParameter) {
		Class<? extends AbstractMVCPage> header = null, footer = null;
		final IMVCTemplate t = MVCContextFactory.ctx().getTemplate(this);
		if (t instanceof IMVCTemplate) {
			final IMVCTemplate t1 = t;
			header = t1.getHeaderPage();
			footer = t1.getFooterPage();
		}
		return new NamedTemplate(pParameter)
				.add("header", header == null ? HeaderPage.class : header).add("footer",
						footer == null ? FooterPage.class : footer);
	}

	public static class MenuT1 extends AbstractMenuHandler {
		@Override
		public MenuItems getMenuItems(final ComponentParameter cParameter, final MenuItem menuItem) {
			if (menuItem == null) {
				final IMVCTemplate t = MVCContextFactory.ctx().getTemplate(
						AbstractMVCPage.get(cParameter));
				if (t != null) {
					return ((AbstractMVCTemplate) t).getMenuItems(cParameter, menuItem);
				}
			}
			return null;
		}
	}
}

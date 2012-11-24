package net.simpleframework.mvc.template.t1;

import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.ui.menu.MenuBean;
import net.simpleframework.mvc.template.AbstractTemplatePage;
import net.simpleframework.mvc.template.RootTemplatePage;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class T1TemplatePage extends RootTemplatePage {

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);

		if (isInheritedPage(T1TemplatePage.class)) {
			addImportCSS(new String[] {
					getCssResourceHomePath(pParameter, AbstractTemplatePage.class) + "/template.css",
					getCssResourceHomePath(pParameter, T1TemplatePage.class) + "/t1.css" });

			addComponentBean(pParameter, MenuBean.class, MenuT1.class).setContainerId(
					"resized_menu_bar");
		}
	}
}

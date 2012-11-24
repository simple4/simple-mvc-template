package net.simpleframework.mvc.template;

import java.io.IOException;
import java.util.Map;

import net.simpleframework.common.StringUtils;
import net.simpleframework.mvc.AbstractMVCPage;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.ComponentParameter;
import net.simpleframework.mvc.component.ui.tabs.DefaultTabsHandler;
import net.simpleframework.mvc.component.ui.tabs.TabItems;
import net.simpleframework.mvc.component.ui.tabs.TabsBean;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class TabsTemplatePage extends AbstractTemplatePage {

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);

		final Class<?> beanClass = getClass();
		if (!TabsTemplatePage.class.equals(beanClass)) {
			addComponentBean(pParameter, TabsBean.class, ContentTabsHandler.class).setContainerId(
					"tabs_" + StringUtils.hash(beanClass));
		}
	}

	@Override
	protected String toHtml(final PageParameter pParameter,
			final Class<? extends AbstractMVCPage> pageClass, final Map<String, Object> variables,
			final String variable) throws IOException {
		if (TabsTemplatePage.class.equals(pageClass)) {
			return "<div id='tabs_" + StringUtils.hash(getClass()) + "'></div>";
		}
		return super.toHtml(pParameter, pageClass, variables, variable);
	}

	protected TabItems tabItems(final PageParameter pParameter) {
		return null;
	}

	public static class ContentTabsHandler extends DefaultTabsHandler {
		@Override
		public TabItems tabItems(final ComponentParameter cParameter) {
			return ((TabsTemplatePage) get(cParameter)).tabItems(cParameter);
		}
	}
}

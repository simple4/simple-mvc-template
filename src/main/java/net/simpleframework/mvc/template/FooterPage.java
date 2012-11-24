package net.simpleframework.mvc.template;

import java.io.IOException;
import java.util.Map;

import net.simpleframework.mvc.AbstractMVCPage;
import net.simpleframework.mvc.PageParameter;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class FooterPage extends AbstractTemplatePage {

	@Override
	protected String toHtml(final PageParameter pParameter,
			final Class<? extends AbstractMVCPage> pageClass, final Map<String, Object> variables,
			final String variable) throws IOException {
		if (FooterPage.class.equals(pageClass)) {
			return "<div>FooterPage</div>";
		}
		return super.toHtml(pParameter, pageClass, variables, variable);
	}
}

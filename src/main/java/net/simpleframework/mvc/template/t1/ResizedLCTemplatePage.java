package net.simpleframework.mvc.template.t1;

import net.simpleframework.common.StringUtils;
import net.simpleframework.mvc.PageParameter;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class ResizedLCTemplatePage extends ResizedTemplatePage {

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);
		final Class<?> pageClass = getClass();
		addHtmlViewVariable(pageClass, "content_left", pageClass.getSimpleName() + "_Left.html");
		addHtmlViewVariable(pageClass, "content_center", pageClass.getSimpleName() + "_Center.html");
		addHtmlViewVariable(ResizedLCTemplatePage.class, "content");
	}

	public String toLeftToolbarHTML(final PageParameter pParameter) {
		return null;
	}

	public String _toCenterBarHTML(final PageParameter pParameter) {
		return super._toBarHTML(pParameter);
	}

	public String _toLeftBarHTML(final PageParameter pParameter) {
		final StringBuilder sb = new StringBuilder();
		final String html = toLeftToolbarHTML(pParameter);
		if (StringUtils.hasText(html)) {
			sb.append("<div class='t_bar'>");
			sb.append(html);
			sb.append("</div>");
		}
		return sb.toString();
	}

	@Override
	public String _toBarHTML(final PageParameter pParameter) {
		return "";
	}
}

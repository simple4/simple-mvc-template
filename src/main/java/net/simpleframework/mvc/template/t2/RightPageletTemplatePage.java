package net.simpleframework.mvc.template.t2;

import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.template.t2.struct.Pagelets;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class RightPageletTemplatePage extends T2TemplatePage {

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);
		addHtmlViewVariable(RightPageletTemplatePage.class, "content");
		addHtmlViewVariable(getClass(), "col1");
	}

	protected Pagelets getPagelets() {
		return null;
	}

	public String toPageletHTML(final PageParameter pParameter) {
		final Pagelets pagelets = getPagelets();
		return pagelets != null ? pagelets.toString() : "";
	}
}

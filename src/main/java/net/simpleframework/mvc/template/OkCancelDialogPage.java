package net.simpleframework.mvc.template;

import net.simpleframework.mvc.PageParameter;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class OkCancelDialogPage extends FormExTemplatePage {
	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);
		addHtmlViewVariable(OkCancelDialogPage.class, "form");
		addHtmlViewVariable(getClass(), "ok_cancel_form");
	}

	/**
	 * 表单上方的标题，可不设置
	 * 
	 * @param pageParameter
	 * @return
	 */
	public String title(final PageParameter pParameter) {
		return null;
	}
}

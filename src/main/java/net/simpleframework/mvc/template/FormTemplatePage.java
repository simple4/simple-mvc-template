package net.simpleframework.mvc.template;

import java.util.Map;

import net.simpleframework.mvc.IPageHandler.PageSelector;
import net.simpleframework.mvc.PageParameter;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class FormTemplatePage extends AbstractTemplatePage {

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);
		addHtmlViewVariable(getClass(), "form");

		getPageBean().setHandleClass(getClass().getName()).setHandleMethod("onLoad");
	}

	/**
	 * Form页面的初始化函数，子类覆盖
	 * 
	 * @param pageParameter
	 * @param dataBinding
	 * @param selector
	 */
	public void onLoad(final PageParameter pParameter, final Map<String, Object> dataBinding,
			final PageSelector selector) {
	}

	public String formId() {
		return "id" + className();
	}

	private final String className = getClass().getSimpleName();

	public String className() {
		return className;
	}
}

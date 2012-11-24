package net.simpleframework.mvc.template;

import net.simpleframework.common.html.element.ButtonElement;
import net.simpleframework.mvc.JavascriptForward;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.ComponentParameter;
import net.simpleframework.mvc.component.base.validation.EWarnType;
import net.simpleframework.mvc.component.base.validation.ValidationBean;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class FormExTemplatePage extends FormTemplatePage {

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);

		// 添加一个ajaxRequest组件
		addAjaxRequest(pParameter, className() + "_ajax").setHandleMethod("doSave").setSelector(
				"#" + formId() + " form");
	}

	protected ValidationBean addFormValidationBean(final PageParameter pParameter) {
		return addComponentBean(pParameter, className() + "_validation", ValidationBean.class)
				.setWarnType(EWarnType.insertAfter).setTriggerSelector("#" + formId() + " .button2");
	}

	/**
	 * 确认按钮的action函数
	 * 
	 * @param compParameter
	 * @return 返回浏览器端需要执行的javascript，缺省是关闭Dialog窗口，子类super得到后，然后重组自己的逻辑
	 */
	public JavascriptForward doSave(final ComponentParameter cParameter) {
		return new JavascriptForward().append("$win($Actions['")
				.append(cParameter.getBeanProperty("name")).append("'].trigger).close();");
	}

	protected String jsFormReset(final PageParameter pParameter) {
		return "$('#" + formId() + " form').reset();";
	}

	public String toButtonsString(final PageParameter pParameter) {
		final StringBuilder sb = new StringBuilder();
		sb.append(ButtonElement.okBtn().setOnclick("$Actions['" + className() + "_ajax']();"));
		sb.append("&nbsp;");
		sb.append(ButtonElement.WINDOW_CLOSE);
		return sb.toString();
	}
}

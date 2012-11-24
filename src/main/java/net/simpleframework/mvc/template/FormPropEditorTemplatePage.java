package net.simpleframework.mvc.template;

import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.ui.propeditor.PropEditorBean;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class FormPropEditorTemplatePage extends FormExTemplatePage {

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);
		addHtmlViewVariable(FormPropEditorTemplatePage.class, "form");

		final PropEditorBean propEditor = (PropEditorBean) addComponentBean(pParameter,
				className() + "_propeditor", PropEditorBean.class).setContainerId(propEditorId());
		initPropEditor(pParameter, propEditor);
	}

	public String propEditorId() {
		return formId() + "_propeditor";
	}

	protected abstract void initPropEditor(PageParameter pParameter, PropEditorBean propEditor);
}

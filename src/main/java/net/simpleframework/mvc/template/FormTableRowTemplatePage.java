package net.simpleframework.mvc.template;

import static net.simpleframework.common.I18n.$m;
import net.simpleframework.common.html.element.BlockElement;
import net.simpleframework.common.html.element.ButtonElement;
import net.simpleframework.common.html.element.EInputType;
import net.simpleframework.common.html.element.InputElement;
import net.simpleframework.common.html.element.LabelElement;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.template.struct.TableRows;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class FormTableRowTemplatePage extends FormExTemplatePage {

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);
		addHtmlViewVariable(FormTableRowTemplatePage.class, "form");
	}

	/**
	 * 定义label的宽度
	 * 
	 * @param pParameter
	 * @return
	 */
	public int labelWidth(final PageParameter pParameter) {
		return 100;
	}

	/**
	 * 
	 * @return
	 */
	protected TableRows tableRows(final PageParameter pParameter) {
		return null;
	}

	public String toTableRowsString(final PageParameter pParameter) {
		final TableRows tableRows = tableRows(pParameter);
		return tableRows != null ? tableRows.toString() : "";
	}

	protected boolean show_opt_next(final PageParameter pParameter) {
		return false;
	}

	protected static final String OPT_NEXT = "opt_next";

	public String toOptString(final PageParameter pParameter) {
		final StringBuilder sb = new StringBuilder();
		if (show_opt_next(pParameter)) {
			final String id = className() + "_opt_next";
			sb.append(new BlockElement().addElements(
					new InputElement().setInputType(EInputType.checkbox).setId(id).setName(OPT_NEXT),
					new LabelElement($m("FormExTemplatePage.0")).setForId(id)));
		}
		return sb.toString();
	}

	@Override
	public String toButtonsString(final PageParameter pParameter) {
		final StringBuilder sb = new StringBuilder();
		sb.append(ButtonElement.okBtn().setOnclick(
				"$Actions['" + className() + "_ajax']($Form(this.up('.btn').down('.opt')));"));
		sb.append("&nbsp;");
		sb.append(ButtonElement.WINDOW_CLOSE);
		return sb.toString();
	}
}

package net.simpleframework.mvc.template.struct;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.coll.ArrayUtils;
import net.simpleframework.common.html.element.AbstractInputElement;
import net.simpleframework.common.html.element.EInputType;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class TextButtonInput extends AbstractInputElement<TextButtonInput> {
	{
		setReadonly(true);
	}
	/**
	 * 自动生成一个名字和id一样的隐藏域
	 */
	private String hiddenField;

	public TextButtonInput() {
	}

	public TextButtonInput(final String id) {
		setId(id);
		setName(id);
	}

	public String getHiddenField() {
		return hiddenField;
	}

	public TextButtonInput setHiddenField(final String hiddenField) {
		this.hiddenField = hiddenField;
		return this;
	}

	@Override
	public EInputType getInputType() {
		return EInputType.textButton;
	}

	@Override
	protected void doAttri(final StringBuilder sb) {
		super.doAttri(sb);
		final String hiddenField = getHiddenField();
		if (StringUtils.hasText(hiddenField)) {
			sb.append(" hidden_field='").append(hiddenField).append("'");
		}
	}

	protected String getDefaultClassName() {
		return "text_button";
	}

	@Override
	protected String className(final String... classNames) {
		return super.className(ArrayUtils.add(new String[] { getDefaultClassName() }, classNames));
	}
}

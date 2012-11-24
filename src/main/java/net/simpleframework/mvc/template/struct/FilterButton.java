package net.simpleframework.mvc.template.struct;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.coll.ArrayUtils;
import net.simpleframework.common.html.element.SpanElement;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class FilterButton extends SpanElement {
	private String ondelete;

	public FilterButton(final Object text) {
		super(text);
	}

	public String getOndelete() {
		return ondelete;
	}

	public FilterButton setOndelete(final String ondelete) {
		this.ondelete = ondelete;
		return this;
	}

	@Override
	protected String className(final String... classNames) {
		return super.className(ArrayUtils.add(new String[] { "item" }, classNames));
	}

	@Override
	public String getText() {
		final StringBuilder sb = new StringBuilder();
		sb.append(super.getText());
		sb.append("<span class='del'");
		final String ondelete = getOndelete();
		if (StringUtils.hasText(ondelete)) {
			sb.append(" onclick=\"").append(ondelete).append("\"");
		}
		sb.append("></span>");
		return sb.toString();
	}
}

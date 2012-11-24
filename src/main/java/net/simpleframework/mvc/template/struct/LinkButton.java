package net.simpleframework.mvc.template.struct;

import net.simpleframework.common.coll.ArrayUtils;
import net.simpleframework.common.html.element.AbstractButtonEx;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class LinkButton extends AbstractButtonEx<LinkButton> {

	public static final LinkButton WINDOW_CLOSE = new LinkButton("#(Button.Close)")
			.setOnclick("$win(this).close();");

	public static final LinkButton SEP = new LinkButton("").setSeparator(true);

	public static LinkButton of(final Object text) {
		return new LinkButton(text);
	}

	public LinkButton(final Object text) {
		super(text);
	}

	@Override
	protected String className(final String... classNames) {
		return super.className(ArrayUtils.add(new String[] { "simple_btn" }, classNames));
	}
}

package net.simpleframework.mvc.template.struct;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.coll.ArrayListEx;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public final class LinkButtons extends ArrayListEx<LinkButtons, LinkButton> {

	public static LinkButtons of(final LinkButton... btns) {
		return new LinkButtons().append(btns);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		final int size = this.size();
		for (int i = 0; i < size; i++) {
			final LinkButton btn = get(i);
			String className = null;
			if (size == 1) {
				className = "simple_btn_all";
			} else {
				if (i == 0) {
					className = "simple_btn_left";
				} else if (i == (size - 1)) {
					className = "simple_btn_right";
				}
				if (i > 0 && get(i - 1).isSeparator()) {
					className = className != null ? "simple_btn_all" : "simple_btn_left";
				}
				if (i < (size - 1) && get(i + 1).isSeparator()) {
					className = className != null ? "simple_btn_all" : "simple_btn_right";
				}
			}
			if (className != null) {
				final String className2 = btn.getClassName();
				if (StringUtils.hasText(className2)) {
					className += " " + className2;
				}
				btn.setClassName(className);
			}
			sb.append(btn);
		}

		// sb.append("<script type=\"text/javascript\">");
		// sb.append("$ready(function() { if (!Tip) return; $$('#").append(id);
		// sb.append(" a').each(function(a) {");
		// sb.append("var d = a.next(); if (d) new Tip(a, d.innerHTML, ");
		// sb.append("{ stem: 'topMiddle', delay: 0.5, hideAfter: 5, hook: { target: 'bottomMiddle', tip: 'topMiddle' } });");
		// sb.append("}); });");
		// sb.append("</script>");
		return sb.toString();
	}

	private static final long serialVersionUID = 1529222621302258765L;
}

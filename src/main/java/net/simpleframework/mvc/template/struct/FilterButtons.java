package net.simpleframework.mvc.template.struct;

import net.simpleframework.common.coll.ArrayListEx;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class FilterButtons extends ArrayListEx<FilterButtons, FilterButton> {

	public static FilterButtons of(final FilterButton... item) {
		return new FilterButtons().append(item);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		int i = 0;
		for (final FilterButton item : this) {
			if (i++ > 0) {
				sb.append("<span style=\"display: inline-block; width: 8px;\"></span>");
			}
			sb.append(item);
		}
		return sb.toString();
	}

	private static final long serialVersionUID = 5885583406084231852L;
}

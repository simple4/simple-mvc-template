package net.simpleframework.mvc.template.t2.struct;

import net.simpleframework.common.coll.ArrayListEx;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class Pagelets extends ArrayListEx<Pagelets, Pagelet> {

	public static Pagelets of(final Pagelet... lets) {
		return new Pagelets().append(lets);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		for (final Pagelet let : this) {
			sb.append(let);
		}
		return sb.toString();
	}

	private static final long serialVersionUID = -8582013991587709448L;
}

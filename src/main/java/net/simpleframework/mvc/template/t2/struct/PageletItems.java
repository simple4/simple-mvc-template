package net.simpleframework.mvc.template.t2.struct;

import net.simpleframework.common.coll.ArrayListEx;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class PageletItems extends ArrayListEx<PageletItems, PageletItem> {

	public static PageletItems of(final PageletItem... items) {
		return new PageletItems().append(items);
	}

	private static final long serialVersionUID = -3115982190346893038L;
}

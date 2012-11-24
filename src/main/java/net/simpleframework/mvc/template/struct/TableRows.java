package net.simpleframework.mvc.template.struct;

import net.simpleframework.common.coll.ArrayListEx;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class TableRows extends ArrayListEx<TableRows, TableRow> {
	public static TableRows of(final TableRow... rows) {
		return new TableRows().append(rows);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		for (final TableRow row : this) {
			sb.append(row);
		}
		return sb.toString();
	}

	private static final long serialVersionUID = 7977394637833523185L;
}

package net.simpleframework.mvc.template.struct;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.coll.ArrayListEx;
import net.simpleframework.common.html.element.AbstractElement;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class TableRow extends ArrayListEx<TableRow, RowField> {

	public TableRow(final RowField... rows) {
		if (rows != null) {
			for (final RowField r : rows) {
				add(r);
			}
		}
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		final int size = size();
		if (size > 0) {
			sb.append("<table class='form_tbl'>");
			sb.append("  <tr>");
			for (final RowField li : this) {
				sb.append(" <td class='l'");
				final String labelStyle = li.getLabelStyle();
				if (StringUtils.hasText(labelStyle)) {
					sb.append(" style='").append(labelStyle).append("'");
				}
				sb.append(">").append(li.getLabel()).append("</td>");
				sb.append(" <td class='v'");
				final String elementsStyle = li.getElementsStyle();
				if (StringUtils.hasText(elementsStyle)) {
					sb.append(" style='").append(elementsStyle).append("'");
				}
				sb.append(">");
				final AbstractElement<?>[] elements = li.getInputElements();
				if (elements != null) {
					for (final AbstractElement<?> ele : elements) {
						sb.append(ele);
					}
				}
				sb.append(" </td>");
			}
			sb.append("  </tr>");
			sb.append("</table>");
		}
		return sb.toString();
	}

	private static final long serialVersionUID = -5881344205644047999L;
}

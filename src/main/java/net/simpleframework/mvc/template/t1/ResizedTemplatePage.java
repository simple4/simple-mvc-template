package net.simpleframework.mvc.template.t1;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.coll.KVMap;
import net.simpleframework.common.script.MVEL2Template;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.template.struct.FilterButtons;
import net.simpleframework.mvc.template.struct.LinkButton;
import net.simpleframework.mvc.template.struct.LinkButtons;
import net.simpleframework.mvc.template.struct.SearchInput;
import net.simpleframework.mvc.template.struct.TabButtons;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class ResizedTemplatePage extends T1TemplatePage {

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);
		addHtmlViewVariable(ResizedTemplatePage.class, "body");
		addHtmlViewVariable(getClass(), "content");
	}

	protected TabButtons getTabButtons(final PageParameter pParameter) {
		return null;
	}

	public String toTabsHTML(final PageParameter pParameter) {
		final StringBuilder sb = new StringBuilder();
		final TabButtons tabs = getTabButtons(pParameter);
		if (tabs != null && tabs.size() > 0) {
			sb.append("<div class='tb_class'><div class='tab'>");
			sb.append(tabs.toString(pParameter));
			sb.append("</div></div>");
		}
		return sb.toString();
	}

	/**
	 * 在顶部区域定义一个工具条
	 * 
	 * @param pParameter
	 * @return
	 */
	public String toToolbarHTML(final PageParameter pParameter) {
		final LinkButtons links = getToolbarButtons(pParameter);
		final SearchInput sbtn = getSearchInput(pParameter);
		if (links == null && sbtn == null) {
			return "";
		}
		final StringBuilder sb = new StringBuilder();
		if (links != null) {
			for (final LinkButton link : links) {
				final String href = link.getHref();
				if (StringUtils.hasText(href)) {
					link.setHref(pParameter.wrapContextPath(href));
				}
			}
			sb.append("<div class='btns'>").append(links).append("</div>");
		}
		if (sbtn != null) {
			final String id = "id_" + StringUtils.hash(sbtn);
			sb.append(sbtn.setId(id).addStyle("float: right;"));
			sb.append(MVEL2Template.replace(new KVMap().add("id", id), ResizedTemplatePage.class,
					"js_SearchInputField.html"));
		}
		return sb.toString();
	}

	/**
	 * 按钮栏
	 * 
	 * @param pParameter
	 * @return
	 */
	protected LinkButtons getToolbarButtons(final PageParameter pParameter) {
		return null;
	}

	/**
	 * 在工具条下方定义一个当前过滤的面板
	 * 
	 * @param pParameter
	 * @return
	 */
	public String toFilterBarHTML(final PageParameter pParameter) {
		final FilterButtons items = getFilterButtons(pParameter);
		if (items != null) {
			return items.toString();
		}
		return null;
	}

	protected FilterButtons getFilterButtons(final PageParameter pParameter) {
		return null;
	}

	/**
	 * 搜索框
	 * 
	 * @param pParameter
	 * @return
	 */
	protected SearchInput getSearchInput(final PageParameter pParameter) {
		return null;
	}

	public String _toBarHTML(final PageParameter pParameter) {
		final StringBuilder sb = new StringBuilder();
		String html = toToolbarHTML(pParameter);
		if (StringUtils.hasText(html)) {
			sb.append("<div class='t_bar'>").append(html).append("</div>");
		}
		html = toFilterBarHTML(pParameter);
		if (StringUtils.hasText(html)) {
			sb.append("<div class='f_bar'>").append(html).append("</div>");
		}
		return sb.toString();
	}
}

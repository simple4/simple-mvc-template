package net.simpleframework.mvc.template.struct;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.simpleframework.common.ObjectUtils;
import net.simpleframework.common.StringUtils;
import net.simpleframework.common.coll.ArrayListEx;
import net.simpleframework.common.web.EUrlMatch;
import net.simpleframework.common.web.HttpUtils;
import net.simpleframework.mvc.PageRequestResponse;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class TabButtons extends ArrayListEx<TabButtons, TabButton> {
	public static TabButtons of(final TabButton... btns) {
		return of(0, btns);
	}

	public static TabButtons of(final int defaultIndex, final TabButton... btns) {
		return new TabButtons(defaultIndex).append(btns);
	}

	private int defaultIndex;

	private String tabsClass;

	private TabButtons(final int defaultIndex) {
		this.defaultIndex = defaultIndex;
	}

	public int getDefaultIndex() {
		return defaultIndex;
	}

	public String getTabsClass() {
		return StringUtils.text(tabsClass, "simple_tabs");
	}

	public void setTabsClass(final String tabsClass) {
		this.tabsClass = tabsClass;
	}

	public String toString(final PageRequestResponse rRequest) {
		final StringBuilder sb = new StringBuilder();
		final String id = UUID.randomUUID().toString();
		sb.append("<ul class=\"").append(getTabsClass()).append("\" id=\"").append(id).append("\">");
		// final String requestURI = HTTPUtils.parseURI(requestResponse.request);
		final String requestURI = HttpUtils.getRequestAndQueryStringUrl(rRequest.request);
		for (int i = 0; i < size(); i++) {
			final TabButton tab = get(i);
			boolean match = match(rRequest, tab, requestURI);
			if (!match) {
				final List<TabButton> children = tab.getChildren();
				if (children.size() > 0) {
					for (final TabButton tab2 : children) {
						if (match(rRequest, tab2, requestURI)) {
							match = true;
							break;
						}
					}
				}
			}
			if (match) {
				defaultIndex = i;
				break;
			}
		}
		boolean tooltip = false;
		for (int i = 0; i < size(); i++) {
			final TabButton tab = get(i);
			tab.setClassName(i == defaultIndex ? "active" : null);
			sb.append("<li>").append(tab).append("</li>");
			if (StringUtils.hasText(tab.getTitle())) {
				tooltip = true;
			}
		}
		sb.append("</ul>");
		if (tooltip) {
			sb.append("<script type=\"text/javascript\">");
			sb.append("$ready(function() { if (!window.Tip) return; $$('#").append(id);
			sb.append(" a').each(function(a) {");
			sb.append("var d = a.next(); if (d) new Tip(a, d.innerHTML, ");
			sb.append("{ stem: 'topMiddle', delay: 0.5, hideAfter: 5, hook: { target: 'bottomMiddle', tip: 'topMiddle' } });");
			sb.append("}); });");
			sb.append("</script>");
		}
		return sb.toString();
	}

	private boolean match(final PageRequestResponse rRequest, final TabButton tab, String requestURI) {
		Map<String, String> params = null, params2 = null;
		int pos = requestURI.indexOf("?");
		if (pos > -1) {
			params = HttpUtils.toQueryParams(requestURI.substring(pos + 1));
			requestURI = requestURI.substring(0, pos);
		}
		String href = tab.getHref();
		pos = href.indexOf("?");
		if (pos > -1) {
			params2 = HttpUtils.toQueryParams(href.substring(pos + 1));
			href = href.substring(0, pos);
		}
		if (params != null && params2 != null) {
			final HashSet<String> keys = new HashSet<String>();
			keys.addAll(params.keySet());
			keys.addAll(params2.keySet());
			for (final String key : keys) {
				// 如果两者都有相同的参数且不相等，则认为是不能匹配
				if (params.containsKey(key) && params2.containsKey(key)
						&& !ObjectUtils.objectEquals(params.get(key), params2.get(key))) {
					return false;
				}
			}
		}
		requestURI = HttpUtils.stripJSessionId(requestURI);
		requestURI = HttpUtils.stripContextPath(rRequest.request, requestURI);
		href = HttpUtils.stripContextPath(rRequest.request, href);

		final EUrlMatch method = tab.getMatchMethod();
		if (method == EUrlMatch.endsWith) {
			return requestURI.endsWith(href);
		} else if (method == EUrlMatch.startsWith) {
			return requestURI.startsWith(href);
		} else if (method == EUrlMatch.contains) {
			return requestURI.contains(href);
		} else {
			return requestURI.equals(href);
		}
	}

	private static final long serialVersionUID = -8125512004759930526L;
}

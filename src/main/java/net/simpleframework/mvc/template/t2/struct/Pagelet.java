package net.simpleframework.mvc.template.t2.struct;

import net.simpleframework.common.StringUtils;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class Pagelet {
	private PageletTitle title;

	private String content;

	private String className;

	public Pagelet(final PageletTitle title, final String content) {
		this.title = title;
		this.content = content;
	}

	public Pagelet(final PageletTitle title, final PageletItems pageletItems) {
		this.title = title;
		this.content = pageletItems.toString();
	}

	public PageletTitle getTitle() {
		return title;
	}

	public Pagelet setTitle(final PageletTitle title) {
		this.title = title;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Pagelet setContent(final String content) {
		this.content = content;
		return this;
	}

	public String getClassName() {
		return StringUtils.text(className, "let");
	}

	public Pagelet setClassName(final String className) {
		this.className = className;
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("<div class='").append(getClassName()).append("'>");
		sb.append("<div class='lh'>");
		final PageletTitle title = getTitle();
		if (title != null) {
			sb.append(title);
		}
		sb.append("</div>");
		sb.append("<div class='lc'>").append(StringUtils.blank(getContent())).append("</div>");
		sb.append("</div>");
		return sb.toString();
	}
}

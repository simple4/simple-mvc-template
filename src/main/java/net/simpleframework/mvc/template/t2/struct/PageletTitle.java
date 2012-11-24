package net.simpleframework.mvc.template.t2.struct;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class PageletTitle {

	private String title;

	private String icon;

	private boolean showMore = true;

	public PageletTitle(final String title, final String icon) {
		this.title = title;
		this.icon = icon;
	}

	public PageletTitle(final String title) {
		this(title, null);
	}

	public String getTitle() {
		return title;
	}

	public PageletTitle setTitle(final String title) {
		this.title = title;
		return this;
	}

	public String getIcon() {
		return icon;
	}

	public PageletTitle setIcon(final String icon) {
		this.icon = icon;
		return this;
	}

	public boolean isShowMore() {
		return showMore;
	}

	public PageletTitle setShowMore(final boolean showMore) {
		this.showMore = showMore;
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(getTitle());
		return sb.toString();
	}
}

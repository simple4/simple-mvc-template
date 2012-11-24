package net.simpleframework.mvc.template.struct;

import net.simpleframework.common.html.element.BlockElement;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class SearchInput extends BlockElement {

	/* 查找 */
	private String onSearchClick;

	/* 高级选项 */
	private String onAdvClick;

	private int inputWidth;

	public SearchInput() {
	}

	public String getOnSearchClick() {
		return onSearchClick;
	}

	public SearchInput setOnSearchClick(final String onSearchClick) {
		this.onSearchClick = onSearchClick;
		return this;
	}

	public String getOnAdvClick() {
		return onAdvClick;
	}

	public SearchInput setOnAdvClick(final String onAdvClick) {
		this.onAdvClick = onAdvClick;
		return this;
	}

	public int getInputWidth() {
		return inputWidth;
	}

	public SearchInput setInputWidth(final int inputWidth) {
		this.inputWidth = inputWidth;
		return this;
	}

	@Override
	protected void doAttri(final StringBuilder sb) {
		super.doAttri(sb);
		attri(sb, "onSearchClick");
		attri(sb, "onAdvClick");
		final int inputWidth = getInputWidth();
		if (inputWidth > 0) {
			attri(sb, "inputWidth");
		}
	}
}

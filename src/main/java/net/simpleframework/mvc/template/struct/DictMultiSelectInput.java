package net.simpleframework.mvc.template.struct;

import net.simpleframework.common.html.element.EInputType;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class DictMultiSelectInput extends DictInput {

	public DictMultiSelectInput() {
	}

	public DictMultiSelectInput(final String id) {
		super(id);
	}

	@Override
	public String getHiddenField() {
		return null;
	}

	@Override
	public EInputType getInputType() {
		return EInputType.multiSelect;
	}

	@Override
	protected String getDefaultClassName() {
		return "multi_select";
	}
}

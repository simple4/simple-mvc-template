package net.simpleframework.mvc.template.t1.ext;

import static net.simpleframework.common.I18n.$m;

import java.util.Map;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.coll.KVMap;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.ext.category.CategoryBean;
import net.simpleframework.mvc.component.ext.category.ICategoryHandler;
import net.simpleframework.mvc.template.AbstractTemplatePage;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class CategoryWindowPage extends AbstractTemplatePage {
	public static final String COMPONENT_CATEGORY = "CM_ComponentCategory";

	protected CategoryBean addCategoryBean(final PageParameter pParameter,
			final Class<? extends ICategoryHandler> handleClass) {
		return addCategoryBean(pParameter, COMPONENT_CATEGORY, handleClass);
	}

	protected CategoryBean addCategoryBean(final PageParameter pParameter, final String name,
			final Class<? extends ICategoryHandler> handleClass) {
		return (CategoryBean) addComponentBean(pParameter, name, CategoryBean.class).setContainerId(
				"category_" + StringUtils.hash(this)).setHandleClass(handleClass);
	}

	@Override
	public Map<String, Object> createVariables(final PageParameter pParameter) {
		return ((KVMap) super.createVariables(pParameter)).add("categoryId", "category_"
				+ StringUtils.hash(this));
	}

	public String toTopicString(final PageParameter pParameter) {
		return $m("CategoryWindowPage.0");
	}
}

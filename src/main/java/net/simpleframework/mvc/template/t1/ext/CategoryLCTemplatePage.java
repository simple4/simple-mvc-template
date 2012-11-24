package net.simpleframework.mvc.template.t1.ext;

import java.io.IOException;
import java.util.Map;

import net.simpleframework.common.StringUtils;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.ext.category.CategoryBean;
import net.simpleframework.mvc.component.ext.category.ICategoryHandler;
import net.simpleframework.mvc.template.t1.ResizedLCTemplatePage;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class CategoryLCTemplatePage extends ResizedLCTemplatePage {

	public static final String COMPONENT_CATEGORY = "TP_ComponentCategory";

	private CategoryBean categoryBean;

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);
		addHtmlViewVariable(getClass(), "content_center");
	}

	protected CategoryBean addCategoryBean(final PageParameter pParameter,
			final Class<? extends ICategoryHandler> handleClass) {
		return addCategoryBean(pParameter, COMPONENT_CATEGORY, handleClass);
	}

	protected CategoryBean addCategoryBean(final PageParameter pParameter, final String name,
			final Class<? extends ICategoryHandler> handleClass) {
		categoryBean = (CategoryBean) addComponentBean(pParameter, name, CategoryBean.class)
				.setContainerId("category_" + StringUtils.hash(this)).setHandleClass(handleClass);
		return categoryBean;
	}

	@Override
	protected String toHtml(final PageParameter pParameter, final Map<String, Object> variables,
			final String currentVariable) throws IOException {
		if ("content_left".equals(currentVariable)) {
			return "<div style='padding: 6px;' id='category_" + StringUtils.hash(this) + "'></div>";
		}
		return super.toHtml(pParameter, variables, currentVariable);
	}

	public CategoryBean getCategoryBean() {
		return categoryBean;
	}
}

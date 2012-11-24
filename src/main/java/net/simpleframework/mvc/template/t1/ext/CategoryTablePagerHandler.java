package net.simpleframework.mvc.template.t1.ext;

import java.util.ArrayList;
import java.util.Map;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.bean.IIdBeanAware;
import net.simpleframework.common.bean.ITreeBeanAware;
import net.simpleframework.common.coll.KVMap;
import net.simpleframework.common.html.element.ElementList;
import net.simpleframework.common.html.element.LabelElement;
import net.simpleframework.common.html.element.LinkElement;
import net.simpleframework.mvc.AbstractMVCPage;
import net.simpleframework.mvc.component.ComponentParameter;
import net.simpleframework.mvc.component.ui.pager.db.AbstractDbTablePagerHandler;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class CategoryTablePagerHandler extends AbstractDbTablePagerHandler {

	@Override
	public Map<String, Object> toJSON(final ComponentParameter cParameter) {
		final KVMap json = (KVMap) super.toJSON(cParameter);
		final String bar = ((CategoryTableLCTemplatePage) AbstractMVCPage.get(cParameter))
				._toCenterBarHTML(cParameter);
		if (StringUtils.hasText(bar)) {
			json.add("bar", bar);
		}
		return json;
	}

	protected <T extends ITreeBeanAware> ElementList doNavigationTitle(
			final ComponentParameter cParameter, final T category,
			final NavigationTitleCallback<T> callback) {
		final ElementList eles = new ElementList();
		if (category != null) {
			eles.add(new LinkElement(callback.rootText()).setOnclick(callback.onclick("")));
			T category2 = category;
			final ArrayList<T> al = new ArrayList<T>();
			while (category2 != null) {
				al.add(0, category2);
				category2 = callback.get(category2.getParentId());
			}
			int size;
			for (int i = 0; i < (size = al.size()); i++) {
				category2 = al.get(i);
				if (callback.isLink(category2) && i < size - 1) {
					eles.add(new LinkElement(category2).setOnclick(callback
							.onclick(((IIdBeanAware) category2).getId())));
				} else {
					eles.add(new LabelElement(category2));
				}
			}
		} else {
			eles.add(new LabelElement(callback.rootText()));
		}
		return eles;
	}

	protected static abstract class NavigationTitleCallback<T> {
		protected abstract T get(Object id);

		protected abstract String rootText();

		protected String categoryIdKey() {
			return "categoryId";
		}

		protected String onclick(final Object categoryId) {
			final StringBuilder sb = new StringBuilder();
			sb.append("$Actions['").append(CategoryTableLCTemplatePage.COMPONENT_TABLE);
			sb.append("']('").append(categoryIdKey()).append("=").append(categoryId).append("');");
			return sb.toString();
		}

		protected boolean isLink(final T t) {
			return true;
		}
	}
}

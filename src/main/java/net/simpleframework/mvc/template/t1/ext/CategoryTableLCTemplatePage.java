package net.simpleframework.mvc.template.t1.ext;

import java.util.Map;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.coll.KVMap;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.ui.pager.EPagerBarLayout;
import net.simpleframework.mvc.component.ui.pager.TablePagerBean;
import net.simpleframework.mvc.template.struct.LinkButton;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class CategoryTableLCTemplatePage extends CategoryLCTemplatePage {

	public static final String COMPONENT_TABLE = "TP_ComponentTable";

	@Override
	protected void onInit(final PageParameter pParameter) {
		super.onInit(pParameter);
		addHtmlViewVariable(CategoryTableLCTemplatePage.class, "content_center");
	}

	@Override
	public Map<String, Object> createVariables(final PageParameter pParameter) {
		return ((KVMap) super.createVariables(pParameter)).add("tableId",
				"table_" + StringUtils.hash(this));
	}

	protected TablePagerBean addTablePagerBean(final PageParameter pParameter,
			final Class<? extends CategoryTablePagerHandler> handleClass) {
		return (TablePagerBean) addComponentBean(pParameter, COMPONENT_TABLE, TablePagerBean.class)
				.setShowLineNo(true).setShowBorder(true).setPagerBarLayout(EPagerBarLayout.top)
				.setContainerId("table_" + StringUtils.hash(this)).setHandleClass(handleClass);
	}

	protected LinkButton act_btn(final String deleteAct, final String title) {
		final StringBuilder click = new StringBuilder();
		click.append("$Actions['").append(COMPONENT_TABLE).append("'].doAct('").append(deleteAct)
				.append("');");
		return new LinkButton(title).setOnclick(click.toString());
	}
}

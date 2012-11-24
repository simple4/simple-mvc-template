package net.simpleframework.mvc.template.t2;

import net.simpleframework.mvc.IMVCTemplate;
import net.simpleframework.mvc.component.ComponentParameter;
import net.simpleframework.mvc.component.ui.menu.MenuItem;
import net.simpleframework.mvc.component.ui.menu.MenuItems;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public interface IMVCTemplateT2 extends IMVCTemplate {

	/**
	 * 获取模板的主菜单数据
	 * 
	 * @param cParameter
	 * @param menuItem
	 * @return
	 */
	MenuItems getMenuItems(ComponentParameter cParameter, MenuItem menuItem);
}

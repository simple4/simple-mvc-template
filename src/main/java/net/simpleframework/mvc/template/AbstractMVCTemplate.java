package net.simpleframework.mvc.template;

import net.simpleframework.common.ObjectEx;
import net.simpleframework.ctx.IModuleContext;
import net.simpleframework.ctx.Module;
import net.simpleframework.ctx.ModuleContextFactory;
import net.simpleframework.ctx.ModuleFunction;
import net.simpleframework.ctx.ModuleFunctions;
import net.simpleframework.mvc.IMVCTemplate;
import net.simpleframework.mvc.component.ComponentParameter;
import net.simpleframework.mvc.component.ui.menu.MenuBean;
import net.simpleframework.mvc.component.ui.menu.MenuItem;
import net.simpleframework.mvc.component.ui.menu.MenuItems;
import net.simpleframework.mvc.ctx.WebModuleFunction;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class AbstractMVCTemplate extends ObjectEx implements IMVCTemplate {

	public MenuItems getMenuItems(final ComponentParameter cParameter, final MenuItem menuItem) {
		final MenuBean menuBean = (MenuBean) cParameter.componentBean;

		final MenuItems al = MenuItems.of();
		int i = 0;
		for (final IModuleContext ctx : ModuleContextFactory.allModules()) {
			final Module module = ctx.getModule();
			MenuItem moduleItem = null;
			final ModuleFunction defaultFunction = module.getDefaultFunction();
			if (defaultFunction instanceof WebModuleFunction) {
				if (!defaultFunction.isDisabled()) {
					moduleItem = MenuItem.of(menuBean, defaultFunction.getText()).setUrl(
							((WebModuleFunction) defaultFunction).getUrl());
				}
			} else {
				moduleItem = MenuItem.of(menuBean, module.getText());
			}
			if (moduleItem != null) {
				if (i++ > 0) {
					al.add(MenuItem.sep(menuBean));
				}
				al.add(moduleItem);
				doSubItems(ctx, menuBean, moduleItem.children(), null);
			}
		}
		return al;
	}

	private void doSubItems(final IModuleContext ctx, final MenuBean menuBean,
			final MenuItems children, final ModuleFunction parent) {
		final ModuleFunctions functions = ctx.getFunctions(parent);
		if (functions != null) {
			for (final ModuleFunction function : functions) {
				if (function.isDisabled()) {
					continue;
				}
				if (!(function instanceof WebModuleFunction)) {
					continue;
				}
				final MenuItem item = MenuItem.of(menuBean, function.getText()).setUrl(
						((WebModuleFunction) function).getUrl());
				children.add(item);
				doSubItems(ctx, menuBean, item.children(), function);
			}
		}
	}
}

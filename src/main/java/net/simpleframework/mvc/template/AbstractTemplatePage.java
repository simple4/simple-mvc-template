package net.simpleframework.mvc.template;

import net.simpleframework.common.NotImplementedException;
import net.simpleframework.ctx.IModuleContext;
import net.simpleframework.ctx.ITransactionCallback;
import net.simpleframework.mvc.AbstractBasePage;
import net.simpleframework.mvc.IForwardCallback.IJavascriptForwardCallback;
import net.simpleframework.mvc.IForwardCallback.IJsonForwardCallback;
import net.simpleframework.mvc.JavascriptForward;
import net.simpleframework.mvc.JsonForward;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class AbstractTemplatePage extends AbstractBasePage {

	/**
	 * 获取客户端context
	 * 
	 * @return
	 */
	protected IModuleContext context() {
		try {
			return (IModuleContext) getClass().getField("context").get(null);
		} catch (final Exception e) {
		}
		throw NotImplementedException.of(getClass(), "context");
	}

	public JsonForward doJsonForward(final IJsonForwardCallback callback) {
		final JsonForward json = new JsonForward();
		context().doExecuteTransaction(new ITransactionCallback() {
			@Override
			public void doTransaction(final IModuleContext moduleContext) {
				callback.doAction(json);
			}
		});
		return json;
	}

	public JavascriptForward doJavascriptForward(final IJavascriptForwardCallback callback) {
		final JavascriptForward js = new JavascriptForward();
		context().doExecuteTransaction(new ITransactionCallback() {
			@Override
			public void doTransaction(final IModuleContext moduleContext) {
				callback.doAction(js);
			}
		});
		return js;
	}
}

package net.simpleframework.mvc.template.struct;

import java.util.ArrayList;
import java.util.Map;

import net.simpleframework.common.Convert;
import net.simpleframework.common.StringUtils;
import net.simpleframework.common.coll.KVMap;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class DictInput extends TextButtonInput {
	private String dictComponent;

	private Map<String, Object> parameters;

	public DictInput() {
	}

	public DictInput(final String id) {
		super(id);
	}

	public String getDictComponent() {
		return dictComponent;
	}

	public DictInput setDictComponent(final String dictComponent) {
		this.dictComponent = dictComponent;
		return this;
	}

	public Map<String, Object> getParameters() {
		if (parameters == null) {
			parameters = new KVMap();
		}
		return parameters;
	}

	public DictInput addParameter(final String key, final Object val) {
		getParameters().put(key, val);
		return this;
	}

	@Override
	protected void doAttri(final StringBuilder sb) {
		super.doAttri(sb);
		final String dictComponent = getDictComponent();
		if (StringUtils.hasText(dictComponent)) {
			sb.append(" dict_component='").append(dictComponent).append("'");
		}
		final Map<String, Object> parameters = getParameters();
		if (parameters.size() > 0) {
			final ArrayList<String> al = new ArrayList<String>();
			for (final Map.Entry<String, Object> e : parameters.entrySet()) {
				al.add(e.getKey() + "=" + Convert.toString(e.getValue()));
			}
			sb.append(" dict_parameter='").append(StringUtils.join(al, "&amp;")).append("'");
		}
	}
}

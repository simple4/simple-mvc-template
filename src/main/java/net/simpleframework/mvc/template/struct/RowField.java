package net.simpleframework.mvc.template.struct;

import java.util.Set;

import net.simpleframework.common.StringUtils;
import net.simpleframework.common.html.element.AbstractElement;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class RowField {
	private String label;

	private AbstractElement<?>[] inputElements;

	private String labelStyle, elementsStyle;

	public RowField(final String label, final AbstractElement<?>... inputElements) {
		setLabel(label);
		setInputElements(inputElements);
	}

	public String getLabel() {
		return label;
	}

	public RowField setLabel(final String label) {
		this.label = label;
		return this;
	}

	public AbstractElement<?>[] getInputElements() {
		return inputElements;
	}

	public RowField setInputElements(final AbstractElement<?>[] inputElements) {
		this.inputElements = inputElements;
		return this;
	}

	public String getElementsStyle() {
		return elementsStyle;
	}

	public RowField setElementsStyle(final String elementsStyle) {
		this.elementsStyle = elementsStyle;
		return this;
	}

	public RowField addElementsStyle(final String elementsStyle) {
		final Set<String> s1 = AbstractElement.toSet(getElementsStyle());
		s1.addAll(AbstractElement.toSet(elementsStyle));
		this.elementsStyle = StringUtils.join(s1);
		return this;
	}

	public String getLabelStyle() {
		return labelStyle;
	}

	public RowField setLabelStyle(final String labelStyle) {
		this.labelStyle = labelStyle;
		return this;
	}

	public RowField addLabelStyle(final String labelStyle) {
		final Set<String> s1 = AbstractElement.toSet(getLabelStyle());
		s1.addAll(AbstractElement.toSet(labelStyle));
		this.labelStyle = StringUtils.join(s1);
		return this;
	}
}

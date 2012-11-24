package net.simpleframework.mvc.template.struct;

import net.simpleframework.common.StringUtils;

/**
 * 这是一个开源的软件，请在LGPLv3下合法使用、修改或重新发布。
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class CalendarInput extends TextButtonInput {
	private String calendarComponent;

	private String dateFormat;

	public CalendarInput() {
	}

	public CalendarInput(final String id) {
		super(id);
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public CalendarInput setDateFormat(final String dateFormat) {
		this.dateFormat = dateFormat;
		return this;
	}

	public String getCalendarComponent() {
		return calendarComponent;
	}

	public CalendarInput setCalendarComponent(final String calendarComponent) {
		this.calendarComponent = calendarComponent;
		return this;
	}

	@Override
	protected void doAttri(final StringBuilder sb) {
		super.doAttri(sb);
		final String calendarComponent = getCalendarComponent();
		if (StringUtils.hasText(calendarComponent)) {
			sb.append(" calendar_component='").append(calendarComponent).append("'");
		}
		final String dateFormat = getDateFormat();
		if (StringUtils.hasText(dateFormat)) {
			sb.append(" date_format='").append(dateFormat).append("'");
		}
	}
}

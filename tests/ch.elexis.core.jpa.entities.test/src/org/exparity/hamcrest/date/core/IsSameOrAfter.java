package org.exparity.hamcrest.date.core;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is before or the same instant as
 * the reference date
 *
 * @author Stewart Bissett
 */
public class IsSameOrAfter<T> extends TypeSafeDiagnosingMatcher<T> {

	private final TemporalWrapper<T> expected;
	private final TemporalFormatter<T> describer;

	public IsSameOrAfter(final TemporalWrapper<T> expected, final TemporalFormatter<T> describer) {
		this.expected = expected;
		this.describer = describer;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		if (this.expected.isAfter(actual)) {
			mismatchDescription.appendText("the date is " + this.describer.describe(actual));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date is on the same date or after " + this.describer.describe(this.expected.unwrap()));
	}

}

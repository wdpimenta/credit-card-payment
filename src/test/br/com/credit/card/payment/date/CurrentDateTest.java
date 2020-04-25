package br.com.credit.card.payment.date;

import com.jcabi.matchers.RegexMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class CurrentDateTest {


    @Test
    void nowShouldBeFormatDatetime() {
        String datetime = CurrentDate.now();
        assertThat(datetime, RegexMatchers.matchesPattern("\\d{1,2}:\\d{1,2}:\\d{1,2} \\d{2}/\\d{2}/\\d{4}"));
    }

    @Test
    void date() {
        var today = CurrentDate.today();
        assertThat(today, RegexMatchers.matchesPattern("\\d{2}/\\d{2}/\\d{4}"));
    }

}
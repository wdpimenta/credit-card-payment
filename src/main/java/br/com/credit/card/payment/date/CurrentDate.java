package br.com.credit.card.payment.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrentDate {
    private CurrentDate() {
    }

    public static String now() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return simpleDateFormat.format(Calendar.getInstance().getTime());
    }

    public static String today() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(Calendar.getInstance().getTime());
    }
}

package br.com.lsena.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Capitulo10 {

    public static void main(String[] args) {
        LocalTime agora = LocalTime.now();
        LocalDate hoje = LocalDate.now();
        LocalDateTime dataEHora = hoje.atTime(agora);
        ZonedDateTime dataComhoraETimezone = dataEHora.atZone(ZoneId.of("America/Sao_Paulo"));
        LocalDateTime semTimeZone = dataComhoraETimezone.toLocalDateTime();

        LocalDate date = LocalDate.of(2019, 5, 15);
        LocalDateTime dateTime = LocalDateTime.of(2019, 5, 16, 10, 38, 50);
        LocalDate dataDoPassado = LocalDate.now().withYear(1987);
        dataDoPassado.getYear();
        hoje = LocalDate.now();
        LocalDate amanha = LocalDate.now().plusDays(1);
        hoje.isBefore(amanha);
        hoje.isAfter(amanha);
        hoje.isEqual(amanha);
        hoje.isEqual(hoje);
        amanha.isAfter(hoje);
        ZonedDateTime tokyo = ZonedDateTime.of(2019, 5, 16, 10, 45, 0, 0, ZoneId.of("Asia/Tokyo"));
        ZonedDateTime saoPaulo = ZonedDateTime.of(2019, 5, 16, 10, 45, 0, 0, ZoneId.of("America/Sao_Paulo"));
        tokyo.isEqual(saoPaulo);
        tokyo.plusHours(12).isEqual(saoPaulo);
        MonthDay.now();
        MonthDay.now().getDayOfMonth();
        MonthDay.now().getMonth();
        MonthDay.now().getMonthValue();
        YearMonth.now();
        YearMonth.now().getYear();
        LocalDate.of(2019, Month.MAY, 16);
        Month.DECEMBER.firstMonthOfQuarter();
        Month.DECEMBER.plus(1);
        Month.DECEMBER.plus(4);
        Month.DECEMBER.minus(4);
        Month.DECEMBER.minus(1);
        Locale pt = new Locale("pt");
        Month.DECEMBER.getDisplayName(TextStyle.FULL, pt);
        Month.DECEMBER.getDisplayName(TextStyle.SHORT, pt);
        DayOfWeek.FRIDAY.getDisplayName(TextStyle.FULL, pt);

        LocalDateTime.now();
        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate.parse("16/5/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate.of(2019, Month.FEBRUARY, 30);
        LocalDate.of(2019, Month.FEBRUARY, 29);
        LocalDate.of(2019, Month.FEBRUARY, 28);
        LocalDate.of(2020, Month.FEBRUARY, 29);

    }
}

package Java8Features;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class LocalDateNowOf {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.of(2003, 8, 9);
        int dayOfMonth = now.getDayOfMonth();
        LocalDate localDate1 = now.minusDays(1);
        System.out.println(now+" \n"+ localDate+"\n "+dayOfMonth+" \n"+localDate1);
//        LocalDateTime parse = LocalDateTime.parse("2023-02-03");
//        System.out.println(parse);
        System.out.println(ZonedDateTime.now());
        Set<String> here = ZoneId.getAvailableZoneIds();
        System.out.println(here);
        ZonedDateTime now1 = ZonedDateTime.now(ZoneId.of("America/Cuiaba"));
        System.out.println(now1);
        System.out.println(Instant.now());


    }
}

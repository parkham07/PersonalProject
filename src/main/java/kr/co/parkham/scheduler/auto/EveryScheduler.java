package kr.co.parkham.scheduler.auto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class EveryScheduler {

    @Scheduled(cron = "0 * * * * ?")
    public void every() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();
        String str = sdf.format(date);

        System.out.println(this.getClass().getName() + " : " + str);
    }
}

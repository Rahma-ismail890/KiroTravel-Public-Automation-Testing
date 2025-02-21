package DataReader;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class DynamicDateAndTime {
    WebDriver driver;
    public DynamicDateAndTime(WebDriver driver){
        this.driver=driver;

    }
    /**
     *
     * @param PlusDays to get any future day
     * @param MinusDays to get day in past
     *  if MinusDays and PlusDays equal zero it return the current day
     * @return
     */
    public String Date(int PlusDays, int MinusDays) {

        LocalDate currentDate = LocalDate.now();
        LocalDate selectedDate  = currentDate.plusDays(PlusDays).minusDays(MinusDays);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = selectedDate.format(dateFormatter);
        return  date;
    }

    /**
     *
     * @param PlusHours   to get any future time
     * @param MinusHours  to git time in past
     * if MinusTime and PlusTime equal zero it return the current time
     * @return
     */
    public String Time(int PlusHours, int MinusHours) {

        LocalTime currentTime = LocalTime.now();
        LocalTime selectedTime = currentTime.plusHours(PlusHours).minusHours(MinusHours); // Add 1 hour to the current time
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mma");
        String time = selectedTime.format(timeFormatter);
        System.out.println(time);
         return  time;

    }
}

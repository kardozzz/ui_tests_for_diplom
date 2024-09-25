package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {
        $(".react-datepicker__year-select").$("option[value='" + year + "']").click();
        $(".react-datepicker__month-select").$("option[value='" + month + "']").click(); // Июль - это 6
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }

}
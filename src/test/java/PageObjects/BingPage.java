package PageObjects;

import lombok.Getter;

@Getter
public class BingPage {
    private String url = "https://www.bing.com/";
    private String seachTextbox = "#sb_form_q";
    private String seachIcon = "#search_icon";
}

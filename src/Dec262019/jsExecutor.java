package Dec262019;

import Libs.MethLib;
import org.openqa.selenium.WebDriver;

public class jsExecutor {
    public static void main(String[] args) {
        WebDriver driver = MethLib.getDriver();
        driver.get("");
    }
}

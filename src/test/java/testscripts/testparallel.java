package testscripts;

import base.BaseTest;
import interactions.TapOn;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class testparallel extends BaseTest {

    Actor user = Actor.named("victoria");
    @Managed
    private WebDriver driver;

    @Test
    @WithTags({@WithTag("regression")})
    public void testpara() {
        user.can(BrowseTheWeb.with(driver));
        Target target = Target.the("continue with email").locatedForAndroid(By.id("com.todoist:id/btn_welcome_continue_with_email")).locatedForIOS(By.id(""));
        user.attemptsTo(TapOn.the(target));
        System.out.println("test suites 2" + ThucydidesWebDriverSupport.getDriver().toString());
    }

    @Test
    @WithTags({@WithTag("smoke")})
    public void testpara1() {
        user.can(BrowseTheWeb.with(driver));
        Target target = Target.the("continue with email").locatedForAndroid(By.id("com.todoist:id/btn_welcome_continue_with_email")).locatedForIOS(By.id(""));
        user.attemptsTo(TapOn.the(target));
        System.out.println("test suites 2" + ThucydidesWebDriverSupport.getDriver().toString());
    }
}

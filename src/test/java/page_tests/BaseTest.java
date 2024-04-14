package page_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import page_objects.CardMenuPage;
import page_objects.CreateCardsPage;
import page_objects.DeleteCardsPage;
import page_objects.EditCardsPage;
import page_objects.LoginPage;
import page_objects.MainMenuPage;
import page_objects.SubjectPage;
import page_objects.TrainingCardResultsPage;
import page_objects.TrainingMenuPage;
import page_objects.TrainingPage;
import page_objects.TrainingSessionPage;
import page_objects.TrainingSessionsPage;
import page_objects.TrainingSetupPage;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public LoginPage loginPage;
    public SubjectPage subjectPage;
    public MainMenuPage mainMenuPage;
    public CardMenuPage cardMenuPage;
    public CreateCardsPage createCardsPage;
    public EditCardsPage editCardsPage;
    public DeleteCardsPage deleteCardsPage;
    public TrainingMenuPage trainingMenuPage;
    public TrainingSetupPage trainingSetupPage;
    public TrainingPage trainingPage;
    public TrainingSessionsPage trainingSessionsPage;
    public TrainingSessionPage trainingSessionPage;
    public TrainingCardResultsPage trainingCardResultsPage;

    public static ChromeOptions options;
    public static WebDriver webDriver;
    public String uuidPwd;
    public String uuidUser;
    public String uuidSubject;
    public String uuidCard1Question;
    public String uuidCard1Answer;
    public String uuidCard2Question;
    public String uuidCard2Answer;
    public String uuidCard3Question;
    public String uuidCard3Answer;
    public final By subjectPageId = By.id("subject-page-id");
    public final By mainMenuPageId = By.id("main-menu-page-id");
    public final By loginPageId = By.id("login-user-name");
    public final By editCardsPageId = By.id("edit-cards-page-id");
    public final By deleteCardsPageId = By.id("delete-cards-page-id");
    public final By cardMenuPageId = By.id("card-menu-page-id");
    public final By createCardsPageId = By.id("create-cards-page-id");
    public final By trainingMenuPageId = By.id("training-menu-page-id");
    public final By trainingPageId = By.id("training-page-id");
    public final By trainingSetupPageId = By.id("training-setup-page-id");
    public final By trainingSessionPageId = By.id("training-session-page-id");
    public final By trainingSessionsPageId = By.id("training-sessions-page-id");
    public final By trainingCardResultsPageId = By.id("training-card-results-page-id");
    public final By doneWithRoundText = By.id("done-with-round-text");
    public final By doneWithTrainingText = By.id("done-with-training-text");


    @BeforeTest
    public void setupSuite() {
        options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote.allow.origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @BeforeMethod
    public void setUpBaseTest() {
        UUID uuid = UUID.randomUUID();
        uuidPwd = "pwd" + uuid.toString();
        uuidUser = "user" + uuid.toString();
        uuidSubject = "subject" + uuid.toString();

        uuidCard1Question = "card1Q" + uuid;
        uuidCard1Answer = "card1A" + uuid;
        uuidCard2Question = "card2Q" + uuid;
        uuidCard2Answer = "card2A" + uuid;
        uuidCard3Question = "card3Q" + uuid;
        uuidCard3Answer = "card3A" + uuid;

        webDriver.get("http://localhost:3000/");
        loginPage = new LoginPage(webDriver);
        subjectPage = new SubjectPage(webDriver);
        mainMenuPage = new MainMenuPage(webDriver);
        cardMenuPage = new CardMenuPage(webDriver);
        createCardsPage = new CreateCardsPage(webDriver);
        editCardsPage = new EditCardsPage(webDriver);
        deleteCardsPage = new DeleteCardsPage(webDriver);
        trainingMenuPage = new TrainingMenuPage(webDriver);
        trainingSetupPage = new TrainingSetupPage(webDriver);
        trainingPage = new TrainingPage(webDriver);
        trainingSessionsPage = new TrainingSessionsPage(webDriver);
        trainingSessionPage = new TrainingSessionPage(webDriver);
        trainingCardResultsPage = new TrainingCardResultsPage(webDriver);
    }

    @AfterTest
    public void tearDownSuite() {
        webDriver.close();
    }
}

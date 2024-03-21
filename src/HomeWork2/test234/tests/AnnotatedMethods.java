package HomeWork2.test234.tests;

public class AnnotatedMethods {
    @AfterEach
    public void afterEach(){System.out.println("afterEach");}
    @AfterAll
    public void afterAll(){
        System.out.println("afterAll");
    }
    @BeforeEach
    public void beforeEach() {System.out.println("beforeEach");}
    @BeforeAll
    public void beforeAll() {System.out.println("beforeAll");}






}
package main;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Marcos Ruiz Garcia [sobrenombre@gmail.com]
 */
public class ApplicationCreateTest {

    public ApplicationCreateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Application: Happy path
     */
    @Test
    public void testMainCreateEmptyField() throws Exception {
        System.out.printf(".");
        String[] args = new String[5];
        args[0] = "-create";
        args[1] = "-src";
        args[2] = "src/main/resources/hello.pdf";
        args[3] = "-dest";
        args[4] = "results/test/create/hello_empty_fields_1.pdf";
        Application.main(args);
    }


    @Test
    public void testMainCreateSeveralEmptyFields() throws Exception {
        createSeveralEmptyFields("top");
        createSeveralEmptyFields("bot");
        createSeveralEmptyFields("right");
        createSeveralEmptyFields("left");
    }

    public void createSeveralEmptyFields(String margin) throws Exception {
        String[] args = new String[9];
        args[0] = "-create";
        args[1] = "-src";
        args[2] = "src/main/resources/hello.pdf";
        args[3] = "-dest";
        args[5] = "-qos";
        args[7] = "-margin";
        args[8] = margin;

        String path_pre = "results/test/create/hello_empty_fields_" + margin + "_";
        String path_post = ".pdf";
        for (int i = 1; i <= 4; i++) {
            args[4] = path_pre + i + path_post;
            args[6] = "" + i;
            Application.main(args);
        }
    }
    @Test
    public void testMainCreateSeveralEmptyFieldsWithImage() throws Exception {
        createSeveralEmptyFieldsWithImg("top");
        createSeveralEmptyFieldsWithImg("bot");
        createSeveralEmptyFieldsWithImg("right");
        createSeveralEmptyFieldsWithImg("left");
    }
    public void createSeveralEmptyFieldsWithImg(String margin) throws Exception {
        String[] args = new String[11];
        args[0] = "-create";
        args[1] = "-src";
        args[2] = "src/main/resources/hello.pdf";
        args[3] = "-dest";
        args[5] = "-qos";
        args[7] = "-margin";
        args[8] = margin;
        args[9] = "-img";
        args[10] = "src/main/resources/icon6.png";

        String path_pre = "results/test/create/hello_empty_fields_with_img_" + margin + "_";
        String path_post = ".pdf";
        for (int i = 1; i <= 4; i++) {
            args[4] = path_pre + i + path_post;
            args[6] = "" + i;
            Application.main(args);
        }
    }
}
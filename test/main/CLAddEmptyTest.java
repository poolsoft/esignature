package main;

import java.io.File;
import static main.CLMainTest.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Marcos Ruiz Garcia [sobrenombre@gmail.com]
 */
public class CLAddEmptyTest {

    public CLAddEmptyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        File f;

        f = new File(PATH_RESULTS);
        if (!f.exists()) {
            f.mkdir();
        }
        f = new File(PATH_ADD_EMPTY);
        if (!f.exists()) {
            f.mkdir();
        }
        f = new File(PATH_ADD_SIGNATURE);
        if (!f.exists()) {
            f.mkdir();
        }
        f = new File(PATH_ADD_BC);
        if (!f.exists()) {
            f.mkdir();
        }
        f = new File(PATH_HTTP);
        if (!f.exists()) {
            f.mkdir();
        }
        f = new File(PATH_ADD_IMG);
        if (!f.exists()) {
            f.mkdir();
        }

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
     * Test of main method, of class AppController: Happy path
     */
    @Test
    public void testMainCreateEmptyField() throws Exception {
        System.out.printf(".");
        String[] args = new String[5];
        args[0] = "-addemptysigns";
        args[1] = "-src";
        args[2] = PATH_PDF + "hello.pdf";
        args[3] = "-dest";
        args[4] = PATH_ADD_EMPTY + "hello_empty_fields_1.pdf";
        CLController.main(args);
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
        args[0] = "-addemptysigns";
        args[1] = "-src";
        args[2] = PATH_PDF + "hello.pdf";
        args[3] = "-dest";
        args[5] = "-qos";
        args[7] = "-margin";
        args[8] = margin;

        String path_pre = PATH_ADD_EMPTY + "hello_empty_fields_" + margin + "_";
        String path_post = ".pdf";
        for (int i = 1; i <= 4; i++) {
            args[4] = path_pre + i + path_post;
            args[6] = "" + i;
            CLController.main(args);
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
        args[0] = "-addemptysigns";
        args[1] = "-src";
        args[2] = PATH_PDF + "hello.pdf";
        args[3] = "-dest";
        args[5] = "-qos";
        args[7] = "-margin";
        args[8] = margin;
        args[9] = "-img";
        args[10] = PATH_ICONS + "icon6.png";


        String path_pre = PATH_ADD_EMPTY + "hello_empty_fields_with_img_" + margin + "_";
        String path_post = ".pdf";
        for (int i = 1; i <= 4; i++) {
            args[4] = path_pre + i + path_post;
            args[6] = "" + i;

            CLController.main(args);
        }
    }

    ////////////////
    // ADD IMAGE //
    ///////////////
    @Test
    public void testAddImage() throws Exception {
        String[] args = new String[7];
        args[0] = "-addimage";
        args[1] = "-src";
        args[2] = PATH_PDF + "hello.pdf";
        args[3] = "-dest";
        args[4] = PATH_ADD_IMG + "hello_image_right_side.pdf";
        args[5] = "-img";
        args[6] = PATH_RESOURCES + "cb.png";

        CLController.main(args);

    }

    //////////////////
    // ADD BARCODE //
    /////////////////
    @Test
    public void testAddBarcode() throws Exception {
        String[] args = new String[7];
        args[0] = "-addbarcode";
        args[1] = "-src";
        args[2] = PATH_PDF + "hello.pdf";
        args[3] = "-dest";
        args[4] = PATH_ADD_BC + "hello_barcode_right_side.pdf";
        args[5] = "-code";
        args[6] = "58c905fa477ca304d1123ce3";

        CLController.main(args);
    }

    @Test
    public void testAddTextAndBarcode() throws Exception {
        String[] args = new String[9];
        args[0] = "-addbarcode";
        args[1] = "-src";
        args[2] = PATH_PDF + "hello.pdf";
        args[3] = "-dest";
        args[4] = PATH_ADD_BC + "hello_barcode_text_right_side.pdf";
        args[5] = "-code";
        args[6] = "58c905fa477ca304d1123ce3";
        args[7] = "-text";
        args[8] = "Esto es un texto de prueba";

        CLController.main(args);
    }

    @Test
    public void testHelp() throws Exception {
        String[] args = new String[1];
        args[0] = "-help";

        CLController.main(args);
    }

    ///////////////////
    // SRC FROM HTTP //
    ///////////////////
    @Test
    public void testCreateFromHttp() throws Exception {
        String[] args = new String[10];
        args[0] = "-addemptysigns";
        args[1] = "-src";
        args[2] = "http://eina.unizar.es/archivos/2016_2017/calendarios/Punto%202%20Calendarios%20y%20semanarios%20EINA%202016%202017.pdf";
        args[3] = "-dest";
        args[4] = PATH_HTTP + "hello_empty.pdf";
        args[5] = "-qos";
        args[6] = "2";
        args[7] = "-img";
        args[8] = PATH_ICONS + "icon6.png";
        args[9] = "-url";
        CLController.main(args);

        args[2] = "https://www.educa.jcyl.es/educacyl/cm/gallery/Recursos%20Infinity/tematicas/webquijote/pdf/DONQUIJOTE_PARTE1.pdf";
        args[4] = PATH_HTTP + "hello_empty_2.pdf";
        CLController.main(args);
    }

    @Test
    public void testCreateAbsolutePath() throws Exception {
        String[] args = new String[9];
        args[0] = "-addemptysigns";
        args[1] = "-src";
        args[2] = PATH_APP + PATH_PDF + "hello.pdf";
        args[3] = "-dest";
        args[4] = PATH_ADD_EMPTY + "hello_empty_fields_from_abs_path.pdf";
        args[5] = "-qos";
        args[6] = "1";
        args[7] = "-img";
        args[8] = PATH_APP + PATH_ICONS + "icon.png";

        CLController.main(args);
        System.out.println(args[8]);

    }


}

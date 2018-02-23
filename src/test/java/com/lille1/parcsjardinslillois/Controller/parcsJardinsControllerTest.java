package com.lille1.parcsjardinslillois.Controller;

import com.lille1.parcsjardinslillois.web.ParcJardinController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ParcJardinController.class, secure = false)
public class parcsJardinsControllerTest {


}

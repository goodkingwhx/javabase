import com.gk.service.Calculator;
import com.gk.service.MyCalculator;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author goodking
 * @data 2022-02-07 16:58
 */
public class MyTest {
    @Test
    public void test02() throws NoSuchMethodException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyCalculator calculator = context.getBean( MyCalculator.class);
        Integer add = calculator.div(1, 1);
        System.out.println(add);
        System.out.println(calculator.getClass());
        // spring会判断，有接口就用jdk代理，没有接口就用cglib
    }

}

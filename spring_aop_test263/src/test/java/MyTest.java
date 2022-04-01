import com.gk.proxy.CalculatorProxy;
import com.gk.service.Calculator;
import com.gk.service.MyCalculator;
import org.junit.Test;

/**
 * @author goodking
 * @data 2022-02-07 16:07
 */
public class MyTest {
    @Test
    public void test01() throws NoSuchMethodException {
        Calculator calculator = CalculatorProxy.getProxy(new MyCalculator());
        Integer div = calculator.div(7, 3);
        System.out.println(div);
        System.out.println(calculator.getClass());
    }
}

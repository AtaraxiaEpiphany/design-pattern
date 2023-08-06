package org.example.interpreter;

import org.example.interpreter.impl.Minus;
import org.example.interpreter.impl.Plus;
import org.example.interpreter.impl.Variable;
import org.junit.jupiter.api.Test;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.interpreter
 * @Date 06/08/2023 16:12
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        Context context = new Context();
        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        Variable d = new Variable("d");

        context.assign(a, 1);
        context.assign(b, 2);
        context.assign(c, 3);
        context.assign(d, 4);

        //获取抽象语法树
        AbstractExpression expression = new Minus(a, new Plus(new Minus(b, c), d));

        int result = expression.interpret(context);
        FG_GREEN.print("expression ==> %s",expression);
        FG_GREEN.print("result ==> %s",result);
    }
}

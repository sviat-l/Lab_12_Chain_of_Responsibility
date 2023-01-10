import chain_of_responsibility.Handler;
import chain_of_responsibility.Handler50;
import chain_of_responsibility.Handler20;
import chain_of_responsibility.Handler5;
import chain_of_responsibility.ATM;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class Tests {
    @Test
    public void testChainATM(){
        Handler handler50 = new Handler50();
        Handler handler20 = new Handler20();
        Handler handler5 = new Handler5();

        handler50.setNext(handler20);
        handler20.setNext(handler5);

        handler50.process(125);
        Assertions.assertThrows(IllegalArgumentException.class, () ->  handler50.process(126));
    }
}

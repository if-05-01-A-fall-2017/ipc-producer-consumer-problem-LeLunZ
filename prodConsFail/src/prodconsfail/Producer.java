/*
 * creater: Noisternig Luis
 * Date:
 * Description:
 */
package prodconsfail;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Noisternig
 */
public class Producer extends Thread{

    @Override
    public void run() {
        while(true){
            ProdConsFail.test++;
            if (ProdConsFail.N == ProdConsFail.count) {
                try {
                    synchronized(this){
                        System.out.println("Ich bin schlafen");
                        this.wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ProdConsFail.count++;
            System.out.println("Ich bin auch da");
            if (ProdConsFail.count == 1) {
                try {
                    ProdConsFail.wakeUp("cons");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}

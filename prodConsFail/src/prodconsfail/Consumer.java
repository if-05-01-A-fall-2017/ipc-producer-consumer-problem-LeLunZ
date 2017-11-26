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
public class Consumer extends Thread{

    @Override
    public void run() {
        while(true){
            if (ProdConsFail.count == 0) {
                try {
                    synchronized(this){
                        System.out.println("Ich bin auch schlafen");
                        this.wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            ProdConsFail.test--;
            System.out.println("Ich bin da");
            ProdConsFail.count--;
            if (ProdConsFail.count == ProdConsFail.N-1) {
                try {
                    ProdConsFail.wakeUp("prod");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}

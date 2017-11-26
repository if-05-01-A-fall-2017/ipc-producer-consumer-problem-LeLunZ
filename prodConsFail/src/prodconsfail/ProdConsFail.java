/*
 * creater: Noisternig Luis
 * Date:
 * Description:
 */
package prodconsfail;

/**
 *
 * @author Luis Noisternig
 */
public class ProdConsFail {
    public static int count = 0;
    public static int N = 20;
    public static int test = 0;
    static Consumer m = new Consumer();
    static Producer v = new Producer();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        m.start();
        v.start();
    }

    public static void wakeUp(String in) throws InterruptedException {
        if ("prod".equals(in)) {
            synchronized(v){
                v.notify();
            }
        }
        else{
            synchronized(m){
                m.notify();
            }
        }
    }
}

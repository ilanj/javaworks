//thenApply() method to process and transform the result of a CompletableFuture when it arrives
package advanced.threading.completablefuture.nonblocking;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ThenApply {
   static CompletableFuture<String> getName = CompletableFuture.supplyAsync(()->{
       String exMethodCall = getText();
       try {
           TimeUnit.SECONDS.sleep(3);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return exMethodCall;
   });

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> greet = getName.thenApply(returnValue->{
            return "Hello" + returnValue;
        });
//        System.out.println(greet);
        System.out.println(greet.get());
    }
    static String getText(){
        return UUID.randomUUID().toString();
    }
}

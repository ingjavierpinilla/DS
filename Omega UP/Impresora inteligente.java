// https://omegaup.com/arena/ED-P2/#problems/Impresora-inteligente
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        PriorityQueue<Integer> queue = new PriorityQueue();
        LinkedList<Integer> list = new LinkedList<>();
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = -Integer.parseInt(line[i]);;
            queue.add(num);
            list.addLast(num);
        }
        int minutos = 0;
        while ( true ) {
            int num = list.pollFirst();
            minutos ++;  //Por desencolar
            m--;
            //System.out.println(num+" "+m);
            if(num == queue.element()){
                //Imprime
                minutos++;
                queue.poll();
                if( m == 0 ){
                    break;
                }
            } else {
                list.addLast(num);
                minutos++;
                //System.out.println("--- "+num+" "+m);
                if(m == 0){
                    m = list.size();
                }
            }
        }
        System.out.println(minutos);
      
    }
    
}
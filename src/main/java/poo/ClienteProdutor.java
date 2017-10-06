package poo;

/**
 * Essa Classe é usada para simular a chegada de N clientes em uma barbearia.
 * 
 * A Thread dorme um tempo aleatório para simular a chegada aleatória de clientes
 * na barbearia
 *
 * @author mello
 */
public class ClienteProdutor extends Thread{

    private final Barbearia ca;
    private int totalDeClientes; 

    /**
     * 
     * @param c - referência da classe que simula a barbearia
     * @param totClientes - número de clientes que chegarão na barbearia
     */
    public ClienteProdutor(Barbearia c, int totClientes){
        this.ca = c;
        this.totalDeClientes = totClientes;
    }

    /**
     * A thread adicionará totalDeClientes na barbearia. Para cada cliente a 
     * thread irá dormir um tempo aleatório de 0 a 10000 milissegundos.
     */
    @Override
    public void run(){
        int idCliente = 0;
        while(totalDeClientes > 0 ){
            try {
                
                // simulando a chegada aleatória de clientes na barbearia
                // Thread ficará dormindo por até 10.000 ms
                Thread.sleep((int) Math.random() * 10000);
                
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
            // Adicionando cliente na barbearia, sendo cada um com um id único
            ca.chegaNaBarbearia(idCliente);
            
            totalDeClientes--;
            idCliente++;
        }
    }
}

package poo;


/**
 * Exemplo retirado do livro Java Como Programar
 */
public class Principal {

   
    public static void main(String[] args) {
        
        int numeroDeClientes = 10;

        Barbearia ca = new Barbearia();

        ClienteProdutor cli = new ClienteProdutor(ca, numeroDeClientes);
        BarbeiroConsumidor bar = new BarbeiroConsumidor(ca, numeroDeClientes);

        cli.start();
        bar.start();

    }

}

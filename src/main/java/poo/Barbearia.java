package poo;

/**
 * Classe para simular uma barbearia e que é compartilhada por clientes e
 * barbeiro.
 *
 * @author mello
 */
public class Barbearia {

    private boolean cadeiraOcupada;
    private int cliente;

    /**
     * Por padrão a cadeira do barbeiro não está ocupada.
     */
    public Barbearia() {
        this.cadeiraOcupada = false;
    }

    /**
     * Esse método é invocado somente pelo barbeiro quando ele notar que tem um
     * cliente sentado na cadeira para cortar cabelo.
     */
    public synchronized void cortaCabelo() {

        // se ninguém sentou na cadeira, espere até alguém sentar
        while (cadeiraOcupada == false) {
            try {
                // se não tiver cliente, barbeiro tira um cochilo...
                System.err.println("Barbeiro tirando cochilo...");
                wait();
                
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
        }
        
        // Saiu do while porque alguém sentou na cadeira. Sendo assim, corte o cabelo
        // do cliente e ao terminar a cadeira estará livre novamente.
        try {
            
            // Simulando um tempo aleatório para o corte do cabelo do cliente
            System.err.println("Barbeiro está cortando o cabelo do cliente " + cliente);
            Thread.sleep((int) Math.random() * 10000);
            
            
        } catch (InterruptedException e) {
            System.err.println(e.toString());
        }
        
        System.err.println("Pronto, mais um cliente satisfeito...");
        cadeiraOcupada = false;
        
        // Avisar a thread produtora (Cliente) que a cadeira do barbeiro está vazia
        notify();
    }

    // metodo invocado pelo Cliente que chega no salao
    public synchronized void chegaNaBarbearia(int id) {
        //enquanto a cadeira estiver cadeiraOcupada, aguarde sua vez
        while (cadeiraOcupada == true) {
            try {
                // espere até o cliente atual sair da cadeira do barbeiro
                System.err.println("Cliente " + id + " chegou na barbearia e espera sua vez");
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
        }
        // cadeira livre! Fazer com que o cliente sente na cadeira para ser
        // atendido
        System.err.println("Cliente " + id + " sentou na cadeira do barbeiro...");
        cliente = id;
        cadeiraOcupada = true;
        // avisar a thread consumidor (Barbeiro) que tem cliente na cadeira
        notify();
    }
}

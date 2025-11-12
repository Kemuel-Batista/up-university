public class consumidor {
    public static void main(String[] args) {
        //Instanciar com a assinatura e construir com a classe concreta
        absHandler comprador = new compradorHandler();
        absHandler gerente = new gerenteHandler();
        absHandler diretor = new diretorHandler();
        //Montar a cadeia
        comprador.setNextHandle(gerente);
        gerente.setNextHandle(diretor);

        comprador.handleRequest(500);

    }
}

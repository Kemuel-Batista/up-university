public class gerenteHandler extends absHandler {
    @Override
    public void handleRequest(double valor) {
        if(this.canHandle(valor)){
            System.out.println("Compra autorizada para o gerente'");
        }
        else{
            nextHandler.handleRequest(valor);
        }
    }

    private boolean canHandle(double valor){
        return (valor<=50000);
    }
}

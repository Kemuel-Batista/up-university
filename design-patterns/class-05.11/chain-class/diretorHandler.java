public class diretorHandler extends  absHandler {
    @Override
    public void handleRequest(double valor) {
        if(this.canHandle(valor)){
            System.out.println("Compra autorizada para o diretor'");
        }
    
    }

    private boolean canHandle(double valor){
        return true;
    }
}

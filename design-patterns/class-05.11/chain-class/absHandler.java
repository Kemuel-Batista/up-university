
public abstract class absHandler{
    protected  absHandler nextHandler;
    
    public  void setNextHandle(absHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(double valor);
    
    private boolean canHandle(double valor){
        return false;
    }

}
package banco;

public class BDSingleton {
    private static BDSingleton instance;
    private BancoDeDados banco; //so existe nos objetos. Nesse caso teremos apenas um objeto BDSingleton.

    private BDSingleton() {
        banco = new BancoDeDados();
    }
    public static BDSingleton getInstance() {
        if(instance == null) {
            instance = new BDSingleton();
        }
        return instance;
    }

    public BancoDeDados getBancoDeDados() {
        return banco;
    }
}

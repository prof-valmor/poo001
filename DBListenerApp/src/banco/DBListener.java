package banco;

import java.util.ArrayList;

public interface DBListener {
    void onChange(ArrayList<Pessoa> lista);
}



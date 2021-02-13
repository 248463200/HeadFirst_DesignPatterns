package headfisrt.A8_DelegateModel.simple;

import java.util.HashMap;
import java.util.Map;

public class Leader {
    private Map<String,IEmploee> map = new HashMap<>();

    public Leader(){
        map.put("java",new AEmploee());
        map.put("python",new AEmploee());
    }

    public void doing(String command){
        map.get(command).doing(command);
    }
}

package repositories;

import models.Gate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private Map<Long,Gate>  gateMap = new HashMap<>();
    private Long lastGateId;
    public Optional<Gate> findGateID(Long gateId){
        if(gateMap.containsKey(gateId)){
            return Optional.of(gateMap.get(gateId));
        }return Optional.empty();
    }

    public Gate save(Gate gate){
        if(gate.getId() == null){
            //insert
            lastGateId+=1;
            gate.setId(lastGateId);
            gateMap.put(lastGateId,gate);

        }else{
            //update
            gateMap.put(gate.getId(),gate);
        }
        return gate;
    }

}

package excursionweb.modelo.dao;

import excursionweb.modelo.javabean.Excursion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ExcursionDaoImpl implements ExcursionDao {

    private List<Excursion> excursiones = new ArrayList<>();
    private int currentId = 1;
    
    @Override
    public Excursion findById(int idExcursion) {
        return excursiones.stream()
                .filter(e -> e.getIdExcursion() == idExcursion)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Excursion> findAll() {
        return new ArrayList<>(excursiones);
    }

    @Override
    public int insertOne(Excursion excursion) {
        excursion.setIdExcursion(currentId++);  
        return excursiones.add(excursion) ? 1 : 0;  
    }

    @Override
    public int updateOne(Excursion excursion) {
        int index = excursiones.indexOf(findById(excursion.getIdExcursion()));
        if (index >= 0) {
            excursiones.set(index, excursion);
            return 1;
        }
        return 0;
    }

    @Override
    public List<Excursion> findByActivos() {
        return excursiones.stream()
                .filter(e -> "CREADO".equals(e.getEstado()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Excursion> findByCancelados() {
        return excursiones.stream()
                .filter(e -> "CANCELADO".equals(e.getEstado()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Excursion> findByDestacados() {
        return excursiones.stream()
                .filter(e -> "S".equals(e.getDestacado()))
                .collect(Collectors.toList());
    }
}

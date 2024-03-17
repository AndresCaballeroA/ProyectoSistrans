package uniandes.edu.co.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.Modelos.Operacion;
import uniandes.edu.co.proyecto.Repositorio.OperacionRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/operaciones")
public class OperacionController {

    @Autowired
    private OperacionRepository operacionRepository;

    @GetMapping
    public List<Operacion> getAllOperaciones() {
        return operacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operacion> getOperacionById(@PathVariable Integer id) {
        Optional<Operacion> operacion = operacionRepository.findById(id);
        return operacion.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Operacion createOperacion(@RequestBody Operacion operacion) {
        return operacionRepository.save(operacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Operacion> updateOperacion(@PathVariable Integer id, @RequestBody Operacion operacion) {
        if (!operacionRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        operacion.setId(id);
        Operacion result = operacionRepository.save(operacion);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperacion(@PathVariable Integer id) {
        operacionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

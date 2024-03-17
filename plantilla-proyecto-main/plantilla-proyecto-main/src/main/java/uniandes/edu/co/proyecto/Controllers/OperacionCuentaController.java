package uniandes.edu.co.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.Modelos.OperacionCuenta;
import uniandes.edu.co.proyecto.Repositorio.OperacionCuentaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/operacionesCuenta")
public class OperacionCuentaController {

    @Autowired
    private OperacionCuentaRepository operacionCuentaRepository;

    @GetMapping
    public List<OperacionCuenta> getAllOperacionesCuenta() {
        return operacionCuentaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperacionCuenta> getOperacionCuentaById(@PathVariable(value = "id") Integer id) {
        Optional<OperacionCuenta> operacionCuenta = operacionCuentaRepository.findById(id);
        return operacionCuenta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                              .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public OperacionCuenta createOperacionCuenta(@RequestBody OperacionCuenta operacionCuenta) {
        return operacionCuentaRepository.save(operacionCuenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperacionCuenta> updateOperacionCuenta(@PathVariable(value = "id") Integer id, @RequestBody OperacionCuenta operacionCuentaDetails) {
        Optional<OperacionCuenta> operacionCuentaOptional = operacionCuentaRepository.findById(id);
        if (!operacionCuentaOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        OperacionCuenta operacionCuenta = operacionCuentaOptional.get();
        operacionCuenta.setNumeroOrigen(operacionCuentaDetails.getNumeroOrigen());
        operacionCuenta.setNumeroDestino(operacionCuentaDetails.getNumeroDestino());
        operacionCuenta.setMonto(operacionCuentaDetails.getMonto());
        final OperacionCuenta updatedOperacionCuenta = operacionCuentaRepository.save(operacionCuenta);
        return ResponseEntity.ok(updatedOperacionCuenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperacionCuenta(@PathVariable(value = "id") Integer id) {
        Optional<OperacionCuenta> operacionCuenta = operacionCuentaRepository.findById(id);
        if (operacionCuenta.isPresent()) {
            operacionCuentaRepository.delete(operacionCuenta.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

package uniandes.edu.co.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.Modelos.OperacionPrestamo;
import uniandes.edu.co.proyecto.Repositorio.OperacionPrestamoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/operacionesPrestamo")
public class OperacionPrestamoController {

    @Autowired
    private OperacionPrestamoRepository operacionPrestamoRepository;

    @GetMapping
    public List<OperacionPrestamo> getAllOperacionesPrestamo() {
        return operacionPrestamoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperacionPrestamo> getOperacionPrestamoById(@PathVariable(value = "id") Integer id) {
        Optional<OperacionPrestamo> operacionPrestamo = operacionPrestamoRepository.findById(id);
        return operacionPrestamo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public OperacionPrestamo createOperacionPrestamo(@RequestBody OperacionPrestamo operacionPrestamo) {
        return operacionPrestamoRepository.save(operacionPrestamo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperacionPrestamo> updateOperacionPrestamo(@PathVariable(value = "id") Integer id, @RequestBody OperacionPrestamo operacionPrestamoDetails) {
        Optional<OperacionPrestamo> operacionPrestamoOptional = operacionPrestamoRepository.findById(id);
        if (!operacionPrestamoOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        OperacionPrestamo operacionPrestamo = operacionPrestamoOptional.get();
        operacionPrestamo.setNumPrestamo(operacionPrestamoDetails.getNumPrestamo());
        operacionPrestamo.setMontoPago(operacionPrestamoDetails.getMontoPago());
        final OperacionPrestamo updatedOperacionPrestamo = operacionPrestamoRepository.save(operacionPrestamo);
        return ResponseEntity.ok(updatedOperacionPrestamo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperacionPrestamo(@PathVariable(value = "id") Integer id) {
        Optional<OperacionPrestamo> operacionPrestamo = operacionPrestamoRepository.findById(id);
        if (operacionPrestamo.isPresent()) {
            operacionPrestamoRepository.delete(operacionPrestamo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

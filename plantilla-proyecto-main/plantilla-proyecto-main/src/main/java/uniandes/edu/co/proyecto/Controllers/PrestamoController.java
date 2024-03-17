package uniandes.edu.co.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.Modelos.Prestamo;
import uniandes.edu.co.proyecto.Repositorio.PrestamoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @GetMapping
    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamoById(@PathVariable(value = "id") Integer id) {
        Optional<Prestamo> prestamo = prestamoRepository.findById(id);
        return prestamo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Prestamo createPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> updatePrestamo(@PathVariable(value = "id") Integer id, @RequestBody Prestamo prestamoDetails) {
        Optional<Prestamo> prestamoOptional = prestamoRepository.findById(id);
        if (!prestamoOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Prestamo prestamo = prestamoOptional.get();
        prestamo.setEstado(prestamoDetails.getEstado());
        prestamo.setTipo(prestamoDetails.getTipo());
        prestamo.setMonto(prestamoDetails.getMonto());
        prestamo.setInteres(prestamoDetails.getInteres());
        prestamo.setNumCuotas(prestamoDetails.getNumCuotas());
        prestamo.setNumMes(prestamoDetails.getNumMes());
        prestamo.setValorCuota(prestamoDetails.getValorCuota());
        final Prestamo updatedPrestamo = prestamoRepository.save(prestamo);
        return ResponseEntity.ok(updatedPrestamo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable(value = "id") Integer id) {
        Optional<Prestamo> prestamo = prestamoRepository.findById(id);
        if (prestamo.isPresent()) {
            prestamoRepository.delete(prestamo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

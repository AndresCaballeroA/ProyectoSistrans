package uniandes.edu.co.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.Modelos.Oficina;
import uniandes.edu.co.proyecto.Repositorio.OficinaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/oficinas")
public class OficinaController {

    @Autowired
    private OficinaRepository oficinaRepository;

    @GetMapping
    public List<Oficina> getAllOficinas() {
        return oficinaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oficina> getOficinaById(@PathVariable Integer id) {
        Optional<Oficina> oficina = oficinaRepository.findById(id);
        return oficina.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Oficina createOficina(@RequestBody Oficina oficina) {
        return oficinaRepository.save(oficina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oficina> updateOficina(@PathVariable Integer id, @RequestBody Oficina oficina) {
        if (!oficinaRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        oficina.setId(id);
        Oficina result = oficinaRepository.save(oficina);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOficina(@PathVariable Integer id) {
        oficinaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

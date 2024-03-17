package uniandes.edu.co.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.Modelos.PuntoDeAtencion;
import uniandes.edu.co.proyecto.Repositorio.PuntoDeAtencionRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/puntosDeAtencion")
public class PuntoDeAtencionController {

    @Autowired
    private PuntoDeAtencionRepository puntoDeAtencionRepository;

    @GetMapping
    public List<PuntoDeAtencion> getAllPuntosDeAtencion() {
        return puntoDeAtencionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PuntoDeAtencion> getPuntoDeAtencionById(@PathVariable Integer id) {
        Optional<PuntoDeAtencion> puntoDeAtencion = puntoDeAtencionRepository.findById(id);
        return puntoDeAtencion.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public PuntoDeAtencion createPuntoDeAtencion(@RequestBody PuntoDeAtencion puntoDeAtencion) {
        return puntoDeAtencionRepository.save(puntoDeAtencion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PuntoDeAtencion> updatePuntoDeAtencion(@PathVariable Integer id, @RequestBody PuntoDeAtencion puntoDeAtencion) {
        if (!puntoDeAtencionRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        puntoDeAtencion.setId(id);
        PuntoDeAtencion result = puntoDeAtencionRepository.save(puntoDeAtencion);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePuntoDeAtencion(@PathVariable Integer id) {
        puntoDeAtencionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

package uniandes.edu.co.proyecto.Controllers;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.Modelos.Cuenta;
import uniandes.edu.co.proyecto.Repositorio.CuentaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/cuentas")
    public String cuentas(Model model, String tipo, String minSaldo, String MaxSaldo, Date fechaCreacion, Date ultimoMove){
        if ((tipo == null || tipo.equals("")) || (minSaldo == null || minSaldo.equals("")) || (MaxSaldo == null || MaxSaldo.equals("")) || (fechaCreacion == null || fechaCreacion.equals("")) || (ultimoMove == null || ultimoMove.equals(""))){
            //model.addAttribute("cuentas", CuentaRepository.darCuentas());
        }
        else{
           // model.addAttribute("cuentas", CuentaRepository.darCuentasPorCriterio(tipo, Integer.parseInt(minSaldo), Integer.parseInt(MaxSaldo), fechaCreacion, ultimoMove));
        }

        return "Cuentas";
    }

    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getCuentaById(@PathVariable Integer id) {
        Optional<Cuenta> cuenta = cuentaRepository.findById(id);
        return cuenta.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Cuenta createCuenta(@RequestBody Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable Integer id, @RequestBody Cuenta cuenta) {
        if (!cuentaRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cuenta.setId(id);
        Cuenta result = cuentaRepository.save(cuenta);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Integer id) {
        cuentaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

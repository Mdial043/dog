package seg3x02.calculator_webflux_api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("calculator")
class CalculatorController {

    @GetMapping("/add/{nombre1}/{nombre2}")
    fun add(@PathVariable nombre1: Double, @PathVariable nombre2: Double) = Mono.just(nombre1 + nombre2)

    @GetMapping("/subtract/{nombre1}/{nombre2}")
    fun subtract(@PathVariable nombre1: Double, @PathVariable nombre2: Double) = Mono.just(nombre1 - nombre2)

    @GetMapping("/multiply/{nombre1}/{nombre2}")
    fun multiply(@PathVariable nombre1: Double, @PathVariable nombre2: Double) = Mono.just(nombre1 * nombre2)

    @GetMapping("/divide/{nombre1}/{nombre2}")
    fun divide(@PathVariable nombre1: Double, @PathVariable nombre2: Double): Mono<Double> {
        if (nombre2 == 0.0) {
            throw IllegalArgumentException("Division par zéro n'est pas autorisée.")
        }
        return Mono.just(nombre1 / nombre2)
    }
}

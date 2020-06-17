package poker.model

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import poker.model.simulation.calculateOutcomeProbs

@SpringBootApplication
open class PokerModelApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<PokerModelApplication>(*args)
}

@RestController
class Controller {

    @GetMapping("/outcomes")
    @ResponseBody
    fun getHandOutcomes(): String {
        val result = calculateOutcomeProbs(5)
        return ResponseEntity.status(HttpStatus.OK).body(result).toString()
    }
}

package ua.kpi.its.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.TrainRequest
import ua.kpi.its.lab.rest.dto.TrainResponse
import ua.kpi.its.lab.rest.svc.impl.TrainServiceImpl


@RestController
@RequestMapping("/api/trains")
class TrainController {

    private final lateinit var trainService: TrainServiceImpl;

    @Autowired
    fun TrainController(trainService: TrainServiceImpl) {
        this.trainService = trainService;
    }

    @GetMapping("/{id}")
    fun getTrainById(@PathVariable Long id): ResponseEntity<TrainResponse>? {
        val trainResponse: TrainResponse = trainService.getTrainById(id);
        if (trainResponse == null) {
            println("Train with id " + id + " not found")
        }
        return ResponseEntity.ok(trainResponse);
    }

    @PostMapping("/")
    fun createTrain(@Valid @RequestBody trainRequest: TrainRequest?): ResponseEntity<TrainResponse>? {
        val trainResponse: TrainResponse? = trainRequest?.let { trainService.createTrain(it) }
        return ResponseEntity.status(HttpStatus.CREATED).body<TrainResponse>(trainResponse)
    }

    @PutMapping("/{id}")
    fun updateTrain(
        @PathVariable id: Long,
        @Valid @RequestBody trainRequest: TrainRequest?
    ): ResponseEntity<TrainResponse>? {
        val trainResponse: TrainResponse? = trainRequest?.let { trainService.updateTrain(id, it) }
        return ResponseEntity.ok<TrainResponse>(trainResponse)
    }

    @DeleteMapping("/{id}")
    fun deleteTrain(@PathVariable id: Long): ResponseEntity<Void?>? {
        val isDeleted: Boolean = trainService.deleteTrain(id)
        if (!isDeleted) {
            println("Train with id $id not found")
        }
        return ResponseEntity.noContent().build()
    }
}
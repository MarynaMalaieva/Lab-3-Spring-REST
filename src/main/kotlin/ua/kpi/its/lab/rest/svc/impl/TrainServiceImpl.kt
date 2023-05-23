package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.TrainRequest
import ua.kpi.its.lab.rest.dto.TrainResponse
import ua.kpi.its.lab.rest.entity.Train
import ua.kpi.its.lab.rest.repository.TrainRepository
import ua.kpi.its.lab.rest.svc.TrainService

@Service
class TrainServiceImpl(private val trainRepository: TrainRepository) : TrainService {
    override fun createTrain(trainRequest: TrainRequest): TrainResponse {
        val train = Train(model = trainRequest.model, manufacturer = trainRequest.manufacturer)
        val savedHospital = trainRepository.save(train)
        return TrainResponse.fromEntity(savedHospital)
    }

    override fun getTrainById(id: Long): TrainResponse {
        val hospital = trainRepository.findById(id).orElseThrow()
        return TrainResponse.fromEntity(hospital)
    }

    override fun updateTrain(id: Long, trainRequest: TrainRequest): TrainResponse {
        val train = trainRepository.findById(id).orElseThrow()
        train.model = trainRequest.model
        train.manufacturer = trainRequest.manufacturer
        val updatedTrain = trainRepository.save(train)
        return TrainResponse.fromEntity(updatedTrain)
    }

    override fun deleteTrain(id: Long): Boolean {
        trainRepository.deleteById(id)
        return true
    }
}
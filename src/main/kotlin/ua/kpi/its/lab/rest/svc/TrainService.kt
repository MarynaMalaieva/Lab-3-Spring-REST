package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.TrainRequest
import ua.kpi.its.lab.rest.dto.TrainResponse

interface TrainService {
    fun createTrain(trainRequest: TrainRequest): TrainResponse
    fun getTrainById(id: Long): TrainResponse
    fun updateTrain(id: Long, trainRequest: TrainRequest): TrainResponse
    fun deleteTrain(id: Long): Boolean
}
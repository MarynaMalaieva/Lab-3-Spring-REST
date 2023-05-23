package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.WayRequest
import ua.kpi.its.lab.rest.dto.WayResponse
import ua.kpi.its.lab.rest.entity.Way
import ua.kpi.its.lab.rest.repository.WayRepository
import ua.kpi.its.lab.rest.svc.WayService
@Service
class WayServiceImpl(private val wayRepository: WayRepository) : WayService {
    override fun createWay(wayRequest: WayRequest): WayResponse {
        val way = Way(startPoint = wayRequest.startPoint, destination = wayRequest.destination)
        val savedWay = wayRepository.save(way)
        return WayResponse.fromEntity(savedWay)
    }

    override fun getWayById(id: Long): WayResponse {
        val drugs = wayRepository.findById(id).orElseThrow()
        return WayResponse.fromEntity(drugs)
    }

    override fun updateWay(id: Long, drugsRequest: WayRequest): WayResponse {
        val way = wayRepository.findById(id).orElseThrow()
        way.startPoint = drugsRequest.startPoint
        way.destination = drugsRequest.destination
        val updatedWay = wayRepository.save(way)
        return WayResponse.fromEntity(updatedWay)
    }

    override fun deleteWay(id: Long): Boolean {
        wayRepository.deleteById(id)
        return true
    }
}
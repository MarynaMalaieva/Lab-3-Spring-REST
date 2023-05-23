package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.WayRequest
import ua.kpi.its.lab.rest.dto.WayResponse
interface WayService {
    fun createWay(drugsRequest: WayRequest): WayResponse
    fun getWayById(id: Long): WayResponse
    fun updateWay(id: Long, drugsRequest: WayRequest): WayResponse
    fun deleteWay(id: Long): Boolean
}
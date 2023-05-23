package ua.kpi.its.lab.rest.dto

class WayRequest {
    var startPoint: String? = null
        private set
    var destination: String? = null
        private set
    var type: String? = null
        private set

    constructor()
    constructor(startPoint: String?, destination: String?, type: String?) {
        this.startPoint = startPoint
        this.destination = destination
        this.type = type
    }
}


class WayResponse {
    var id: Long? = null
        private set
    var startPoint: String? = null
        private set
    var destination: String? = null
        private set
    var type: String? = null
        private set

    constructor()
    constructor(id: Long?, startPoint: String?, destination: String?, type: String?) {
        this.id = id
        this.startPoint = startPoint
        this.destination = destination
        this.type = type
    }
}


class TrainRequest {
    var model: String? = null
        private set
    var manufacturer: String? = null
        private set
    var type: String? = null
        private set

    constructor()
    constructor(model: String?, manufacturer: String?, type: String?) {
        this.model = model
        this.manufacturer = manufacturer
        this.type = type
    }
}


class TrainResponse {
    var id: Long? = null
        private set
    var model: String? = null
        private set
    var manufacturer: String? = null
        private set
    var type: String? = null
        private set

    constructor()
    constructor(id: Long?, model: String?, manufacturer: String?, type: String?) {
        this.id = id
        this.model = model
        this.manufacturer = manufacturer
        this.type = type
    }
}


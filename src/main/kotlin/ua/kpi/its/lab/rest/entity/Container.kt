import ua.kpi.its.lab.rest.entity.Train

interface Container<T> {
    fun add(element: T)

    fun remove(index: Int)

    fun update(index: Int, element: T)

    fun get(index: Int): T
    fun getAll(): List<T>
}

class TrainContainer : Container<Train> {
    private val trains: MutableList<Train> = mutableListOf()

    override fun add(element: Train) {
        trains.add(element)
    }

    override fun remove(index: Int) {
        trains.removeAt(index)
    }

    override fun update(index: Int, element: Train) {
        trains[index] = element
    }

    override fun get(index: Int): Train {
        return trains[index]
    }

    override fun getAll(): List<Train> {
        return trains
    }
}
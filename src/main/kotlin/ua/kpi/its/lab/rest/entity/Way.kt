package ua.kpi.its.lab.rest.entity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name="way")
data class Way(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    var startPoint: String,
    var destination: String,
    val type: String,
    val dateOfDeparture: LocalDate,
    val roadLength: Int,
    val ticketPrice: Double,
    val circular: Boolean,
    @ManyToOne
    @JoinColumn(name = "train_id")
    val train: Train
) : Comparable<Way> {
    override fun compareTo(way: Way): Int {
        val compare = startPoint.compareTo(way.startPoint)
        return if (compare != 0) compare else startPoint.compareTo(way.startPoint) + destination.compareTo(way.destination)
    }
}
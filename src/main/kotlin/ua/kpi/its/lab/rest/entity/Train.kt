package ua.kpi.its.lab.rest.entity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.time.LocalDate
@Entity
@Table(name = "train")
data class Train(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val model: String,
    val manufacturer: String,
    val type: String,
    val dateOfCommencementOfOperation: LocalDate,
    val numOfSeats: Int,
    val weight: Int,
    val withConditioning: Boolean,
    @OneToOne(mappedBy = "train", cascade = [CascadeType.ALL], orphanRemoval = true)
    val way: Way,
) : Comparable<Train> {
    override fun compareTo(train: Train): Int {
        val compare = model.compareTo(train.model)
        return if (compare != 0) compare else way.compareTo(train.way)
    }
}
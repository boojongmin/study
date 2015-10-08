package se.sfjd

import javax.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.{Propagation, Transactional}
import scala.collection.JavaConversions._


@Repository
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
class CustomerDaoImpl extends CustomerDao{

  @Autowired
  var entityManager: EntityManager = _

  override def save(customer: Customer): Unit = customer.id match {
    case 0 => entityManager.persist(customer)
    case _ => entityManager.merge(customer)
  }

  override def find(id: Int): Option[Customer] = {
    Option(entityManager.find(classOf[Customer], id))
  }

  override def getAll: List[Customer] = {
    entityManager.createQuery("FROM Customer", classOf[Customer]).getResultList.toList
  }
}

package se.sfjd

import javax.persistence._

import scala.beans.BeanProperty

@Entity
@Table(name="customer")
class Customer(n: String) {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "CUSTOMER_ID")
  @BeanProperty
  var id: Int = _

  @BeanProperty
  @Column(name = "NAME")
  var name: String = _

  def this() = this (null)

  override def toString = id + " = " + name
}

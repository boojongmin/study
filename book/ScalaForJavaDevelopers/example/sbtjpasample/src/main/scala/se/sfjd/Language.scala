package se.sfjd

import javax.persistence._

import scala.beans.BeanProperty

@Entity
@Table(name="language")
class Language(l: String) {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  @BeanProperty
  var id: Int = _

  @Column(name = "NAME")
  @BeanProperty
  var name: String = l

  def this() = this (null)

  override def toString = id + " = " + name

}

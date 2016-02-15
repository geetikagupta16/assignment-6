package com.studentDatabase
import org.scalatest.FunSuite

/**
  * Created by knoldus on 12/2/16.
  */

class StudentSubjectTest extends FunSuite {

  val s= new StudentSubject

  test("Inserting values in database") {

    val con=s.getConnection()
    val res=s.insert(con,2,3)
    con.close()
    assert(res===1)

  }

  test("Deleting values from database"){

    val con=s.getConnection()
    val res=s.delete(con,2,3)
    con.close()
    assert(res===1)

  }

}

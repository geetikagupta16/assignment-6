package com.studentDatabase

import org.scalatest.FunSuite

/**
  * Created by knoldus on 12/2/16.
  */

class SubjectInfoTest  extends FunSuite{

  val s=new SubjectInfo

  test("Insert in subject table "){

    val con=s.getConnection()
    val res =s.insert(con,6,"Javascript")
    con.close()
    assert(res===1)

  }

  test("Update in subject name "){

    val con=s.getConnection()
    val res=s.updateSubjectName(con,6,"CSS")
    con.close()
    assert(res===1)
  }

  test("Deletion in Subjects "){

    val con=s.getConnection()
    val res=s.delete(con,6)
    con.close()
    assert(res===1)
  }

  test("Display subject record "){

    val con=s.getConnection()
    val res=s.display(con,2)
    con.close()
    assert((res._1===2)&&(res._2=="java"))
  }

}

package com.studentDatabase

import org.scalatest.FunSuite
/**
  * Created by knoldus on 12/2/16.
  */


class StudentInfoTest extends FunSuite{

  val s=new StudentInfo()


  test("Inserting values in student table") {

    val con=s.getConnection()
    val res=s.insert(con,4,"eric","eric@gmail.com",67234678)
    con.close()
    assert(res===1)
  }

  test("Update name in student table"){

    val con=s.getConnection()
    val res=s.updateName(con,4,"justin")
    con.close()
    assert(res===1)

  }

  test("Update Email in student table"){

    val con=s.getConnection()
    val res=s.updateEmail(con,4,"xyz@gmail.com")
    con.close()
    assert(res===1)

  }

  test("Update Phone number in student table"){

    val con=s.getConnection()
    val res=s.updatePhone(con,4,67723415)
    con.close()
    assert(res===1)

  }

  test("Deleting values from student table"){

    val con=s.getConnection()
    val res=s.delete(con,4)
    con.close()
    assert(res===1)

  }

  test("Display student record"){

    val con=s.getConnection()
    val res:(Int,String,String,Int)=s.display(con,2)
    con.close()
    assert((res._1===2)&&(res._2=="jacob")&&(res._3=="jacob@gmail.com")&&(res._4==765235678))

  }

}

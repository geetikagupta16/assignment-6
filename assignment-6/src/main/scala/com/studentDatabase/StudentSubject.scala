package com.studentDatabase

import java.sql.{Connection, DriverManager}
import org.slf4j.LoggerFactory

/**
  * Created by knoldus on 12/2/16.
  */

class StudentSubject {

  val logger=LoggerFactory.getLogger(this.getClass)

  def getConnection():Connection={

    val url = "jdbc:mysql://localhost/student_information"
    val username = "root"
    val password = "root"
    Class.forName("com.mysql.jdbc.Driver")
    val connection=DriverManager.getConnection(url,username,password)
    connection

  }

  def insert(con:Connection,sid:Int,subId:Int):Int={

    val statement=con.createStatement()
    val res=statement.executeUpdate("Insert into student_subject values("+sid+","+subId+");")
    logger.info("Inserting records in student_subject")
    res

  }

  def delete(con:Connection,sid:Int,subId:Int):Int={

    val statement=con.createStatement()
    val res=statement.executeUpdate("Delete from student_subject where student_id="+sid+" and subject_id="+subId+";")
    logger.info("Deleting records in student_subject")
    res

  }

}

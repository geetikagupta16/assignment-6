package com.studentDatabase
import java.sql.{Connection, DriverManager}

import org.slf4j.LoggerFactory


/**
  * Created by knoldus on 12/2/16.
  */


class SubjectInfo {

  val logger=LoggerFactory.getLogger(this.getClass)

  def getConnection():Connection={

    val url = "jdbc:mysql://localhost/student_information"
    val username = "root"
    val password = "root"
    Class.forName("com.mysql.jdbc.Driver")
    val connection=DriverManager.getConnection(url,username,password)
    logger.info("Establishing Connection")
    connection

  }

  def insert(con:Connection,sid:Int,sname:String):Int={
    val statement=con.createStatement()
    val res=statement.executeUpdate("Insert into subjects values(" + sid + ",'" + sname + "');")
    logger.info("Inserting records")
    res

  }

  def delete(con:Connection,sid:Int):Int={

    val statement=con.createStatement()
    val res=statement.executeUpdate("Delete from subjects where sub_id=" + sid + ";")
    logger.info("Deleting Records")
    res

  }

  def updateSubjectName(con: Connection, id: Int,name:String): Int={

    val statement = con.createStatement()
    val res=statement.executeUpdate("Update subjects set sub_name='" + name + "' where sub_id=" + id + ";")
    logger.info("Updating subject name")
    res
  }

  def display(con:Connection,id:Int):(Int,String)={

    val statement=con.createStatement()
    val res=statement.executeQuery("Select * from subjects where sub_id=" + id + ";")

    if (res.next())
      (res.getInt(1),res.getString(2))
    else
      (0,"")

  }

}

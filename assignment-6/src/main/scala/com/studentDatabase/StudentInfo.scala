package com.studentDatabase

import java.sql.{Connection, DriverManager}

import org.slf4j.LoggerFactory

/**
  * Created by knoldus on 12/2/16.
  */

class StudentInfo {

  val logger=LoggerFactory.getLogger(this.getClass)


  def getConnection(): Connection = {

    val url = "jdbc:mysql://localhost/student_information"
    val username = "root"
    val password = "root"
    Class.forName("com.mysql.jdbc.Driver")
    val connection = DriverManager.getConnection(url, username, password)
    connection

  }

  def insert(con: Connection, sId: Int, sname: String, email: String, pno: Int): Int = {

    val statement = con.createStatement()
    val res = statement.executeUpdate("Insert into student values(" + sId + ",'" + sname + "','" + email + "'," + pno + ");")
    logger.info("Inserting student record")

    res
  }

  def delete(con: Connection, id: Int): Int = {

    val statement = con.createStatement()
    val res = statement.executeUpdate("Delete from student where st_id=" + id + ";")
    logger.info("Deleting student record")
    res
  }

  def updateName(con: Connection, id: Int,name:String): Int={

    val statement = con.createStatement()
    val res=statement.executeUpdate("Update student set name='" + name + "' where st_id=" + id + ";")
    logger.info("Updating student name")

    res
  }

  def updateEmail(con: Connection, id: Int,mail:String): Int={

    val statement = con.createStatement()
    val res=statement.executeUpdate("Update student set email='" + mail + "' where st_id=" + id + ";")
    logger.info("Updating student Email")

    res
  }
  def updatePhone(con: Connection, id: Int,phone:Int): Int={

    val statement = con.createStatement()
    val res=statement.executeUpdate("Update student set ph_no='" + phone + "' where st_id=" + id + ";")
    logger.info("Updating student Phone number")

    res
  }


  def display(con: Connection, id:Int):(Int,String,String,Int)= {

    val statement = con.createStatement()
    val res = statement.executeQuery("Select * from student where st_id=" + id + ";")
    if(res.next())
      (res.getInt(1),res.getString(2),res.getString(3),res.getInt(4))
    else
      (0,"","",0)

  }


}
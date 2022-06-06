package models

case class ErrorDetail(statusCode: Int)
class EmployeeDetails {
  def fetchEmployeeDetailsById(id:Int): Any = {
    id match {
      case 101 => views.html.EmployeeDetails("Parneet","Delhi")
      case 102 => views.html.EmployeeDetails("Rahul","Dehradun")
      case _ => ErrorDetail(400)
    }
  }
}

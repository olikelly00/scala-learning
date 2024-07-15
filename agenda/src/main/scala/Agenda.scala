class Agenda (val meetings: List[Meeting]) {

  def printDaySchedule(day: String): Unit = {
    val meetingsForTheDay = meetings.filter(_.day == day)
    if (meetingsForTheDay.isEmpty) {
      println(s"$day: ")
      println(s"There are no meetings on $day\n")
    } else {
      println(s"$day morning: ")
      for (meeting <- meetingsForTheDay) {
        if (meeting.time.contains("am")) {

          println(s"  ${meeting.time}: ${meeting.name}\n")
        }
      }
      println(s"$day afternoon: ")
        for (meeting <- meetingsForTheDay) {
          if (meeting.time.contains("pm")) {

            println(s"  ${meeting.time}: ${meeting.name}\n")
          }
      }
    }
  }
}

class Meeting (val name: String, val day: String, val time: String)

object Main extends App {
  println("** Welcome! Here is your agenda for the coming days **")
  val m1 = new Meeting("Retro", "Friday", "5pm")
  val m2 = new Meeting("Yoga", "Tuesday", "10am")
  val m3 = new Meeting("Team Meeting", "Tuesday", "3pm")
  val agenda = new Agenda(List(m1, m2, m3))
  agenda.printDaySchedule("Monday")
  agenda.printDaySchedule("Tuesday")
  agenda.printDaySchedule("Friday")
}
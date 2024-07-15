/*
Below are two implementations of an Agenda class.
Both can be used to print the user's upcoming meetings to the console.
The first implementation using more object-oriented programming paradigms
  (using a for loop to iterate through the list of meetings)
The second implementation uses more functional programming paradigms
  (functions without side effects, immutable variables, combining simple functions together)
 */


class Agenda(val meetings: List[Meeting]) {

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


class FunctionalAgenda(val meetings: List[Meeting]) {

  def printDaySchedule(day: String): Unit = {
    val meetingsForTheDay = meetings.filter(_.day == day)

    if (meetingsForTheDay.isEmpty) {
      println(s"$day: ")
      println(s"There are no meetings on $day\n")
    } else {
      val morningMeetings = meetingsForTheDay.filter(_.time.contains("am"))
      val afternoonMeetings = meetingsForTheDay.filter(_.time.contains("pm"))

      println(s"$day morning: ")
      printMeetings(morningMeetings)

      println(s"$day afternoon: ")
      printMeetings(afternoonMeetings)
    }
  }


  def printMeetings(meetings: List[Meeting]): Unit = {
    if (meetings.isEmpty) {
    } else {
      val meeting = meetings.head
      println(s"  ${meeting.time}: ${meeting.name}\n")
      printMeetings(meetings.tail)
    }
  }
}

class Meeting(val name: String, val day: String, val time: String)

object Main extends App {
  println("** Welcome! Here is your agenda for the coming days **")
  val m1 = new Meeting("Retro", "Friday", "5pm")
  val m2 = new Meeting("Yoga", "Tuesday", "10am")
  val m3 = new Meeting("Team Meeting", "Tuesday", "3pm")
  val agenda = new Agenda(List(m1, m2, m3))
  agenda.printDaySchedule("Monday")
  agenda.printDaySchedule("Tuesday")
  agenda.printDaySchedule("Friday")
  println("\n************************************************************\n")
  println("** Welcome! Here is your functional agenda for the coming days **")
  val fm1 = new Meeting("Retro", "Friday", "5pm")
  val fm2 = new Meeting("Yoga", "Tuesday", "10am")
  val fm3 = new Meeting("Team Meeting", "Tuesday", "3pm")
  val fagenda = new FunctionalAgenda(List(fm1, fm2, fm3))
  fagenda.printDaySchedule("Monday")
  fagenda.printDaySchedule("Tuesday")
  fagenda.printDaySchedule("Friday")
}
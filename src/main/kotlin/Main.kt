// Matthew Rapp
// CSE 310
// Sprint 3
// Player Stat System

import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

fun main(args: Array<String>) {
    do {
        // prompt the user on what to do
        print("What action would you like to do?" +
                "\n0 - QUIT PROGRAM" +
                "\n1 - Register a new student" +
                "\n2 - Register a new teacher \n")

        when (readLine()!!.toInt()) {
            0 -> {
                print("\nHave a great day!")
                break
            }
            1 -> registerNewStudent()
            2 -> registerTeacher()
        }
    } while (true)
}

fun registerNewStudent() {
    // prompt the user to ask how many players they want to enter into the system
    print("Enter number of new students to enroll: ")
    val numOfStudents: Int = readLine()!!.toInt()

    val studentList: MutableList<Student> = mutableListOf()

    for (i in 1..numOfStudents) {
        var tuitionBal = 0
        val costOfCourse = 600

        // prompt user for first name
        print("Enter student first name: ")
        val firstName: String = readLine()!!.toString()

        // prompt user for last name
        print("Enter student last name: ")
        val lastName: String = readLine()!!.toString()

        // prompt user for grade year
        print("1 - Freshman\n2 - Softmore\n3 - Junior\n4 - Senior\nEnter student class year: ")
        val gradeYear: Int = readLine()!!.toInt()

        // generate random id here
        val studentId: String = renderStudentId(firstName, lastName, gradeYear)

        // implement logic to register a student to any number of courses
        // create courses string to store the course in
        var courses = ""
        do {
            // prompt the user
            print("Enter course to enroll (Q to quit): ")
            val course: String = readLine()!!.toString()

            // break the loop if user pressed Q
            when(course) {
                "Q" -> break
                "q" -> break
            }

            // add course to courses
            courses += "$course, "
            // add the cost of the course to the tuition balance
            tuitionBal += costOfCourse

        } while (true) // until the user breaks the loop

        // generate student obj
        val student: Student = Student(firstName, lastName, gradeYear, studentId, courses, tuitionBal)
        // append student to array
        studentList.add(i-1, student)

        // filename/filepath
        val fileName = "student.txt"
        // see if file already exists and pass true/false into the helper writer function
        val boolean: Boolean = File(fileName).exists()
        // write that teacher to file
        writeToFile(fileName, student.toString(), boolean)

    }
}

fun registerTeacher() {
    // prompt the user to ask how many players they want to enter into the system
    print("Enter number of new teachers to register: ")
    val numOfTeachers: Int = readLine()!!.toInt()

    // create empty array to store teachers in
    val teacherList: MutableList<Teacher> = mutableListOf()

    // loop through numOfTeachers, that's how many teachers will be implemented into the txt file
    for (i in 1..numOfTeachers) {
        // starting salary
        var finalSalary = 32000
        // salary added per class they teach
        val additionalSalaryPerClass = 1000

        // prompt user for first name
        print("Enter teacher first name: ")
        val firstName: String = readLine()!!.toString()

        // prompt user for last name
        print("Enter teacher last name: ")
        val lastName: String = readLine()!!.toString()

        // prompt user for degree level
        print("1 - Associates\n2 - Bachelors\n3 - Masters\n4 - Doctoral\nEnter teacher degree level: ")
        val dL: Int = readLine()!!.toInt()
        // convert the user input into a string
        val degreeLevel: Degree = Degree.associates
        when (dL) {
            1 -> degreeLevel == Degree.associates // use Enum class to convert number to value
            2 -> degreeLevel == Degree.bachelors // use Enum class to convert number to value
            3 -> degreeLevel == Degree.masters // use Enum class to convert number to value
            4 -> degreeLevel == Degree.doctoral // use Enum class to convert number to value
        }

        // generate random id here
        val teacherId: String = renderTeacherId(firstName, lastName, degreeLevel)

        // implement logic to register a teacher to teach number of courses
        // create courses string to store the course in
        var courses = ""
        do {
            // prompt the user
            print("Enter course(s) that teacher will teach (Q to quit): ")
            val course: String = readLine()!!.toString()

            // break the loop if they press Q
            when(course) {
                "Q" -> break
                "q" -> break
            }

            // add course to courses
            courses += "$course, "
            // add to final salary
            finalSalary += additionalSalaryPerClass

        } while (true) // until the user breaks the loop

        // generate student obj
        val teacher: Teacher = Teacher(firstName, lastName, degreeLevel, teacherId, courses, finalSalary)
        // append student to array
        teacherList.add(i-1, teacher)

        // filename/filepath
        val fileName = "teacher.txt"
        // see if file already exists and pass true/false into the helper writer function
        val boolean: Boolean = File(fileName).exists()
        // write that teacher to file
        writeToFile(fileName, teacher.toString(), boolean)
    }
}


// helper methods here

// generate a random student id
fun renderStudentId(ln: String, fn: String, gy: Int): String {
    return ln.substring(0, 3) + "-" + gy.toString() + fn.length.toString() + ln.length.toString()
}

// generate a random teacher id
fun renderTeacherId(ln: String, fn: String, dl: Degree): String {
    return "teach_" + ln.substring(0, 3) + "-" + dl + "-" + fn.length.toString() + ln.length.toString()
}

// write string to txt file
fun writeToFile(fn: String, sToWrite: String, append: Boolean) {
    try {
        // create file && check if already exists
        val myFile = File(fn)
        // create new filewriter class
        val fw = FileWriter(myFile, append)
        // create a print writer class
        val pw = PrintWriter(fw)
        // print file to new line
        pw.println(sToWrite)
        // close print writer
        pw.close()
    } catch(e: Exception) {
        e.printStackTrace()
    } finally {
        println("______________")
    }
}

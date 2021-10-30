class Student
    (
    firstName: String,
    lastName: String,
    gradeYear: Int,
    studentId: String,
    courses: String,
    tuitionBal: Int
) {

    private var firstName: String = firstName
    private var lastName: String = lastName
    private var gradeYear: Int = gradeYear
    private var studentId: String = studentId
    private var courses: String = courses
    private var tuitionBal: Int = tuitionBal

    // get first name
    fun getFirstName(): String = this.firstName

    // set first name
    fun setFirstName(firstName: String): Unit {
        this.firstName = firstName
    }

    // get last name
    fun getLastName(): String = this.lastName

    // set last name
    fun setLastName(lastName: String): Unit {
        this.lastName = lastName
    }

    // get grade year
    fun getGradeYear(): Int = this.gradeYear

    // set grade year
    fun setGradeYear(gradeYear: Int): Unit {
        this.gradeYear = gradeYear
    }

    // get student id
    fun getStudentId(): String = this.studentId

    // set student id
    fun setStudentId(studentId: String): Unit {
        this.studentId = studentId
    }

    // get courses
    fun getEnrolledCourses(): String = this.courses

    // set courses

    // get balance
    fun getBalance(): Int = this.tuitionBal

    // pay balance
    fun payBalance(tuitionBal: Int) {
        this.tuitionBal = this.tuitionBal - tuitionBal
    }

    override fun toString(): String {
        return "$firstName | $lastName | " +
                "$gradeYear | " +
                "$studentId | " +
                "$courses | " +
                "$tuitionBal"
    }

}
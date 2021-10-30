enum class Degree {
    associates,
    bachelors,
    masters,
    doctoral
}

class Teacher
    (
    firstName: String,
    lastName: String,
    degree: Enum<Degree>,
    teacherId: String,
    courses: String,
    salary: Int
) {
    private var firstName: String = firstName
    private var lastName: String = lastName
    private var degree: Enum<Degree> = degree
    private var teacherId: String = teacherId
    private var courses: String = courses
    private var salary: Int = salary

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
    fun getDegree(): Enum<Degree> = this.degree

    // set grade year
    fun setDegree(degree: Degree): Unit {
        this.degree = degree
    }

    // get teacher id
    fun getTeacherId(): String = this.teacherId

    // set teacher id
    fun setTeacherId(teacherId: String): Unit {
        this.teacherId = teacherId
    }

    // get courses
    fun getCourses(): String = this.courses

    // set courses

    // get salary
    fun getSalary(): Int = this.salary

    // set salary
    fun setSalary(salary: Int): Unit {
        this.salary = salary
    }

    override fun toString(): String {
        return "$firstName | $lastName | " +
                "$degree | " +
                "$teacherId | " +
                "$courses | " +
                "$salary"
    }
}